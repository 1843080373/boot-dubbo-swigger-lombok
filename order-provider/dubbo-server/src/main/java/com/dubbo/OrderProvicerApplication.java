package com.dubbo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderProvicerApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(OrderProvicerApplication.class);

	public static void main(String[] args) {
		logger.info("### Spring boot OrderProvicerApplication starter ...");
		SpringApplication.run(OrderProvicerApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		logger.info("### Spring boot OrderProvicerApplication Server start ok!");
	}

}
