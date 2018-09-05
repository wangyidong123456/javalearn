package com.igeek.solrj.test;

import java.util.ArrayList;
import java.util.HashMap;
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

public class SolrjTest_3 {

	private HttpSolrServer httpSolrServer;
	private List<Map<String, Object>> list;

	@Before
	public void init() {
		String baseURL = "http://127.0.0.1:8983/solr/";
		this.httpSolrServer = new HttpSolrServer(baseURL);

		Map<String, Object> map1 = new HashMap<>();
		map1.put("item_id", 1);
		map1.put("item_title", "小米6 全网通 6GB+64GB 亮黑色 移动联通电信4G手机 双卡双待");
		map1.put("item_price", 2599);
		map1.put("item_pic", "23423423453.jpg");
		map1.put("item_desc", "骁龙835 旗舰处理器， 6GB 大内存，5.15”四曲面机身！变焦双摄拍人更美！");

		Map<String, Object> map2 = new HashMap<>();
		map2.put("item_id", 2);
		map2.put("item_title", "华为 HUAWEI nova 2 4GB+64GB 极光蓝 移动联通电信4G手机 双卡双待");
		map2.put("item_price", 2499);
		map2.put("item_pic", "21315151331231.jpg");
		map2.put("item_desc", "高颜值，爱自拍！前置2000万高清美拍，光学变焦双镜头！");

		Map<String, Object> map3 = new HashMap<>();
		map3.put("item_id", 3);
		map3.put("item_title", "魅族 魅蓝X 3GB+32GB 全网通公开版 幻影蓝 移动联通电信4G手机 双卡双待");
		map3.put("item_price", 1699);
		map3.put("item_pic", "6742354453.jpg");
		map3.put("item_desc", "【赠VR+耳机】MTK P20芯片，5.5英寸全高清夏普屏，双2.5D玻璃！");

		this.list = new ArrayList<>();
		this.list.add(map1);
		this.list.add(map2);
		this.list.add(map3);
	}

	@Test
	public void testSaveAndUpdate() throws Exception {
		List<SolrInputDocument> docs = new ArrayList<>();

		for (Map<String, Object> map : this.list) {
			SolrInputDocument doc = new SolrInputDocument();
			// 商品ID
			doc.addField("id", map.get("item_id").toString());
			// 商品名称
			doc.addField("name", map.get("item_title").toString());
			// 商品价格
			doc.addField("price", Float.parseFloat(map.get("item_price").toString()));
			// 商品图片
			doc.addField("pic", map.get("item_pic").toString());
			// 商品描述
			doc.addField("desc", map.get("item_desc").toString());

			docs.add(doc);

		}

		this.httpSolrServer.add(docs);
		this.httpSolrServer.commit();
	}

	// 复杂查询
	@Test
	public void testQuery2() throws Exception {
		// 创建SolrQuery查询对象
		SolrQuery solrQuery = new SolrQuery();

		// 设置查询语句:挂钩
		solrQuery.setQuery("移动");

		// 设置过滤查询fq,
		solrQuery.setFilterQueries("price:{2000 TO 3000]");

		// 设置排序sort:product_price asc
		solrQuery.setSort("price", ORDER.asc);

		// 设置分页start, rows,
		solrQuery.setStart(0);
		solrQuery.setRows(10);

		// 设置fl
		solrQuery.setFields("id,name,price");

		// 设置默认查询域df
		solrQuery.set("df", "name");

		// 设置wt，返回的数据格式
		solrQuery.set("wt", "json");

		// 设置高亮
		// 开启高亮
		solrQuery.setHighlight(true);
		// 设置高亮字段
		solrQuery.addHighlightField("name");
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
			List<String> hlist = map.get(solrDocument.get("id").toString()).get("name");

			System.out.println("------------------------");
			// 打印结果集
			// 商品id
			System.out.println(solrDocument.get("id").toString());
			// 商品product_name
			System.out.println(solrDocument.get("name").toString());
			// 打印高亮数据
			if (hlist != null && hlist.size() > 0) {
				System.out.println("高亮数据是：" + hlist.get(0));
			}
			// 商品price
			System.out.println(solrDocument.get("price").toString());
		}

	}

}
