package com.igeek.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;


public class TestConn {
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	@Test
	public void test(){
		try {
			//1.加在驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2.建立连接
			conn = DriverManager.getConnection("jdbc:mysql:///mybatis", "root", "");
			//3.创建Statement接口
			String sql = "SELECT * FROM `user` where id > ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, 10);
			//4.编写sql并执行
			
			//5.返回结果
			rs = pst.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"
						+rs.getString(3)+"\t"+rs.getString(4)+"\t"
						+rs.getString(5));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			//6.关闭连接
			if(conn!= null){
				if(pst!=null){
					try {
						pst.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
