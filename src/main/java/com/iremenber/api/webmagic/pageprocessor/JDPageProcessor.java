package com.iremenber.api.webmagic.pageprocessor;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;
import com.iremenber.api.vo.Product;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.processor.PageProcessor;

public class JDPageProcessor implements PageProcessor {
	private String keyWord;
	public JDPageProcessor(String keyWord) {
		this.keyWord = keyWord;
	}
	
	private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

	@Override
	public void process(Page page) {
		page.putField("prices", page.getHtml().$("div.p-price strong i","text").all());
		page.putField("names", page.getHtml().$("div.p-name.p-name-type-2 a", "title").all());
	}

	@Override
	public Site getSite() {
		return site;
	}
	public Request getRequest() {
		Request request = new Request("https://search.jd.com/Search?keyword=" + keyWord + "&enc=utf-8");
		request.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; rv:6.0.2) Gecko/20100101 Firefox/6.0.2");
		return request;
	}
}