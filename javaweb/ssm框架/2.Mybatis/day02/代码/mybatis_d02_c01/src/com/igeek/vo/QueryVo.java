package com.igeek.vo;

import java.util.List;

import com.igeek.pojo.User;

public class QueryVo {
	private User user;
	
	private List<Integer> ids;
	
	
	

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
