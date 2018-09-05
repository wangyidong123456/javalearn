package com.igeek.ssm.service;

import java.util.List;

import com.igeek.ssm.po.Item;

public interface ItemService {
	/**
	 * 查询商品列表
	 * 
	 * @return
	 */
	List<Item> queryItemList();
	
	Item queryById(Integer id);

	void updateItem(Item item);

}
