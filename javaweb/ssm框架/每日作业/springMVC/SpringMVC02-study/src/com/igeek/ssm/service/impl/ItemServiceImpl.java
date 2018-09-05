package com.igeek.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igeek.ssm.mapper.ItemMapper;
import com.igeek.ssm.pojo.Item;
import com.igeek.ssm.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemMapper itemMapper;

	@Override
	public List<Item> queryItemList() {
		List<Item> list = this.itemMapper.selectByExample(null);
		return list;
	}

	@Override
	public Item queryItemById(int id) {
		Item item = this.itemMapper.selectByPrimaryKey(id);
		return item;
	}

	@Override
	public void updateItem(Item item) {
		this.itemMapper.updateByPrimaryKeySelective(item);
	}

}
