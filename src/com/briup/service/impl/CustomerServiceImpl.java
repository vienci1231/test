package com.briup.service.impl;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.briup.bean.Customer;
import com.briup.mapper.CustomerMapper;
import com.briup.service.ICustomerService;
import com.briup.util.MybatisSqlSessionFactoryUtil;

/**
 * @author matingting
 * 客户逻辑层
 */
public class CustomerServiceImpl implements ICustomerService{

	@Override
	public void register(Customer customer) throws Exception{
		//判断用户名重复还是不重复
		//调用dao完成用户名的查找
		try {
			InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			SqlSessionFactory  sqlSessionFactory= builder.build(stream);
			SqlSession sqlSession = sqlSessionFactory.openSession();
			
			CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
			Customer c = mapper.findCustomerByName(customer.getName());
			if(c!=null) {
				throw new Exception("用户名重复，请重新注册!");
			}
			//将用户信息保存
			mapper.insertCustomer(customer);
			//提交
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Customer login(String name, String password) throws Exception {
		SqlSession sqlSession = MybatisSqlSessionFactoryUtil.openSession();
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
		Customer customer = mapper.findCustomerByName(name);
		//用户名错误
		if(customer==null) {
			throw new  Exception("用户名错误，请重新输入!");
		}else {
			//判断密码 
			if(!password.equals(customer.getPassword())) {
				throw new Exception("密码错误，请重新输入！");
			}
		}
		return customer;
	}
}
