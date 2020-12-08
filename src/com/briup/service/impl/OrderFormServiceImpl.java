package com.briup.service.impl;

import java.nio.MappedByteBuffer;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.bean.OrderForm;
import com.briup.mapper.OrderFormMapper;
import com.briup.service.IOrderFormService;
import com.briup.util.MybatisSqlSessionFactoryUtil;
/**
 * 
 * @author matingting
 * 订单逻辑层实现类
 */
public class OrderFormServiceImpl implements IOrderFormService{

	@Override
	public void saveOrderForm(OrderForm form) {
		SqlSession sqlSession = MybatisSqlSessionFactoryUtil.openSession();
		OrderFormMapper mapper = sqlSession.getMapper(OrderFormMapper.class);
		mapper.insertOrderForm(form);
		sqlSession.commit();
	}

	@Override
	public List<OrderForm> getOrderForm() {
		SqlSession sqlSession = MybatisSqlSessionFactoryUtil.openSession();
		OrderFormMapper mapper = sqlSession.getMapper(OrderFormMapper.class);
		return mapper.findOrderFormWithShopAddress();
	}

}
