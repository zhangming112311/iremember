package com.iremenber.api.webmagic;

import us.codecraft.webmagic.Page;
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
    	page.getHtml().xpath("//div[@id='J_goodsList']");
    	page.putField("readme", page.getHtml().xpath("//div[@id='J_goodsList']/text()"));
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new GithubRepoPageProcessor()).addUrl("https://search.jd.com/Search?keyword=哈曼卡顿音响&wq=哈曼卡顿音响&enc=utf-8&").addPipeline(new JsonFilePipeline("D:\\webmagic\\")).thread(5).run();
    }
}