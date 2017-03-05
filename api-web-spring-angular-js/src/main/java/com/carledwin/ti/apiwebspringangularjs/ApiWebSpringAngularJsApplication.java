package com.carledwin.ti.apiwebspringangularjs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.carledwin.ti.apiwebspringangularjs.ws.filter.TokenFilter;

@SpringBootApplication
public class ApiWebSpringAngularJsApplication {

	@Bean
	public FilterRegistrationBean filterJwt(){
		FilterRegistrationBean filter = new FilterRegistrationBean();
		filter.setFilter(new TokenFilter());
		filter.addUrlPatterns("/admin/*");
		return filter;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ApiWebSpringAngularJsApplication.class, args);
	}
}
