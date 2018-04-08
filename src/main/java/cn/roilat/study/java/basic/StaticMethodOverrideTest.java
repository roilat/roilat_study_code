package cn.roilat.study.java.basic;
/**
 * 静态方式不能被override测试，但是子类可以调用父类可见的静态方式
 * @author wb-dtw368035
 *
 */
public class StaticMethodOverrideTest {

	
	public static void main(String[] args) {
		Child.test(123);
		Parent.test("hello");
		Child.test("hello");
	}
	
}
class Parent{
	public static void test(String s) {
		System.out.println("parent---"+ s);
	}
	public static void test(Integer i) {
		System.out.println("parent---"+ i);
	}
}
class Child extends Parent{
//	@Override
	public static void test(String s) {
		System.out.println("child---"+ s);
	}
	
}