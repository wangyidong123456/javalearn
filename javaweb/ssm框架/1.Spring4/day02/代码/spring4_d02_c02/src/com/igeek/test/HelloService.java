package com.igeek.test;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Service(value="helloService")
public class HelloService {
	public void sayHello(){
		System.out.println("hello world");
	}
}
