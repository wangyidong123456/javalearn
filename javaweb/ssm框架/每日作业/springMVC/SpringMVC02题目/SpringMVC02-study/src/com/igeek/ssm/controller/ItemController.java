package com.igeek.ssm.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.igeek.ssm.pojo.Item;
import com.igeek.ssm.pojo.QueryVo;
import com.igeek.ssm.service.ItemService;

@Controller
@RequestMapping("item")
public class ItemController {

	@Autowired
	private ItemService itemService;

	@RequestMapping("itemList")
	public String queryItemList(Model model) {
		List<Item> itemList = this.itemService.queryItemList();
		model.addAttribute("itemList", itemList);
		return "itemList";
	}

	@RequestMapping("itemEdit")
	public String queryItemById(Model model, @RequestParam("id") Integer itemId) {
		Item item = this.itemService.queryItemById(itemId);
		model.addAttribute("item", item);
		return "itemEdit";
	}

}
