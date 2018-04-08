package cn.roilat.study.language.collection.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestListSort {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("2018-01");
		list.add("2017-11");
		list.add("2016-01");
		list.add("2017-09");
		list.add("2017-01");
		list.add("中国人");
		list.add("日本人");
		list.add("四川人");
		
		Collections.sort(list,new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {
				return str2.compareTo(str1);
			}
		});
		System.out.println(list);
		String groupField1 = "abc";
		System.out.println("get"+groupField1.substring(0,1).toUpperCase()+groupField1.substring(1));
	}
}
