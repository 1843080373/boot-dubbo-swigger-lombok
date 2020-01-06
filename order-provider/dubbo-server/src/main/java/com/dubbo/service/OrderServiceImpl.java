package com.dubbo.service;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.dubbo.api.AccountService;
import com.dubbo.api.OrderService;
import com.dubbo.bean.Account;
import com.dubbo.bean.Order;

@Service(validation = "true")
public class OrderServiceImpl implements OrderService {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Reference
	private AccountService accountService;
	
	public void addOrder(Order order) {
		String sql = "INSERT INTO `t_order` (`name`, `remark`, `created`) VALUES (?, ?, ?);";
	    jdbcTemplate.update(sql, order.getName(),order.getRemark(),order.getCreated());
	}

	@Override
	//@GlobalTransactional
	public void pay(Long accountId) {
		//System.out.println("开始全局事务。XID="+RootContext.getXID());
		Assert.notNull(accountId, "賬戶id不能為空");
		Order order=new Order();
		order.setName("iPhone 11");
		order.setRemark("到货付款");
		order.setCreated(new Date());
		addOrder(order);
		
		Account account=new Account();
		account.setName("张三");
		account.setId(accountId);
		account.setBalance(new BigDecimal(4599));
		accountService.substractAccount(account);
	}

}
