package com.igeek.lucene.test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.FloatField;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKAnalyzer;

public class CreateIndex_3 {

	public static void main(String[] args) throws Exception {
		// 1.采集数据

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

		List<Map<String, Object>> list = new ArrayList<>();
		list.add(map1);
		list.add(map2);
		list.add(map3);

		// 2. 创建文档对象，把采集的数据使用文档对象封装
		List<Document> docs = new ArrayList<>();
		for (Map<String, Object> map : list) {
			// 创建文档对象
			Document doc = new Document();

			// 商品ID
			doc.add(new StoredField("id", map.get("item_id").toString()));
			// 商品名称
			doc.add(new TextField("name", map.get("item_title").toString(), Store.YES));
			// 商品价格
			doc.add(new FloatField("price", Float.parseFloat(map.get("item_price").toString()), Store.YES));
			// 商品图片
			doc.add(new StoredField("pic", map.get("item_pic").toString()));
			// 商品描述
			doc.add(new TextField("desc", map.get("item_desc").toString(), Store.YES));

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
