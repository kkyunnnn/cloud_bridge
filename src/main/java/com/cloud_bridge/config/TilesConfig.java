package com.cloud_bridge.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

/**
 * <pre>
 * com.knk.spring4.config
 * TilesConfig.java
 * </pre>
 *
 * @author	KIM_NAKKYUN
 * @date	2017. 12. 5.
 * @brief	
 * 
 */
@Configuration
public class TilesConfig {
	
	private static final Logger logger = LoggerFactory.getLogger(TilesConfig.class);
	
	/**
	 * <pre>
	 * @return
	 * </pre>
	 *
	 * @author	KIM_NAKKYUN
	 * @date	2017. 12. 7.
	 * @brief	tiles 기본세팅
	 *
	 */
	@Bean
	public TilesConfigurer tileConfigurer() {
		logger.info("tileConfigurer");
		final TilesConfigurer configurer = new TilesConfigurer();
		configurer.setDefinitions(new String[] {"WEB-INF/tiles/tiles-config.xml"});
		configurer.setCheckRefresh(true);
		return configurer;
	}
	
	/**
	 * <pre>
	 * @return
	 * </pre>
	 *
	 * @author	KIM_NAKKYUN
	 * @date	2017. 12. 7.
	 * @brief	resolver 연결
	 *
	 */
	@Bean
	public TilesViewResolver tilesViewResolver() {
		logger.info("tilesViewResolver");
		final TilesViewResolver resolver = new TilesViewResolver();
		resolver.setViewClass(TilesView.class);
		resolver.setOrder(0);
		return resolver;
		
	}
}
