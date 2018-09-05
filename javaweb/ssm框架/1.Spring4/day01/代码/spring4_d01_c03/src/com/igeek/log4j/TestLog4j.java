package com.igeek.log4j;

import org.apache.log4j.Logger;
import org.junit.Test;

public class TestLog4j {
	//运行TestLog4j类时记录日志
	Logger log = Logger.getLogger(TestLog4j.class);
	
	@Test
	public void test(){
		System.out.println("test");
		log.info("test log4j");
	}
}
