package com.dubbo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class DubboClientApplication {
	private static final Logger logger = LoggerFactory.getLogger(DubboClientApplication.class);

	public static void main(String[] args) {
		logger.info("### Spring boot DubboClientApplication starter ...");
		SpringApplication.run(DubboClientApplication.class, args);
	}

}
