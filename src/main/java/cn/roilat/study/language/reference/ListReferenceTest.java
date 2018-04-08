package cn.roilat.study.language.reference;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListReferenceTest {
	public static void main(String[] args) {
		List<String[]> tasks = new ArrayList<String[]>();
		int year = 2017;
		String[] st = new String[2];
		st[0] = year + "-01-01";
		st[1] = year + "-03-31";
		tasks.add(st);
		st = new String[2];
		st[0] = year + "-04-01";
		st[1] = year + "-06-30";
		tasks.add(st);
		st = new String[2];
		st[0] = year + "-07-01";
		st[1] = year + "-09-30";
		tasks.add(st);
		st = new String[2];
		st[0] = year + "-10-01";
		st[1] = year + "-12-31";
		tasks.add(st);
		System.out.println(st);
		Iterator<String[]> iter = tasks.iterator();
		while (iter.hasNext()) {
			String[] ss = iter.next();
			System.out.println(ss[0] + "===" + ss[1]);
		}
	}
}
