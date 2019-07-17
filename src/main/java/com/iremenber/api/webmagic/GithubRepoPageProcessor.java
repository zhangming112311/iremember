package com.iremenber.api.webmagic;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

public class GithubRepoPageProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

    @Override
    public void process(Page page) {
//    	keyword: 哈曼卡顿音响
//    	enc: utf-8
//    	wq: 哈曼卡顿音响
//    	pvid: a3d4ab2343904e7c90a94876c4f6a4fa
//        page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/\\w+/\\w+)").all());
//        page.putField("author", page.getUrl().regex("https://github\\.com/(\\w+)/.*").toString());
//        page.putField("name", page.getHtml().xpath("//h1[@class='entry-title public']/strong/a/text()").toString());
//        if (page.getResultItems().get("name")==null){
//            //skip this page
//            page.setSkip(true);
//        }
//        page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));
//		page.getHtml().selectDocument(selector)
    	page.getHtml().$("div.p-price strong i").all();
    	page.getHtml().$("div.p-name.p-name-type-2 a","title").all();
    	page.putField("readme", page.getHtml().xpath("//skcolor_ljg[@class='p-price']/tidyText()"));
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
//    	https://search.jd.com/Search?keyword=%E5%93%88%E6%9B%BC%E5%8D%A1%E9%A1%BF%E9%9F%B3%E5%93%8D&enc=utf-8&suggest=1.his.0.0&wq=&pvid=6502ba17a4ac488a90c0eef91172879b
//    	https://search.jd.com/Search?keyword=%E5%93%88%E6%9B%BC%E5%8D%A1%E9%A1%BF%E9%9F%B3%E5%93%8D&enc=utf-8
//    	doGetTestOne();
    	Request request = new Request("https://search.jd.com/Search?keyword=%E5%93%88%E6%9B%BC%E5%8D%A1%E9%A1%BF%E9%9F%B3%E5%93%8D&enc=utf-8");
    	request.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; rv:6.0.2) Gecko/20100101 Firefox/6.0.2");
        Spider.create(new GithubRepoPageProcessor()).addRequest(request).addPipeline(new JsonFilePipeline("D:\\webmagic\\")).thread(5).run();
    }
    
	public static void doGetTestOne() {
		// 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		// 创建Get请求
		HttpGet httpGet = new HttpGet("https://search.jd.com/Search?keyword=%E5%93%88%E6%9B%BC%E5%8D%A1%E9%A1%BF%E9%9F%B3%E5%93%8D&enc=utf-8");
//		user-agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36
		httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; rv:6.0.2) Gecko/20100101 Firefox/6.0.2");
		// 响应模型
		CloseableHttpResponse response = null;
		try {
			// 由客户端执行(发送)Get请求
			response = httpClient.execute(httpGet);
			// 从响应模型中获取响应实体
			HttpEntity responseEntity = response.getEntity();
			System.out.println("响应状态为:" + response.getStatusLine());
			if (responseEntity != null) {
				System.out.println("响应内容长度为:" + responseEntity.getContentLength());
				System.out.println("响应内容为:" + EntityUtils.toString(responseEntity,"utf-8"));
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 释放资源
				if (httpClient != null) {
					httpClient.close();
				}
				if (response != null) {
					response.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}