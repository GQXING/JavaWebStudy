package com.javen.Jsoup;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 
 * ʹ��JSoup ������ҳ���﷨ʹ�� JS��css��Jquery ѡ�����﷨�������׶�
 * 
 * Jsoup�̳�����http://www.open-open.com/jsoup/
 * 
 * @author geekfly
 * 
 */
public class JsoupTest {

    public static void main(String[] args) throws IOException {
        String url = "http://www.oschina.net/news/list";
        Document document = Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows NT 6.1; rv:30.0) Gecko/20100101 Firefox/30.0")
                .get();
        Elements elements = document.select("#RecentNewsList .List > li");
        for (Element element : elements) {
            Elements titleElement = element.select("h2 a");
            String title = titleElement.text();
            String link = titleElement.attr("href").trim();

            Elements dataElement = element.select(".date");
            Elements autherElement = dataElement.select("a");
            String auther = autherElement.text();
            autherElement.remove();
            String date = dataElement.text();
            String detail = element.select(".detail").text();

            System.out.println("���ӣ�        " + "http://www.oschina.net"+link);
            System.out.println("���⣺        " + title);
            System.out.println("���ߣ�        " + auther);
            System.out.println("����ʱ�䣺 " + date);
            System.out.println("��ϸ��Ϣ�� " + detail);
            System.out.println();
            System.out.println();

        }

        System.out.println(elements.size());

    }
}