package com.zipha;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})// Sprint Boot Auto Configuration
@ComponentScan(basePackages = "com.zipha")
@Configuration
public class BaseApplication extends SpringBootServletInitializer {
	 private static final Class<BaseApplication> APPLICATION_NAME = BaseApplication.class;
	    private final Logger logger = LoggerFactory.getLogger(APPLICATION_NAME);

	    public static void main(String[] args) {
	        SpringApplication.run(APPLICATION_NAME, args);
	        }
	    @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(APPLICATION_NAME);
	    }

	  
	    @Bean
	    public GroupedOpenApi  newsApi() {
	        return  GroupedOpenApi.builder()
	                .group("apis")
	                .pathsToMatch("/api.*")
	                .build();
	    }
}
