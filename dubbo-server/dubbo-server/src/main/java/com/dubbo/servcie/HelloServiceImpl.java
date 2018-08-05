package com.dubbo.servcie;


import com.alibaba.dubbo.config.annotation.Service;
import com.dubbo.api.HelloService;

@Service(version="1.0.0")
public class HelloServiceImpl implements HelloService {

	@Override
	public String index(String name) {
		return "hello sping-boot dubbo,this is "+name;
	}

}
