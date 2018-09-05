package com.igeek.mybatis.pojo;

import java.util.List;

public class QueryVo {
	// 包含其他的pojo
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
