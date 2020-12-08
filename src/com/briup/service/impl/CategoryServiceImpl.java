package com.briup.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.bean.Category;
import com.briup.mapper.CategoryMapper;
import com.briup.service.ICategoryService;
import com.briup.util.MybatisSqlSessionFactoryUtil;
/**
 * @author matingting
 * 书籍逻辑层
 */
public class CategoryServiceImpl implements ICategoryService{

	@Override
	public List<Category> findCategories() {
		//调用dao层去查询分类信息
		SqlSession sqlSession = MybatisSqlSessionFactoryUtil.openSession();
		CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
		return mapper.findCategories();
	}
}
