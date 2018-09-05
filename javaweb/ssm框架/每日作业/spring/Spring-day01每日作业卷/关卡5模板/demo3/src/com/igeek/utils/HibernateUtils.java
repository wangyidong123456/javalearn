package com.igeek.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * �����ֻࣺ����һ�������ļ�������SessionFactory����
 * @author Administrator
 */
public class HibernateUtils {
	
	// ����һ����ֵ ctrl + shift + x
	private static final Configuration CONFIG;
	private static final SessionFactory FACTORY;
	
	// ��̬�����
	static{
		// HibernateUtils�����ص�ʱ�򣬾�̬������ִ��
		// ����srcĿ¼��hibernate.cfg.xml
		CONFIG = new Configuration().configure();
		// ����SessionFactory����
		FACTORY = CONFIG.buildSessionFactory();
	}
	
	/**
	 * ��ȡ��Session����
	 * @return
	 */
	public static Session openSession(){
		return FACTORY.openSession();
	}
	
	/**
	 * �ӵ�ǰ�߳��л�ȡ���󶨵�session����
	 * @return
	 */
	public static Session getCurrentSession(){
		// �ӵ�ǰ�߳��л�ȡ���󶨵�session����
		return FACTORY.getCurrentSession();
	}
	
	public static void main(String[] args) {
		openSession();
	}

}
