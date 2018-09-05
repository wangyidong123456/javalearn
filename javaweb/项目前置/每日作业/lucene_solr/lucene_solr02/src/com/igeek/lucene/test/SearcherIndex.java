package com.igeek.lucene.test;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.TextField;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.NumericRangeQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;

public class SearcherIndex {

	@Test
	public void testSearcherIndex() throws Exception {
		Analyzer analyzer = new StandardAnalyzer();
		QueryParser queryParser = new QueryParser("desc", analyzer);
		Query query = queryParser.parse("lucene AND java");

		doSearch(query);
	}

	@Test
	public void testSearcherIndex2() throws Exception {
		Analyzer analyzer = new StandardAnalyzer();
		String[] fields = { "name", "desc" };
		MultiFieldQueryParser queryParser = new MultiFieldQueryParser(fields, analyzer);

		Query query = queryParser.parse("lucene");
		System.out.println(query);
		doSearch(query);
	}

	@Test
	public void testTremQuery() throws Exception {
		Query query = new TermQuery(new Term("desc", "java"));
		this.doSearch(query);
	}

	@Test
	public void testNumericRangeQuery() throws Exception {
		Query query = NumericRangeQuery.newFloatRange("price", 55f, 66f, true, true);
		this.doSearch(query);
	}

	@Test
	public void testBooleanQuery() throws Exception {
		Query query1 = new TermQuery(new Term("desc", "java"));
		Query query2 = NumericRangeQuery.newFloatRange("price", 55f, 66f, true, true);

		// 创建组合查询的Query对象
		BooleanQuery booleanQuery = new BooleanQuery();

		// 组合查询条件
		// 第一个参数是设置组合的条件，第二个参数是设置组合的规则
		booleanQuery.add(query1, Occur.MUST);
		booleanQuery.add(query2, Occur.MUST_NOT);

		this.doSearch(booleanQuery);
	}

	private void doSearch(Query query) throws IOException {
		// 4. 创建Directory流对象
		Directory directory = FSDirectory.open(new File("C:/study/index"));

		// 5.创建IndexReader对象,读取索引
		IndexReader indexReader = DirectoryReader.open(directory);

		// 6.创建IndexSearcher查询对象
		IndexSearcher indexSearcher = new IndexSearcher(indexReader);

		// 7.使用IndexSearcher对象使用查询对象搜索索引数据，返回topDocs，里面包括文档id
		// 第一个参数就是查询对象，二个参数就是返回多少条数据,返回的数据按照相关度得分的高低排序，相关度得分越高，排名越靠前
		TopDocs topDocs = indexSearcher.search(query, 10);

		// 8.解析TopDocs，得到得分对象的数组
		ScoreDoc[] scoreDocs = topDocs.scoreDocs;

		// 9。遍历数组
		for (ScoreDoc scoreDoc : scoreDocs) {

			System.out.println("------------------------------");
			// 获取文档对象的id
			int docID = scoreDoc.doc;
			// 打印文档id
			System.out.println("文档id是：" + docID);

			// 使用IndexSearcher对象使用文档id获取文档
			Document doc = indexSearcher.doc(docID);

			// 打印文档里面的Field值
			// 图书ID
			System.out.println(doc.get("id"));
			// 图书名称
			System.out.println(doc.get("name"));
			// 图书价格
			System.out.println(doc.get("price"));
			// 图书图片
			System.out.println(doc.get("pic"));
			// 图书描述
			// System.out.println(doc.get("desc"));

		}

		// 释放资源，关闭IndexReader读取对象
		indexReader.close();
	}

}
