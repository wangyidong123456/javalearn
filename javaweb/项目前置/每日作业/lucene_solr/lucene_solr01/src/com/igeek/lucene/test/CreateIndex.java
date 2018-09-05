package com.igeek.lucene.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKAnalyzer;

import com.igeek.lucene.dao.BookDao;
import com.igeek.lucene.dao.impl.BookDaoImpl;
import com.igeek.lucene.pojo.Book;

public class CreateIndex {

	public static void main(String[] args) throws Exception {
		// 1.采集数据
		BookDao bookDao = new BookDaoImpl();
		List<Book> list = bookDao.queryBookList();

		// 2. 创建文档对象，把采集的数据使用文档对象封装
		List<Document> docs = new ArrayList<>();
		for (Book book : list) {
			// 创建文档对象
			Document doc = new Document();

			// 图书ID
			doc.add(new TextField("id", book.getId().toString(), Store.YES));
			// 图书名称
			doc.add(new TextField("name", book.getName(), Store.YES));
			// 图书价格
			doc.add(new TextField("price", book.getPrice().toString(), Store.YES));
			// 图书图片
			doc.add(new TextField("pic", book.getPic(), Store.YES));
			// 图书描述
			doc.add(new TextField("desc", book.getDesc(), Store.YES));

			// 把Document放到doc的容器中
			docs.add(doc);

		}
		// 3.创建分析器（分词）
		// Analyzer analyzer = new StandardAnalyzer();
		Analyzer analyzer = new IKAnalyzer();

		// 4.创建Directory流对象，设置索引库所在的位置
		Directory directory = FSDirectory.open(new File("C:/study/index"));

		// 5.创建IndexWriterConfig配置对象
		IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_4_10_3, analyzer);

		// 6.创建IndexWriter写入对象
		IndexWriter indexWriter = new IndexWriter(directory, config);

		// 7.使用IndexWriter写入对象把数据写入到索引库中
		for (Document document : docs) {
			indexWriter.addDocument(document);
		}

		// 8. 释放资源，把IndexWriter关闭
		indexWriter.close();

	}

}
