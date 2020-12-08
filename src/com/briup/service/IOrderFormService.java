package com.briup.service;

import java.util.List;

import com.briup.bean.OrderForm;

/**
 * 
 * @author matingting
 * 订单逻辑层接口
 */
public interface IOrderFormService {
	
	void saveOrderForm(OrderForm form);
	
	List<OrderForm> getOrderForm();

}
