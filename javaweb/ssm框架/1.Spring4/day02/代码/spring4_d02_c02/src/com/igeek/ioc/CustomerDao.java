package com.igeek.ioc;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

@Repository(value="customerDao")
//@Resource(name="customerDao")

public class CustomerDao {
	public  void save(){
		System.out.println("CustomerDao==save");
	}
}
