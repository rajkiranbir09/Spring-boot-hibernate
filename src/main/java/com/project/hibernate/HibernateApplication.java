package com.project.hibernate;

import com.project.hibernate.config.batch.BatchConfiguration;
import org.hibernate.SessionFactory;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.env.Environment;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.PlatformTransactionManager;

import javax.jms.ConnectionFactory;
import javax.sql.DataSource;
import java.util.Properties;


//@EnableAutoCo
// @EnableSchedulingnfiguration
//@EnableElasticsearchRepositories(basePackages = "com.project.hibernate.elasticsearch")
//@EnableElasticsearchRepositories(includeFilters=@ComponentScan.Filter(type= FilterType.ASSIGNABLE_TYPE,value=ElasticsearchRepository.class))
//@EnableJpaRepositories("com.project.hibernate.entity")
@SpringBootApplication
@EnableCaching // caching enabled with redis
@EnableAsync
@EnableScheduling
@EnableJms // enable jms
public class HibernateApplication {

	// add the jms template
	public static JmsTemplate jmsTemplate;


	@Bean
	public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory,
													DefaultJmsListenerContainerFactoryConfigurer configurer) {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		configurer.configure(factory, connectionFactory);
		return factory;
	}

	@Bean
	public MessageConverter jacksonJmsMessageConverter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");
		return converter;
	}
//	@Autowired
//	private Environment env;

	public static void main(String[] args) {
		SpringApplication.run(HibernateApplication.class, args);
	}
//
//	@Bean(name = "dataSource")
//	public DataSource getDataSource() {
//
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//
//		// See: application.properties
//		dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
//
//		dataSource.setUrl(env.getProperty("spring.datasource.url"));
//
//		dataSource.setUsername(env.getProperty("spring.datasource.username"));
//
//		dataSource.setPassword(env.getProperty("spring.datasource.password"));
//
//		System.out.println("## getDataSource: " + dataSource);
//
//		return dataSource;
//	}
//
//	@Autowired
//	@Bean(name = "sessionFactory")
//	public SessionFactory getSessionFactory(DataSource dataSource) throws Exception {
//		Properties properties = new Properties();
//
//		// See: application.properties
//		properties.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));
//		properties.put("hibernate.show_sql", env.getProperty("spring.jpa.show-sql"));
////		properties.put("current_session_context_class", //
////				env.getProperty("spring.jpa.properties.hibernate.current_session_context_class"));
//
//
//		// Fix Postgres JPA Error:
//		// Method org.postgresql.jdbc.PgConnection.createClob() is not yet implemented.
//		// properties.put("hibernate.temp.use_jdbc_metadata_defaults",false);
//
//		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
//
//		// Package contain entity classes
//		factoryBean.setPackagesToScan(new String[] { "" });
//		factoryBean.setDataSource(dataSource);
//		factoryBean.setHibernateProperties(properties);
//		factoryBean.afterPropertiesSet();
//		//
//		SessionFactory sf = factoryBean.getObject();
//		System.out.println("## getSessionFactory: " + sf);
//		return sf;
//	}
//
//	@Autowired
//	@Bean(name = "transactionManager")
//	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
//		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
//
//		return transactionManager;
//	}



}
