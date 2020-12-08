package com.briup.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.briup.bean.Book;

/**
 * @author matingting
 * 书籍的映射接口
 */
public interface BookMapper {
	
	//查找前三本书
	//List<Book> findFirstThreeBook();
	
	//查询数据库中的书的总数
	int count();
		
	//查找最后六本书
	//List<Book> findLastSixBook(int count);
	
	//查找前三本书或者最后六本书
	List<Book> findBook(@Param(value = "count") Integer count);
	
	Book findBookById(int id);
}
