package cn.roilat.study.java.jdk.invoke;

public class ChildClass extends BaseClass {
	public static void main(String[] args) {
		BaseClass bc = new ChildClass();
		bc.print();
		bc.baseMethod();
		bc.baseMethod1();
		System.out.println(System.getProperty("java.library.path"));

	}

	void print() {
		System.out.println("print_ChildClass");
	}
	void print1() {
		System.out.println("print1_ChildClass");
	}

	void childMethod() {
		System.out.println("childMethod");
	}
}

class BaseClass {
	private void priMethod() {
		System.out.println("BaseClass secret");
	}

	void print() {
		System.out.println("print_BaseClass");
	}
	void print1() {
		System.out.println("print1_BaseClass");
	}

	void baseMethod() {
		this.print();//invoke ChildClass(this means ChildClass)
		this.priMethod();//父类中public/protected方法，可以访问父类的private方法。this指向ChildClass，虽然this中没有priMethod方法
		//priMethod();
	}
	void baseMethod1() {
		this.print1();//invoke ChildClass(this means ChildClass)
		print1();
	}

}