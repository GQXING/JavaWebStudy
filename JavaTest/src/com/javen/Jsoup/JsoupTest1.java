package com.javen.Jsoup;

import javax.lang.model.element.Element;
import javax.lang.model.util.Elements;
import javax.swing.text.Document;

import org.jsoup.Jsoup;

public class JsoupTest1 {
	private static String urlString="http://nba.hupu.com/";
	//设置超时标志
	private static int timeout=6000;
	//抓取方法
	public static void scratch(String urlString) throws Exception{
		org.jsoup.nodes.Document page=Jsoup.connect(urlString).timeout(timeout).get();
		org.jsoup.select.Elements newlist=page.select(".text h2 a");
//		for (org.jsoup.nodes.Element topNews:newlist) {
//			System.out.println("Title:"+topNews.text());
//			System.out.println("Href"+topNews.attr("href"));
//			System.out.println("++++++++++++");
//		}
		
		//find some picture
		org.jsoup.select.Elements sliderPic=page.select(".slider-pic img");
		for (org.jsoup.nodes.Element slidElements:sliderPic) {
			System.out.println("Title："+slidElements.attr("alt"));
			System.out.println("Title:"+slidElements.attr("src"));
			System.out.println("++++++++++++++++++");
		}
		
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		scratch(urlString);
	}

}
