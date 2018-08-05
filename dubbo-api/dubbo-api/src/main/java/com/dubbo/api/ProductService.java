package com.dubbo.api;

import com.dubbo.bean.Product;

public interface ProductService {
	public Product findById(String id);
}
