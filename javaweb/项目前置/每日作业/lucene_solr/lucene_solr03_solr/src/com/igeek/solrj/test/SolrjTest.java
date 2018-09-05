package com.igeek.solrj.test;

import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Before;
import org.junit.Test;

public class SolrjTest {

	private HttpSolrServer httpSolrServer;

	@Before
	public void init() {
		String baseURL = "http://127.0.0.1:8081/solr/";
		this.httpSolrServer = new HttpSolrServer(baseURL);
	}

	// 复杂查询
	@Test
	public void testQuery2() throws Exception {
		// 创建SolrQuery查询对象
		SolrQuery solrQuery = new SolrQuery();

		// 设置查询语句:挂钩
		solrQuery.setQuery("挂钩");

		// 设置过滤查询fq,product_price:{4 TO 18.9],product_catalog_name:幽默杂货
		solrQuery.setFilterQueries("product_price:{4 TO 18.9]", "product_catalog_name:幽默杂货");

		// 设置排序sort:product_price asc
		solrQuery.setSort("product_price", ORDER.asc);

		// 设置分页start, rows,
		solrQuery.setStart(10);
		solrQuery.setRows(10);

		// 设置fl，显示的字段id,product_name,product_catalog_name,product_price
		solrQuery.setFields("id,product_name,product_catalog_name,product_price");

		// 设置默认查询域df,product_name
		solrQuery.set("df", "product_name");

		// 设置wt，返回的数据格式
		solrQuery.set("wt", "json");

		// 设置高亮
		// 开启高亮
		solrQuery.setHighlight(true);
		// 设置高亮字段
		solrQuery.addHighlightField("product_name");
		// 设置高亮前缀
		solrQuery.setHighlightSimplePre("<font color='red'>");
		// 设置高亮后缀
		solrQuery.setHighlightSimplePost("</font>");

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

		// 打印查询到的数据总条数
		System.out.println("查询的数据总条数是：" + results.getNumFound());

		// 遍历结果集
		for (SolrDocument solrDocument : results) {
			// 解析高亮数据
			List<String> hlist = map.get(solrDocument.get("id").toString()).get("product_name");

			System.out.println("------------------------");
			// 打印结果集
			// 商品id
			System.out.println(solrDocument.get("id").toString());
			// 商品product_name
			System.out.println(solrDocument.get("product_name").toString());
			// 打印高亮数据
			if (hlist != null && hlist.size() > 0) {
				System.out.println("高亮数据是：" + hlist.get(0));
			}
			// 商品product_catalog_name
			System.out.println(solrDocument.get("product_catalog_name").toString());
			// 商品product_price
			System.out.println(solrDocument.get("product_price").toString());
		}

	}

}
