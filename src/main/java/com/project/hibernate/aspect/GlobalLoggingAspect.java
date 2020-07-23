package com.project.hibernate.aspect;


import java.util.Calendar;
import java.util.TimeZone;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class GlobalLoggingAspect {

    // @Around("com.demo.controller.HomeController.home(..)")
    @Around("execution(* com.project..*.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {

        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("+05:30"));

        StopWatch sw = new StopWatch();
        sw.start();
        Logger logger = LoggerFactory.getLogger(this.getClass());
        Object result = pjp.proceed();
        sw.stop();
        // logger.info("Time to execute the method " +
        // pjp.getSignature().getName() + " is :" + sw.getTotalTimeMillis());

        logger.info(new StringBuilder("#Timestamp: ").append(cal.getTime()).append(" #Class: ")
                .append(pjp.getTarget().getClass()).append(" #Method: ").append(pjp.getSignature().getName())
                .append(" #Execution Time: ").append(sw.getTotalTimeMillis()).append(" ms").toString());

        return result;
    }

}