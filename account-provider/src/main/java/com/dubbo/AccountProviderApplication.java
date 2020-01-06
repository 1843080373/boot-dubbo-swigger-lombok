package com.dubbo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;

@SpringBootApplication
@EnableDubbo
public class AccountProviderApplication{

	private static final Logger logger = LoggerFactory.getLogger(AccountProviderApplication.class);

	public static void main(String[] args) {
		logger.info("### Spring boot AccountProviderApplication starter ...");
		SpringApplication.run(AccountProviderApplication.class, args);
	}

}
