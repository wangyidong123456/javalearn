package com.igeek.springmvc.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.igeek.springmvc.pojo.Item;

@Controller
public class ItemController {
	//编写一个方法，处理显示商品列表
	//ModelAndView 容器，放置要返回的数据和页面
	//使用注解的方式处理显示商品列表的请求
	@RequestMapping("/itemList.action")
	public ModelAndView list(){
		//调用service--》dao--》返回数据
		List<Item> items = new ArrayList<>();
		
		items.add(new Item("苹果", 8.8d, new Date(), "圣诞节"));
		items.add(new Item("饺子", 18.8d, new Date(), "冬至"));
		items.add(new Item("手机", 1888d, new Date(), "元旦"));
		ModelAndView modelAndView = new ModelAndView();
		//加入返回数据
		modelAndView.addObject("itemList", items);
		//request.setAttribute("itemList", items)
		//跳转的页面
//		modelAndView.setViewName("/WEB-INF/jsp/itemList.jsp");
		modelAndView.setViewName("itemList");
		//request.getRequestDispatcher("/WEB-INF/jsp/itemList.jsp").forword("req","res");
		//把modelAndView返回给spring mvc框架去处理
		return modelAndView;
	}
	
}
