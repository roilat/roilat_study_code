
package cn.roilat.study.language.basic;

/**
 * main函数只能放在public的类中，才能运行，如果main放到person中，私有变量仍然可以访问
 * javadoc for cn.start.roilat.language.Person
 * @Copyright: 2017成都环赛信息技术有限公司 
 * @author: roilat-D
 * @since: 2017年7月20日
 */
class Person {
	private String name = "Person";
	int age = 1;
}

public class Child extends Person{
	public Child(){
		System.out.println("Child");
//		super();
	}
	public String grade;
	public static void main(String[] args) {
		Person p = new Child();
//		System.out.println(p.name);
//		System.out.println(this);
	}
}

