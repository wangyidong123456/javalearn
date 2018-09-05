package com.igeek.lucene.test;

import java.io.File;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.TextField;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.wltea.analyzer.lucene.IKAnalyzer;

public class SearcherIndex_3 {

	public static void main(String[] args) throws Exception {
		// 1. 创建分析器（分词器）
		// Analyzer analyzer = new StandardAnalyzer();
		Analyzer analyzer = new IKAnalyzer();

		// 2. 创建查询解析器，是用来创建查询对象的，
		// 包含两个参数，第一个参数是默认搜索域，第二个参数是设置分析器
		QueryParser queryParser = new QueryParser("name", analyzer);

		// 3. 使用查询解析器获取查询对象
		Query query = queryParser.parse("手机");
		System.out.println(query);
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
			System.out.println(doc.get("desc"));

		}

		// 释放资源，关闭IndexReader读取对象
		indexReader.close();

	}

}
