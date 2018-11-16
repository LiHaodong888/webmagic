package com.li.webmgaic;/**
 * @author lihaodong
 * @create 2018-10-10 22:52
 * @desc
 **/

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lihaodong
 * @create 2018-10-10 22:52
 * @desc
 **/

public class QiuShiTextProcessor implements PageProcessor {


    // 抓取网站的相关配置，可以包括编码、抓取间隔1s、重试次数等
    private Site site = Site.me()
            .setCharset("utf8")
            .setRetryTimes(1000)
            .setSleepTime(1000)
            .setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");

    public static void main(String[] args) {
        Spider.create(new QiuShiTextProcessor())
                .addUrl("https://www.qiushibaike.com/text/")
                .thread(5)
                .run();
    }

    @Override
    public void process(Page page) {
        // 所有页
        page.addTargetRequests(page.getHtml().css(".pagination").links().all());

        Html html = page.getHtml();
        // 用户头像
        List<String> imgList = page.getHtml().xpath("//div[@class='author clearfix']/a[1]/img/@src").all();
        // 用户名称
        List<String> userNameList = page.getHtml().xpath("//div[@class='author clearfix']/a[2]/h2").all();
        // 文字内容
        List<String> contentList = html.xpath("//div[@class='content']/span/text()").all();

        System.out.println(imgList);
        System.out.println(userNameList);
        System.out.println(contentList);
    }


    @Override
    public Site getSite() {
        return site;
    }
}
