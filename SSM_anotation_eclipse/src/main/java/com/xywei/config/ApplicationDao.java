package com.xywei.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import com.xywei.exception.ExceptionDeal;

@Configuration
@EnableTransactionManagement
@PropertySource(value = { "classpath:jdbc.properties" })
public class ApplicationDao implements TransactionManagementConfigurer {

	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationDao.class);
	@Value("${jdbc.driverClassName}")
	private String driverClassName;
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.username}")
	private String username;
	@Value("${jdbc.password}")
	private String password;

	// new Integer.parseInt

	// Integer tt = Integer.parseInt(s)

	@Value("${initialSize}")
	private Integer initialSize;
	@Value("${maxTotal}")
	private Integer maxTotal;
	@Value("${minIdle}")
	private Integer minIdle;
	@Value("${maxIdle}")
	private Integer maxIdle;
	// @Value("#{java.lang.Integer.parseInt('${initialSize}')}")
	// private Integer initialSize;
	// @Value("#{java.lang.Integer.parseInt('${maxTotal}')}")
	// private Integer maxTotal;
	// @Value("#{java.lang.Integer.parseInt('${minIdle}')}")
	// private Integer minIdle;
	// @Value("#{java.lang.Integer.parseInt('${maxIdle}')}")
	// private Integer maxIdle;
	// // @Value("#{java.lang.Integer.parseInt('${initialSize}')}")
	// private Integer initialSize = 5;
	// // @Value("#{java.lang.Integer.parseInt('${maxTotal}')}")
	// private Integer maxTotal = 50;
	// // @Value("#{java.lang.Integer.parseInt('${minIdle}')}")
	// private Integer minIdle = 5;
	// // @Value("#{java.lang.Integer.parseInt('${maxIdle}')}")
	// private Integer maxIdle = 50;

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		LOGGER.info("jdbcurl" + url);
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setMaxTotal(maxTotal);
		dataSource.setMaxIdle(maxIdle);
		dataSource.setMinIdle(minIdle);
		dataSource.setInitialSize(initialSize);
		return dataSource;
	}

	@Bean
	public DataSourceTransactionManager txManager() {
		return new DataSourceTransactionManager(dataSource());
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		return sessionFactory.getObject();
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyconfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public ExceptionDeal exceptiondDeal() {
		ExceptionDeal exceptionDeal = new ExceptionDeal();
		return exceptionDeal;
	}

	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return txManager();
	}

}
