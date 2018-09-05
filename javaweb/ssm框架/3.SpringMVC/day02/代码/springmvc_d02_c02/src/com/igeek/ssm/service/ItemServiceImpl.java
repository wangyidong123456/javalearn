package com.igeek.ssm.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igeek.ssm.mapper.ItemMapper;
import com.igeek.ssm.po.Item;

@Service
public class ItemServiceImpl implements ItemService {

	//创建dao代理类
	@Autowired
	private ItemMapper itemMapper;
	
	@Override
	public List<Item> queryItemList() {
		List<Item> items = itemMapper.selectByExample(null);
		return items;
	}

	@Override
	public Item queryById(Integer id) {
		return itemMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateItem(Item item) {
		itemMapper.updateByPrimaryKey(item);
		
	}
	
	

}
