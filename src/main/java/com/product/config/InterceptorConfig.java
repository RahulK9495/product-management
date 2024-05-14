package com.product.config;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class InterceptorConfig implements WebMvcConfigurer{
	
	
	public void addInterceptors (InterceptorRegistry registry)
	{
		registry.addInterceptor(new LoggingInterceptor());
	}

}
