package cn.roilat.study.algorithm.base64;

public class TestBase64 {

	public static void main(String[] args) {
		String temp = "你好，我是你哥哥，这里有很长有一段字符串，好长好长张12";
		System.out.println(temp.length());
		String s1 = Base64.encode(temp.getBytes());
		String s2 = MyBase64.encode(temp.getBytes());
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s1.equals(s2));
	}

}
