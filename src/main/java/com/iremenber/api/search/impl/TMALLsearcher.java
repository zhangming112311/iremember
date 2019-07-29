package com.iremenber.api.search.impl;


import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;
import com.iremenber.api.search.Searcher;
import com.iremenber.api.vo.Mall;
import com.iremenber.api.vo.Product;
@Component
public class TMALLsearcher  implements Searcher{

	@Override
	public Mall search(String keyWord) {
		try {
			Document doc = Jsoup.connect("https://list.tmall.com/search_product.htm?q="+ keyWord)
					.userAgent("Mozilla/5.0 (Windows NT 6.1; rv:6.0.2) Gecko/20100101 Firefox/6.0.2").get();
//			List<BigDecimal> prices = ((List<String>)doc.select("div.product p.productPrice em").eachAttr("title")).stream().map(p -> new BigDecimal(p)).collect(Collectors.toList());
//			productImg-wrap img  src
//			List<String> names = doc.select("div.product p.productTitle a").eachText();
//			AtomicInteger i = new AtomicInteger(0);
//			return Mall.getTMall(names.stream().map((String name) ->{ 
//				Product p = new Product(name,prices.get(i.getAndIncrement()),null);
//				return p;
//			}).collect(Collectors.toList()));
			
			
			return Mall.getTMall(doc.select("div.product").stream().map( (Element e) -> {
				Product p = new Product();
				String price = e.select("p.productPrice em").attr("title");
				if(StringUtils.isNotBlank(price)) {
					p.setPrice(new BigDecimal(price.trim()));
				}
				p.setName(e.select("p.productTitle a").text());
				p.setImg(e.select(".productImg-wrap img").attr("src"));
				return p;
			}).collect(Collectors.toList()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
