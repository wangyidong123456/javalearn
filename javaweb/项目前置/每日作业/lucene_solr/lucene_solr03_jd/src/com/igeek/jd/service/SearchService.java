package com.igeek.jd.service;

import com.igeek.jd.pojo.Result;

public interface SearchService {

	/**
	 * 根据条件查询商品
	 * 
	 * @param queryString
	 * @param catalog_name
	 * @param price
	 * @param page
	 * @param sort
	 * @return
	 */
	Result search(String queryString, String catalog_name, String price, Integer page, String sort);

}
