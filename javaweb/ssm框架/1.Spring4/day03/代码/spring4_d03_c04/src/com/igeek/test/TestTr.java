package com.igeek.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.junit.Test;

import com.mysql.jdbc.PreparedStatement;


public class TestTr {
	@Test
	public void test() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql:///igeekspring", "root", "");
		Statement st = conn.createStatement();
		String sql = "update book set name = '浪潮之巅' where id = 8";
		String sql1 = "update book set name = '文明之光' where id = 7";
		
		try {
			//开启手动提交事务
			conn.setAutoCommit(false);
			st.executeUpdate(sql);
			st.executeUpdate(sql1);
			
			//事务2。。。savePoint2
			
			//事务3  savePoint3
			//手动提交事务
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		}
		
		
		conn.close();
	}
}
