/*package com.dubbo.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.seata.rm.datasource.DataSourceProxy;
import io.seata.spring.annotation.GlobalTransactionScanner;

@Configuration
public class SeataConfig {
	@Bean
	public DataSourceProxy dataSourceProxy(DataSource dataSource) {
	 return new DataSourceProxy(dataSource);
	}
	
	@Bean
	public GlobalTransactionScanner globalTransactionScanner() {
	 return new GlobalTransactionScanner("springboot-order", "my_test_tx_group");
	}
}
*/