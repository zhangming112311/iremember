package com.iremenber.api.search;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.iremenber.api.vo.Mall;


public class SearchUtil {
	@Autowired
	private List<Searcher> searchers;
	public List<Mall> search(String keyWord) {
		return searchers.stream().map(s -> s.search(keyWord)).collect(Collectors.toList());
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
