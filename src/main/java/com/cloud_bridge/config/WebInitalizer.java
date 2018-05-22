package com.cloud_bridge.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * <pre>
 * com.knk.spring4.config
 * WebInitalizer.java
 * </pre>
 *
 * @author	KIM_NAKKYUN
 * @date	2017. 12. 5.
 * @brief	Web.xml을 java코드로 작성한다.
 * 
 */
public class WebInitalizer implements WebApplicationInitializer {

	private static final Logger logger = LoggerFactory.getLogger(WebInitalizer.class);

	public void onStartup(ServletContext servletContext) throws ServletException {

		logger.info("onStartup");

		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(ServletConfig.class);

		// 필터
		FilterRegistration.Dynamic filterRegistration = servletContext.addFilter("CharacterEncodingFilter", CharacterEncodingFilter.class);
		filterRegistration.setInitParameter("encoding", "utf-8");
		filterRegistration.setInitParameter("forceEncoding", "true");
		filterRegistration.addMappingForUrlPatterns(null, true, "/*");
		
		ctx.setServletContext(servletContext);

		Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
		servlet.addMapping(new String[] {"/"});
		servlet.setLoadOnStartup(1);
		
		/* 필터 왜 안되는지 몰겠음..		
		CharacterEncodingFilter characterencodingfilter = new CharacterEncodingFilter();
		characterencodingfilter.setEncoding("utf-8");
		characterencodingfilter.setForceEncoding(true);
		*/
	}
}
