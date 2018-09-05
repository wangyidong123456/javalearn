package com.igeek.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.igeek.dao.BookDao;
import com.igeek.domain.Book;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class DaoTest {
	
	@Autowired
	private BookDao bookDao;
	
	@Test
	public void testBookDao(){
		bookDao.save();
	}
	
	@Test
	public void testUpdate(){
		bookDao.update();
	}
	@Test
	public void testDelete(){
		bookDao.delete();
	}
	
	@Test
	public void testQuery(){
		Book b = bookDao.findById(1);
		System.out.println(b);
	}
	
	@Test
	public void testQueryAll(){
		List<Book> books = bookDao.queryAll();
		for (Book book : books) {
			System.out.println(book);
		}
	}
	
	
	@Test
	public void tesQueryAllByCondition(){
		List<Book> books = bookDao.queryAllByCondition("西游");
		for (Book book : books) {
			System.out.println(book);
		}
	}
	
	
}
