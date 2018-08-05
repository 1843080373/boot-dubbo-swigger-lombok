package com.dubbo.api;

import java.util.List;

import com.dubbo.bean.Product;

public interface ProductService {
	public List<Product> findById(String id);
}
