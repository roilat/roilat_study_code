
package cn.roilat.study.java.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

public class GenerateList {

	public static void main(String[] args) {
		ArrayList<?> list = new ArrayList<>(20);
		System.out.println(list);
		List<String> list1 = Lists.newArrayList("aa","bb");
		System.out.println(list1.size());
		for(int i = 0;i<100;i++){
			list1.add("string"+i);
		}
		System.out.println(list1);
		
	}

}

