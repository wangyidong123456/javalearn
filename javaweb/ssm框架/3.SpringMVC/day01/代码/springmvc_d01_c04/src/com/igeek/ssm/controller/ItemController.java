package com.igeek.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.igeek.ssm.po.Item;
import com.igeek.ssm.po.QueryVo;
import com.igeek.ssm.service.ItemService;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/itemList")
	public ModelAndView queryAll(){
		//调用service层获取数据
		List<Item> items = itemService.queryItemList();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemList", items);
		//返回视图
		modelAndView.setViewName("itemList");
		return modelAndView;
	}
	
	@RequestMapping("/itemEdit")
	public String queryById(@RequestParam(value="id",required=true,defaultValue="1") Integer id,ModelMap model){
		//接收id参数
		Item item = itemService.queryById(id);
		model.addAttribute("item", item);
		return "editItem";
	}
	@RequestMapping("/updateitem")
	public String updateItem(Item item){
		itemService.updateItem(item);
		return "success";
	}
	
	@RequestMapping("/queryItem")
	public String queryItem(QueryVo queryVo){
		System.out.println(queryVo.getItem().getId());
		System.out.println(queryVo.getItem().getName());
		return "success";
	}
	
	
}
