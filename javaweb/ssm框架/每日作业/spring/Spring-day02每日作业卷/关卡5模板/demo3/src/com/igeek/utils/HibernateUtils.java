package com.igeek.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 工具类：只加载一次配置文件，创建SessionFactory对象
 * @author Administrator
 */
public class HibernateUtils {
	
	// 常量一定赋值 ctrl + shift + x
	private static final Configuration CONFIG;
	private static final SessionFactory FACTORY;
	
	// 静态代码块
	static{
		// HibernateUtils被加载的时候，静态代码快就执行
		// 加载src目录下hibernate.cfg.xml
		CONFIG = new Configuration().configure();
		// 构建SessionFactory对象
		FACTORY = CONFIG.buildSessionFactory();
	}
	
	/**
	 * 获取到Session对象
	 * @return
	 */
	public static Session openSession(){
		return FACTORY.openSession();
	}
	
	/**
	 * 从当前线程中获取到绑定的session对象
	 * @return
	 */
	public static Session getCurrentSession(){
		// 从当前线程中获取到绑定的session对象
		return FACTORY.getCurrentSession();
	}
	
	public static void main(String[] args) {
		openSession();
	}

}
