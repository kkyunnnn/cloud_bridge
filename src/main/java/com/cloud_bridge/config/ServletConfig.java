package com.cloud_bridge.config;

import java.util.ArrayList;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.cloud_bridge.admin.interceptor.AdminBaseInterceptor;
import com.cloud_bridge.www.interceptor.FrontBaseInterceptor;


/**
 * <pre>
 * com.knk.spring4.config
 * ServletConfiguration.java
 * </pre>
 *
 * @author	KIM_NAKKYUN
 * @date	2017. 12. 5.
 * @brief	servlet-context.xml
 * 
 */
@Configuration										// 자바 기반의 설정임을 알려주는 어노테이션
@EnableWebMvc										// <mvc:annotation-driven>
@ComponentScan(basePackages = {"com.cloud_bridge"})	// <context:componet-scan> 
public class ServletConfig extends WebMvcConfigurerAdapter {

	private static final Logger logger = LoggerFactory.getLogger(ServletConfig.class);
	
	@Value("/resources/")
	private String staticResouceLocation;


	/**
	 * <pre>
	 * @param manager
	 * @return
	 * </pre>
	 *
	 * @author	KIM_NAKKYUN
	 * @date	2017. 12. 5.
	 * @brief	viewRsolver
	 *
	 */
	@Bean
	public ViewResolver setViewResolver(ContentNegotiationManager manager) {

		logger.info("setViewResolver");
		
		List<ViewResolver> resolvers = new ArrayList<ViewResolver>();

		InternalResourceViewResolver  resolver1 = new InternalResourceViewResolver();
		resolver1.setPrefix("/WEB-INF/views/");
		resolver1.setSuffix(".jsp");
		resolver1.setViewClass(JstlView.class);
		resolvers.add(resolver1);

		JsonViewResolver jsonViewResolver = new JsonViewResolver();
		resolvers.add(jsonViewResolver);

		ContentNegotiatingViewResolver resolver	= new ContentNegotiatingViewResolver();
		resolver.setViewResolvers(resolvers);
		resolver.setContentNegotiationManager(manager);
		resolver.setOrder(1);

		return resolver;
	}


	/**
	 * <pre>
	 * @return
	 * </pre>
	 *
	 * @author	KIM_NAKKYUN
	 * @date	2017. 12. 5.
	 * @brief	인터셉터 등록
	 *
	 */
	@Bean
	public AdminBaseInterceptor adminBaseInterceptor() {
		return new AdminBaseInterceptor();
	}
	
	@Bean
	public FrontBaseInterceptor frontBaseInterceptor() {
		return new FrontBaseInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(frontBaseInterceptor()).addPathPatterns("/**").excludePathPatterns("/admin/**");
		registry.addInterceptor(adminBaseInterceptor()).addPathPatterns("/admin/**");
	}

	/**
	 * <pre>
	 * @return
	 * </pre>
	 *
	 * @author	KIM_NAKKYUN
	 * @date	2017. 12. 5.
	 * @brief	프로퍼티 팩토리 생성
	 *
	 */
	@Bean
	public PropertiesFactoryBean properties() {
		PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
		propertiesFactoryBean.setLocation(new ClassPathResource("properties/config.properties"));
		return propertiesFactoryBean;
	}

	// 정적 리소스 파일 등록
	@Override 
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/assets/**").addResourceLocations(staticResouceLocation);
	}
	
	/**
	 * <pre>
	 * @return
	 * </pre>
	 *
	 * @author	KIM_NAKKYUN
	 * @date	2017. 12. 5.
	 * @brief	파일 업로드를 위한 multipartResolver
	 *
	 */
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver CreatMultipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(300000000);
		multipartResolver.setMaxInMemorySize(300000000);
		multipartResolver.setDefaultEncoding("utf-8");
		return multipartResolver;
	}
}
