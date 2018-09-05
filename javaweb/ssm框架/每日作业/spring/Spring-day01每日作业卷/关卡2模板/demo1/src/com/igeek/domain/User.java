package com.igeek.domain;

import java.util.List;
import java.util.Properties;

public class User {
	
	private String name;
	private List<String> list;
	private Properties pros;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	public void setPros(Properties pros) {
		this.pros = pros;
	}
	
	public String toString() {
		return "User [name=" + name + ", list=" + list + ", pros=" + pros + "]";
	}
	
}
