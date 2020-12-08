package com.briup.service;

import java.util.List;

import com.briup.bean.Book;

/**
 * 
 * @author matingting
 * 书籍逻辑层接口
 */
public interface IBookService {
	
	//查找前三本书
	List<Book> findFirstThreeBook();
	
	//查找最后六本书
	List<Book> findLastSixBook();
	
	//根据id查找单本书
	Book findBookById(int id);
}
