package com.iremenber.api.webmagic;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.alibaba.fastjson.JSON;
import com.iremenber.api.vo.Product;
import com.iremenber.api.webmagic.pageprocessor.JDPageProcessor;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

public class SearchUtil {
	public static List<Product> search(String keyWord) {
		Document doc;
		try {
			doc = Jsoup.connect("https://search.jd.com/Search?keyword=哈曼卡顿音响&enc=utf-8")
					.userAgent("Mozilla/5.0 (Windows NT 6.1; rv:6.0.2) Gecko/20100101 Firefox/6.0.2").get();
			List<BigDecimal> prices = ((List<String>)doc.select("div.p-price strong i").eachText()).stream().map(p -> new BigDecimal(p)).collect(Collectors.toList());
			List<String> names = doc.select("div.p-name.p-name-type-2 a").eachAttr("title");
			AtomicInteger i = new AtomicInteger(0);
			return names.stream().map((String name) ->{ 
				Product p = new Product(name,prices.get(i.getAndIncrement()));
				return p;
			}).collect(Collectors.toList());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
//		JDPageProcessor jdPageProcessor = new JDPageProcessor("哈曼卡顿音响");
//        Spider.create(jdPageProcessor).addRequest(jdPageProcessor.getRequest()).addPipeline(new Pipeline() {
//			@Override
//			public void process(ResultItems resultItems, Task task) {
//				List<BigDecimal> prices = ((List<String>)resultItems.get("prices")).stream().map(p -> new BigDecimal(p)).collect(Collectors.toList());
//				List<String> names = (List<String>)resultItems.get("names");
//				AtomicInteger i = new AtomicInteger(0);
//				List<Product> products = names.stream().map((String name) ->{ 
//					Product p = new Product(name,prices.get(i.getAndIncrement()));
//					return p;
//				}).collect(Collectors.toList());
//				System.out.println(JSON.toJSONString(products));
//			}
//		}).run();
    }
}
