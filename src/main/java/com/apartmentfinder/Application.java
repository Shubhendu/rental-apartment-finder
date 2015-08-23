package com.apartmentfinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * @author singh_sh
 *
 */
@SpringBootApplication

public class Application extends SpringBootServletInitializer {
	public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}


	
}
