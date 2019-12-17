package cn.roilat.study.third;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;

import cn.roilat.study.utils.StringUtil;

public class TestJsoup {
	public static void main(String[] args) throws IOException {
		//Document doc = Jsoup.parse(new File("src/main/java/cn/roilat/study/third/test.html"), "UTF-8");
		Document doc = Jsoup.parse(new URL("http://www.baidu.com"), 5000);
		Iterator<Node> iter = doc.childNodes().iterator();
		print(iter);
	}

	public static void print(Iterator<Node> iter) {
		while (iter.hasNext()) {
			Node ele = iter.next();
			if (ele instanceof TextNode) {
				String s = ((TextNode) ele).getWholeText();
				if (!StringUtil.isBlank(s)) {
					System.out.println(s);
				}
			} else {
				print(ele.childNodes().iterator());
			}
		}
	}
}
