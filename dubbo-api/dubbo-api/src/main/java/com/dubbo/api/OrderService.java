package com.dubbo.api;

import javax.validation.constraints.NotNull;

public interface OrderService {
	
	public void pay(@NotNull(message = "订单号不能为空")Long accountId);
}
