package com.igeek.ssm.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.igeek.spring.exception.MyException;
import com.igeek.ssm.po.Item;
import com.igeek.ssm.po.QueryVo;
import com.igeek.ssm.service.ItemService;

@Controller
@RequestMapping("item")//在url上加了访问路径
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
//	@RequestMapping("/itemList")
	@RequestMapping(value={"itemList","itemAll"},method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView queryAll(){
		
			System.out.println("itemAll --- action");
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
//	@RequestMapping("/updateitem")
//	public String updateItem(Item item){
//		
//		
//		System.out.println(item.getCreatetime());
//		itemService.updateItem(item);
////		return "success";
////		return "redirect:/itemEdit.action?itemId=" + item.getId();
//		return "forward:/itemAll.action";
//		
//	}
	
	
	@RequestMapping("updateItem")
	public String updateItemById(Item item, MultipartFile pictureFile) throws Exception {
		// 图片上传
		// 设置图片名称，不能重复，可以使用uuid
		String picName = UUID.randomUUID().toString();

		// 获取文件名
		String oriName = pictureFile.getOriginalFilename();
		// 获取图片后缀
		String extName = oriName.substring(oriName.lastIndexOf("."));

		// 开始上传
		pictureFile.transferTo(new File("D:/develop/upload/temp/" + picName + extName));

		// 设置图片名到商品中
		item.setPic(picName + extName);
		// ---------------------------------------------
		// 更新商品
		this.itemService.updateItem(item);

		return "forward:/itemEdit.action";
	}

	
//	@RequestMapping("/queryItem")
//	public String queryItem(QueryVo queryVo){
//		System.out.println(queryVo.getItem().getId());
//		System.out.println(queryVo.getItem().getName());
//		return "success";
//	}
	
//	@RequestMapping("/queryItem")
//	public String queryItem(QueryVo queryVo,String[] ids){
//		System.out.println(queryVo.getIds().length);
//		System.out.println(ids.length);
//		return "success";
//	}
//	
	/**
	 * 返回void测试
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("queryItem")
	public void queryItem(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1 使用request进行转发
//		 request.getRequestDispatcher("/WEB-INF/jsp/success.jsp").forward(request,
//		 response);

		// 2 使用response进行重定向到编辑页面
//		 response.sendRedirect("/springmvc_d02_c02/itemEdit.action");

		// 3 使用response直接显示
		response.getWriter().print("{\"abc\":123}");
	}
	
	
	/**
	 * 测试json的交互
	 * @param item
	 * @return
	 */
	@RequestMapping("testJson")
	// @ResponseBody
	public @ResponseBody Item testJson(@RequestBody Item item) {
		System.out.println(item);
		return item;
	}
	
	/**
	 * 使用RESTful风格开发接口，实现根据id查询商品
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("item/{id}")
	@ResponseBody
	public Item queryItemById(@PathVariable() Integer id) {
		Item item = this.itemService.queryById(id);
		return item;
	}



	
}
