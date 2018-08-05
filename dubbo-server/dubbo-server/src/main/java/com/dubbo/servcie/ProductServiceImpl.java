package com.dubbo.servcie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.alibaba.dubbo.config.annotation.Service;
import com.dubbo.api.ProductService;
import com.dubbo.bean.Product;


@Service(version = "1.0.0")
public class ProductServiceImpl implements ProductService {

	private static List<Product> ps = new ArrayList<>();
	static {
		ps = Arrays.asList(
				new Product().setId("1").setName("Honor V10").setBrand("TEL").setBrand("HUAWEI").setPrice(2499d).setCategory("手机"),
				new Product().setId("2").setName("IOS 2").setBrand("IOS").setBrand("IPHONE").setPrice(8999d).setCategory("手机"));
	}

	@Override
	public Product findById(String id) {
		return ps.stream().filter(p -> id.equals(p.getId())).findFirst().get();
	}
}
