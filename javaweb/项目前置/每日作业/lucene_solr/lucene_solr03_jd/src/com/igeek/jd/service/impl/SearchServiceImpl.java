package com.igeek.jd.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igeek.jd.pojo.Product;
import com.igeek.jd.pojo.Result;
import com.igeek.jd.service.SearchService;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	private HttpSolrServer httpSolrServer;

	@Override
	public Result search(String queryString, String catalog_name, String price, Integer page, String sort) {
		// 创建查询对象
		SolrQuery solrQuery = new SolrQuery();

		// 设置查询语句
		if (StringUtils.isNotBlank(queryString)) {
			solrQuery.setQuery(queryString);
		} else {
			solrQuery.setQuery("*:*");
		}

		// 设置默认搜索域
		solrQuery.set("df", "product_name");

		// 设置商品类别和商品价格，使用过滤查询
		// 拼接商品类目名称过滤语句product_catalog_name:幽默杂货
		if (StringUtils.isNotBlank(catalog_name)) {
			// 不为空，设置过滤语句
			catalog_name = "product_catalog_name:" + catalog_name;
		}

		// 拼接商品价格过滤语句,product_price:[4 TO 18.9]
		// 50-*
		if (StringUtils.isNotBlank(price)) {
			String[] str = StringUtils.split(price, "-");
			price = "product_price:[" + str[0] + " TO " + str[1] + "]";
		}

		// 设置过滤查询到查询对象中
		solrQuery.setFilterQueries(catalog_name, price);

		// 设置价格排序
		if ("1".equals(sort)) {
			solrQuery.setSort("product_price", ORDER.asc);
		} else {
			solrQuery.setSort("product_price", ORDER.desc);
		}

		// 设置分页
		// 设置每页显示的数据条数
		int rows = 16;
		if (page == null) {
			page = 1;
		}
		solrQuery.setStart((page - 1) * rows);
		solrQuery.setRows(rows);

		// 设置高亮
		// 开启高亮
		solrQuery.setHighlight(true);
		// 设置高亮字段
		solrQuery.addHighlightField("product_name");
		// 设置前缀
		solrQuery.setHighlightSimplePre("<font color='red'>");
		// 设置后缀
		solrQuery.setHighlightSimplePost("</font>");

		try {
			// 执行查询
			QueryResponse response = this.httpSolrServer.query(solrQuery);

			// 获取高亮数据
			// {
			// "1": {"product_name": ["花儿朵朵彩色金属门"]},
			// "2": {"product_name": ["幸福一家人彩色金"]}
			// }
			Map<String, Map<String, List<String>>> map = response.getHighlighting();

			// 获取结果集
			SolrDocumentList results = response.getResults();

			// 遍历结果集
			// 声明存放Product的list容器
			List<Product> list = new ArrayList<Product>();
			for (SolrDocument solrDocument : results) {
				// 封装成Product对象
				// 声明Product
				Product product = new Product();

				// 解析高亮数据
				List<String> hlist = map.get(solrDocument.get("id").toString()).get("product_name");

				// 把查询结果的Document里的值封装到Product
				// 商品id
				product.setPid(solrDocument.get("id").toString());
				// 商品名称product_name
				if (hlist != null && hlist.size() > 0) {
					product.setName(hlist.get(0));
				} else {
					product.setName(solrDocument.get("product_name").toString());
				}
				// 商品价格product_price
				product.setPrice(solrDocument.get("product_price").toString());
				// 商品图片product_picture
				product.setPicture(solrDocument.get("product_picture").toString());

				// 把封装好的数据放到list容器中
				list.add(product);

			}

			// 封装返回对象Result
			Result result = new Result();
			// 设置当前页
			result.setCurPage(page);
			// 设置总页数 total%rows==0?total/rows:(total/rows)+1
			long total = results.getNumFound();
			result.setPageCount((int) (total % rows == 0 ? total / rows : (total / rows) + 1));
			// 设置结果集
			result.setProductList(list);
			// 设置查询的数据总条数
			result.setRecordCount(total);

			// 返回封装的Result
			return result;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 如果查询出现异常，返回null
		return null;
	}

}
