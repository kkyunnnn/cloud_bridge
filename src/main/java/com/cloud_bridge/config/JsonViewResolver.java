package com.cloud_bridge.config;


import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * <pre>
 * com.knk.spring4.config
 * JsonViewResolver.java
 * </pre>
 *
 * @author	KIM_NAKKYUN
 * @date	2017. 12. 5.
 * @brief	ViewResolver를 구현한 JsonViewResolver
 * 
 */
public class JsonViewResolver implements ViewResolver {
	
	private static final Logger logger = LoggerFactory.getLogger(JsonViewResolver.class);

	public View resolveViewName(String viewName, Locale locale) throws Exception {
		
		logger.info("resolveViewName");
		
		MappingJackson2JsonView view = new MappingJackson2JsonView();
		view.setPrettyPrint(true);
		return view;
	}

}
