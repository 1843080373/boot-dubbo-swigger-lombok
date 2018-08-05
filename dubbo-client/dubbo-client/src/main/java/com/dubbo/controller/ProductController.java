package com.dubbo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dubbo.api.ProductService;
import com.dubbo.bean.Product;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
public class ProductController {
	
	@Reference(version="1.0.0")
	private ProductService productService;
	/**
	 * 根据ID查询用户
	 * @param id
	 * @return
	 */
	@ApiOperation(value="获取商品详细信息", notes="根据url的id来获取商品详细信息")
	@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
	@RequestMapping(value="/products/{id}", method=RequestMethod.GET)
	public List<Product> findById(@PathVariable(value="id") String id) {
		return productService.findById(id);
	}
}
