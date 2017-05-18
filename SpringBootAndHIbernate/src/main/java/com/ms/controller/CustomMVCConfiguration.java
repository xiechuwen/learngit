package com.ms.controller;

import java.nio.charset.Charset;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class CustomMVCConfiguration extends  WebMvcConfigurerAdapter{

	  @Bean
	    public HttpMessageConverter<String> responseBodyConverter() {
	        StringHttpMessageConverter converter = new StringHttpMessageConverter(
	                Charset.forName("UTF-8"));
	        return converter;
	    }
	
	
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		// TODO Auto-generated method stub
		 configurer.favorPathExtension(false);
	}

	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		// TODO Auto-generated method stub
		super.extendMessageConverters(converters);
		 converters.add(responseBodyConverter());
	}
	
	
}
