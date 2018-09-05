package com.igeek.ssm.po;

import java.util.List;

public class QueryVo {
	private Item item;
	
	private String[] ids;
	
	//列表类型数据
	private List<Item> itemList;
	

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
}
