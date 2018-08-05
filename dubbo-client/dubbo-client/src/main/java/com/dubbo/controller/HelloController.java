package com.dubbo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dubbo.api.HelloService;

@RestController
public class HelloController {

	@Reference(version="1.0.0")
	private HelloService helloService;

	@GetMapping("/index")
	private String index(String name) {
		return helloService.index(name);
	}
}
