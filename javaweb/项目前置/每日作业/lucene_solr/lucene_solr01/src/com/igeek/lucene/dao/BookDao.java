package com.igeek.lucene.dao;

import java.util.List;

import com.igeek.lucene.pojo.Book;

public interface BookDao {

	/**
	 * 查询所有的book数据
	 * 
	 * @return
	 */
	List<Book> queryBookList();
}
