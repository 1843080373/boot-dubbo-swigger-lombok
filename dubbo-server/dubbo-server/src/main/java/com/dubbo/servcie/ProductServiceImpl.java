package com.dubbo.servcie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.dubbo.config.annotation.Service;
import com.dubbo.api.ProductService;
import com.dubbo.bean.Product;


@Service(version = "1.0.0")
public class ProductServiceImpl implements ProductService {
	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
	private static List<Product> ps = new ArrayList<>();
	static {
		ps = Arrays.asList(
				new Product().setId("1").setName("Honor V10").setBrand("TEL").setBrand("HUAWEI").setPrice(2499d).setCategory("手机"),
				new Product().setId("2").setName("IOS 2").setBrand("IOS").setBrand("IPHONE").setPrice(8999d).setCategory("手机"));
	}

	@Override
	public List<Product> findById(String id) {
		if(!"".equals(id)) {
			ps.stream().filter(p -> id.equals(p.getId())).collect(Collectors.toList());;
		}
		return ps;
	}
}
