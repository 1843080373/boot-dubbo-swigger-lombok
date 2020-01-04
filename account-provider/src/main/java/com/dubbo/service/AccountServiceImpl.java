package com.dubbo.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.dubbo.config.annotation.Service;
import com.dubbo.api.AccountService;
import com.dubbo.bean.Account;
import com.dubbo.exception.BusinessException;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private JdbcTemplate jdbcTemplate;


	@Override
	public void substractAccount(Account account) {
		Account myAccount = getOneById(account.getId());
		if(myAccount==null) {
			throw new BusinessException("賬戶不存在");
		}else if(myAccount.getBalance().compareTo(account.getBalance())<0) {
			throw new BusinessException("賬戶餘額不足");
		}
		String sql = "UPDATE `t_account` SET `balance` = `balance`- ?,`updated`=? WHERE id=?";
	    jdbcTemplate.update(sql, account.getBalance(),new Date(),account.getId());
	}

    private Account getOneById(Long id) {
    	Account account;
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT ")
                .append(" 	id,name,balance ")
                .append(" FROM ")
                .append(" 	t_account ")
                .append(" WHERE ")
                .append(" 	id = ? ");
        try {
        	account = jdbcTemplate.queryForObject(sql.toString(), new Object[]{id}, (rs, rowNum) -> {
        		Account temp = new Account();
                temp.setId(rs.getLong("id"));
                temp.setName(rs.getString("name"));
                temp.setBalance(rs.getBigDecimal("balance"));
                return temp;
            });
        } catch (Exception e) {
            return null;
        }
        return account;
    }

}
