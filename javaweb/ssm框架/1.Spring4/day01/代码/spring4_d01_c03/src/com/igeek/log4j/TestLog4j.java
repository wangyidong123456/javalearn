package com.igeek.log4j;

import org.apache.log4j.Logger;
import org.junit.Test;

public class TestLog4j {
	//����TestLog4j��ʱ��¼��־
	Logger log = Logger.getLogger(TestLog4j.class);
	
	@Test
	public void test(){
		System.out.println("test");
		log.info("test log4j");
	}
}
