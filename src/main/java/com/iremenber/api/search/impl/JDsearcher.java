package com.iremenber.api.search.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
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
public class JDsearcher implements Searcher{

	@Override
	public Mall search(String keyWord) {
		
		try {
			Document doc = Jsoup.connect("https://search.jd.com/Search?keyword="+ keyWord +"&enc=utf-8")
					.userAgent("Mozilla/5.0 (Windows NT 6.1; rv:6.0.2) Gecko/20100101 Firefox/6.0.2").get();
			List<Product> products = doc.select("#J_goodsList li").stream().map( (Element e) -> {
					Product p = new Product();
					String price = e.select("div.p-price strong i").text();
					if(StringUtils.isNoneBlank(price)) {
						p.setPrice(new BigDecimal(price));
					}
					p.setName(e.select("div.p-name.p-name-type-2 a").attr("title"));
					return p;
				}).collect(Collectors.toList());
			return Mall.getJDMall(products);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
