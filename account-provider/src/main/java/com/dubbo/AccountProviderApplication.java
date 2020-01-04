package com.dubbo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccountProviderApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(AccountProviderApplication.class);

	public static void main(String[] args) {
		logger.info("### Spring boot AccountProviderApplication starter ...");
		SpringApplication.run(AccountProviderApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		logger.info("### Spring boot AccountProviderApplication Server start ok!");
	}

}
