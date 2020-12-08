package com.briup.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.bean.Book;
import com.briup.mapper.BookMapper;
import com.briup.service.IBookService;
import com.briup.util.MybatisSqlSessionFactoryUtil;

/**
 * @author matingting
 * 书籍逻辑层
 */
public class BookServiceImpl implements IBookService{

	@Override
	public List<Book> findFirstThreeBook() {
		SqlSession sqlSession = MybatisSqlSessionFactoryUtil.openSession();
		BookMapper mapper = sqlSession.getMapper(BookMapper.class);
		return mapper.findBook(null);
	}

	@Override
	public List<Book> findLastSixBook() {
		SqlSession sqlSession = MybatisSqlSessionFactoryUtil.openSession();
		BookMapper mapper = sqlSession.getMapper(BookMapper.class);
		//先查找总数
		int count = mapper.count();
		//查询最后六本书
		return mapper.findBook(count);
	}

	@Override
	public Book findBookById(int id) {
		SqlSession sqlSession = MybatisSqlSessionFactoryUtil.openSession();
		BookMapper mapper = sqlSession.getMapper(BookMapper.class);
		return mapper.findBookById(id);
	}

}
