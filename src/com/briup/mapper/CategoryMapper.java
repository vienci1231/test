package com.briup.mapper;

import java.util.List;

import com.briup.bean.Category;

/**
 * @author matingting
 * 书籍的映射接口
 */
public interface CategoryMapper {

	//查找一级分类和其所对应的所有二级分类
	List<Category> findCategories();
	
}
