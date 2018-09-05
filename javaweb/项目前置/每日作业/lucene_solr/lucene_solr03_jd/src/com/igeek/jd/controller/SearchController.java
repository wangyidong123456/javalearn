package com.igeek.jd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.igeek.jd.pojo.Result;
import com.igeek.jd.service.SearchService;

@Controller
@RequestMapping("search")
public class SearchController {

	@Autowired
	private SearchService searchService;

	// queryString:
	// catalog_name:
	// price:
	// page:
	// sort:

	// http://127.0.0.1:8080/jd/search/list.action
	/**
	 * 鏍规嵁鏉′欢浠巗olr绱㈠紩搴撲腑鏌ヨ鍟嗗搧
	 * 
	 * @param model
	 * @param queryString
	 * @param catalog_name
	 * @param price
	 * @param page
	 * @param sort
	 * @return
	 */
	@RequestMapping(value = "list")
	public String search(Model model, String queryString, String catalog_name, String price,
			@RequestParam(value = "page", defaultValue = "1") Integer page, String sort) {

		// 璋冪敤service鏂规硶锛屾牴鎹潯浠舵煡璇㈠晢鍝�
		Result result = this.searchService.search(queryString, catalog_name, price, page, sort);

		// 鎶婃煡璇㈢粨鏋滄斁鍒癕odel涓紝浼犻�掔粰椤甸潰
		model.addAttribute("result", result);

		// 鍥炴樉鏌ヨ鍙傛暟
		model.addAttribute("queryString", queryString);
		model.addAttribute("catalog_name", catalog_name);
		model.addAttribute("price", price);
		model.addAttribute("page", page);
		model.addAttribute("sort", sort);

		return "product_list";
	}

}
