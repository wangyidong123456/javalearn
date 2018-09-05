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

	@RequestMapping(value = "queryItem", method = RequestMethod.GET)
	public String queryItem(QueryVo queryVo, Integer[] ids) {

		System.out.println(queryVo.getIds().length);
		System.out.println(ids.length);

		return "success";
	}

	@RequestMapping("updateItem")
	public String updateItem(Item item, MultipartFile pictureFile, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// 重命名图片，这里使用UUID作为图片名
		UUID uuid = UUID.randomUUID();
		String oname = pictureFile.getOriginalFilename();
		String extName = oname.substring(oname.lastIndexOf("."));
		String picName = uuid + extName;

		pictureFile.transferTo(new File("C:/images/" + picName));
		item.setPic(picName);

		this.itemService.updateItem(item);

		// 使用request进行转发
		// request.getRequestDispatcher("/itemEdit.action").forward(request,
		// response);

		// 使用response进行重定向
		// response.sendRedirect("/SpringMVC02-study/itemEdit.action?id=" +
		// item.getId());

		// 使用转发
		// return "forward:/itemEdit.action";

		// 使用重定向
		return "redirect:/itemEdit.action?id=" + item.getId();

	}

	@RequestMapping("jsonTest")
	@ResponseBody
	public Item test(@RequestBody Item item) {
		return item;
	}

	@RequestMapping("item/{id}")
	public String queryItemById(@PathVariable("id") Integer id, Model model) {
		Item item = this.itemService.queryItemById(id);
		// 设置数据到模型中
		model.addAttribute("item", item);
		// 返回逻辑视图名
		return "itemEdit";
	}
}
