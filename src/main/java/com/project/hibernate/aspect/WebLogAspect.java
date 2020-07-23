package com.project.hibernate.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Random;

@Aspect
@Component
@Order(-5)
public class WebLogAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    private ThreadLocal<RequestMessage> requestMessage = new ThreadLocal<>();

    @Pointcut("execution(public * com.project.hibernate.controller..*.*(..))")
    public void webLog(){
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        RequestMessage message = new RequestMessage();
//        startTime.set(System.currentTimeMillis());
        //接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //记录下请求内容
//        logger.info("URL :" + request.getRequestURL().toString());
//        logger.info("HTTP_Method : " + request.getMethod());
//        logger.info("IP : " + request.getRemoteAddr());
//        logger.info("Class_Method :" + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
//        logger.info("Args : " + Arrays.toString(joinPoint.getArgs()));
        message.setMessage(request.getRequestURL().toString());
//        message.setIP(request.getRemoteAddr());
//        message.setArgs(Arrays.toString(joinPoint.getArgs()));
//        message.setEntryTime(System.currentTimeMillis());
//        message.setHttpMethod(request.getMethod());
        requestMessage.set(message);
        //获取所有参数方法一：
//        Enumeration<String> enumeration = request.getParameterNames();
//        while (enumeration.hasMoreElements()) {
//            String paramName = (String)enumeration.nextElement();
//            System.out.println(paramName + ":" + request.getParameter(paramName));
//        }
    }

    @AfterReturning("webLog()")
    public void doAfterReturning(JoinPoint  joinPoint) {
        RequestMessage message = this.requestMessage.get();
//        message.setDoneTime(System.currentTimeMillis());

        logger.info(message.toString());
    }
}
