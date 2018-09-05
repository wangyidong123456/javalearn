package com.igeek.ssm.service;

import java.util.List;

import com.igeek.ssm.pojo.Item;

public interface ItemService {

	/**
	 * 查询所有的商品数据
	 * 
	 * @return
	 */
	public List<Item> queryItemList();

	/**
	 * 根据商品id查询商品
	 * 
	 * @param id
	 * @return
	 */
	public Item queryItemById(int id);

	/**
	 * 更新商品
	 * 
	 * @param item
	 */
	public void updateItem(Item item);

}
