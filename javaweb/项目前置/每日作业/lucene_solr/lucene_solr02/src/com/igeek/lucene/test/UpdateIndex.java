package com.igeek.lucene.test;

import java.io.File;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.TextField;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Before;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

public class UpdateIndex {

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
	public void testUpdateIndex() throws Exception {
		// 声明需要更新的数据
		Document doc = new Document();
		doc.add(new TextField("name", "Java 编程思想第四版", Store.YES));

		// 执行更新
		this.indexWriter.updateDocument(new Term("name", "java"), doc);

		// 释放资源
		this.indexWriter.close();
	}

}
