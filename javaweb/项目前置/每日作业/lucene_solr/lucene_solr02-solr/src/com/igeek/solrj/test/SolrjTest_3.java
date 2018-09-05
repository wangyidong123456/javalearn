package com.igeek.solrj.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
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
		String baseURL = "http://127.0.0.1:8081/solr/";
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
			// doc.addField("pic", map.get("item_pic").toString());
			// 商品描述
			// doc.addField("desc", map.get("item_desc").toString());

			docs.add(doc);

		}

		this.httpSolrServer.add(docs);
		this.httpSolrServer.commit();
	}

	// 删除
	@Test
	public void testDelete() throws Exception {
		// 根据唯一域（id） 删除
		// this.httpSolrServer.deleteById("1");

		// 根据条件删除（可以删除全部，慎用）
		this.httpSolrServer.deleteByQuery("*:*");

		// 提交
		this.httpSolrServer.commit();
	}

	// 查询
	@Test
	public void testQuery() throws Exception {
		// 创建SolrQuery查询对象
		SolrQuery query = new SolrQuery();

		// 设置查询语句
		query.setQuery("name:手机");

		// 使用HttpSolrServer执行查询，返回response
		QueryResponse response = this.httpSolrServer.query(query);

		// 解析response，获取results
		SolrDocumentList results = response.getResults();

		// 使用results获取查询数据的总条数
		System.out.println("查询到的数据总条数是：" + results.getNumFound());

		// 遍历结果集results，打印数据
		for (SolrDocument solrDocument : results) {

			// 解析solrDocument
			// 获取id
			System.out.println(solrDocument.get("id").toString());
			// 获取title
			System.out.println(solrDocument.get("name").toString());
		}

	}

}
