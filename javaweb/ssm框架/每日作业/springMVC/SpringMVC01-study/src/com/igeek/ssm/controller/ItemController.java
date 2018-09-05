package com.igeek.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.igeek.ssm.pojo.Item;
import com.igeek.ssm.pojo.QueryVo;
import com.igeek.ssm.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;

	@RequestMapping("itemList")
	public ModelAndView queryItemList() {
		// 使用service查询商品数据
		List<Item> itemList = this.itemService.queryItemList();

		// 创建ModelAndView
		ModelAndView modelAndView = new ModelAndView();

		// 设置数据到ModelAndView中
		modelAndView.addObject("itemList", itemList);

		// 设置逻辑视图
		modelAndView.setViewName("itemList");

		return modelAndView;
	}

	// 获取Request，从Request中获取请求参数，实现商品id的接收
	// 使用Model和返回String类型的方式向页面传递数据，实现商品编辑页面的数据回显
	public String queryItemById(Model model, HttpServletRequest request, @RequestParam("id") Integer itemId) {
		// 从request中获取id
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);

		Item item = this.itemService.queryItemById(itemId);
		model.addAttribute("item", item);

		return "itemEdit";
	}

	// 使用pojo接受请求的商品数据，实现商品的修改
	@RequestMapping("updateItem")
	public String updateItem(Item item) {
		this.itemService.updateItem(item);
		return "success";
	}

	// 创建包装类，包含了商品属性，用包装pojo接受查询条件，搜索功能在商品列表页
	@RequestMapping("queryItem")
	public String queryItem(QueryVo queryVo) {
		System.out.println(queryVo.getItem().getId());
		System.out.println(queryVo.getItem().getName());
		return "success";
	}

}
