package com.briup.service;

import java.util.List;

import com.briup.bean.Category;

/**
 * @author matingting
 * 书籍逻辑层接口
 */
public interface ICategoryService {
	
	//查找一级分类和其所对应的所有二级分类
	List<Category> findCategories();
	
}
