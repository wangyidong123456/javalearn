package com.igeek.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.igeek.domain.Book;
import com.mysql.jdbc.PreparedStatement;

@Repository
public class BookDao extends JdbcDaoSupport{
	//保存一本书
	public void save(){
		String sql ="insert into book values (null,?,?)";
		//pst.setString(1,"浪潮之巅")
		//pst.setDouble(2,50D)
		
		Book book = new Book();
		book.setName("浪潮之巅");//吴军
		book.setPrice(50D);
		
		this.getJdbcTemplate().update(sql,book.getName(),book.getPrice() );
	}
	
	public void update(){
		String sql = "update book set name = ? where  id = ?";
		this.getJdbcTemplate().update(sql,"java",2);
	}
	
	public void delete(){
		String sql = "delete from book where id = ?";
		this.getJdbcTemplate().update(sql, 2);
	}
	
	public void queryBook() throws SQLException{
		
		PreparedStatement pst = null;
		ResultSet rs = pst.executeQuery();
		while(rs.next()){
			int id = rs.getInt(1);
			String name = rs.getString(2);
			double price = rs.getDouble(3);
			
			Book b = new Book();
			b.setId(id);
			b.setName(name);
			b.setPrice(price);
		}
	}
	
	
	public Book findById(int id){
		String sql = "select * from book where id = ?";
		return this.getJdbcTemplate().queryForObject(sql,  new BookRowMapper(),id);
	}
	
	
	class BookRowMapper implements RowMapper<Book>{

		@Override
		public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
			//封装了一条数据
			Book b = new Book();
			b.setId(rs.getInt(1));
			b.setName(rs.getString(2));
			b.setPrice(rs.getDouble(3));
			return b;
		}
		
	}
	
	
	public List<Book> queryAll(){
		String sql = "select * from book";
		return this.getJdbcTemplate().query(sql, new BookRowMapper());
	}
	
	
	public List<Book> queryAllByCondition(String name){
		String sql = "select * from book where name like ?";
		return this.getJdbcTemplate().query(sql, new BookRowMapper(),"%"+name+"%");
	}
}
