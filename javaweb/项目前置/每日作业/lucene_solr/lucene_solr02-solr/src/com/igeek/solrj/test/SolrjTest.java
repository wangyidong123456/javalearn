package com.igeek.solrj.test;

import org.apache.solr.client.solrj.SolrQuery;
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

	@Test
	public void testSaveAndUpdate() throws Exception {
		SolrInputDocument doc = new SolrInputDocument();
		doc.addField("id", "c001");
		doc.addField("title", "今天我们第一次使用solr，初级目标是15k");

		this.httpSolrServer.add(doc);
		this.httpSolrServer.commit();
	}

	// 删除
@Test
public void testDelete() throws Exception {
	// 根据唯一域（id） 删除
	// this.httpSolrServer.deleteById("change.me");

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
	query.setQuery("title:solr");

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
		System.out.println(solrDocument.get("title").toString());
	}

}

}
