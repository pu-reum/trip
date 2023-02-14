package com.trip;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
	
	//web root가 아닌 외부 경로에 있는 리소스를 url로 불러올 수 있도록 설정
	//127.0.0.1/summernoteImage/1234.jpg -> C:/summernote_image/1234.jpg파일을 불러온다
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/summernoteImage/**")
				.addResourceLocations("file:///C:/summernote_image/");
	}

}
