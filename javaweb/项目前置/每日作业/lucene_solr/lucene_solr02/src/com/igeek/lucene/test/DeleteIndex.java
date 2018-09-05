package com.igeek.lucene.test;

import java.io.File;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Before;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

public class DeleteIndex {

	private IndexWriter indexWriter;

	@Before
	public void init() throws Exception {
		// 创建IndexWriter
		Analyzer analyzer = new IKAnalyzer();
		Directory directory = FSDirectory.open(new File("C:/study/index"));
		IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_4_10_3, analyzer);
		this.indexWriter = new IndexWriter(directory, config);
	}

	@Test
	public void testDeleteIndex() throws Exception {
		// 使用Term项(语汇单元)进行删除。
		// this.indexWriter.deleteDocuments(new Term("name", "solr"));

		// 删除全部，慎用
		this.indexWriter.deleteAll();

		// 释放资源
		this.indexWriter.close();
	}

}
