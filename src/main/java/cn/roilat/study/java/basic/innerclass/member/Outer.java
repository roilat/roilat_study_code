package cn.roilat.study.java.basic.innerclass.member;

/**
 * 成员内部类
 * 内部类可以拥有private访问权限、protected访问权限、public访问权限及包访问权限。比如上面的例子，如果成员内部类Inner用private修饰，\n
 * 则只能在外部类的内部访问，如果用public修饰，则任何地方都能访问；如果用protected修饰，则只能在同一个包下或者继承外部类的情况下访问；如果是默认访问权限，
 * 则只能在同一个包下访问。这一点和外部类有一点不一样，外部类只能被public和包访问两种权限修饰。我个人是这么理解的，由于成员内部类看起来像是外部类的一个成员，所以可以像类的成员一样拥有多种权限修饰。
 * 
 * @author wb-dtw368035
 *
 */
public class Outer {

	public static void main(String[] args) {

		/**
		 * 知识点4：
		 * 成员内部类是依附外部类而存在的，也就是说，如果要创建成员内部类的对象，<font>前提是必须存在一个外部类的对象</font>。创建成员内部类对象的一般方式如下
		 */
		// 方法1：
		Outer outer = new Outer();
		Outer.Inner inner1 = outer.new Inner();
		outer.sayHello();
		inner1.sayHello();
		inner1.getAllDesc();

		// 方法2：
		Outer.Inner inner2 = outer.getInstance();
		outer.doBusiness();
		inner2.doBusiness();

		/**
		 * 知识点5： public 所有地方可见 default 当前package内可见 private 中有Outer中可见 protected
		 * Outer类及子类，当前package可见
		 */
		Outer.Inner in1 = outer.new Inner();// public
		Outer.Inner1 in2 = outer.new Inner1();// private
		Outer.Inner2 in3 = outer.new Inner2();// protected
		Outer.Inner3 in4 = outer.new Inner3();// default
		System.out.println(in1);
		System.out.println(in2);
		System.out.println(in3);
		System.out.println(in4);
	}

	private String outerDesc = "outerDesc";
	private String age = "100";

	public void sayHello() {
		System.out.println("this is Outer method 'inner'...,My name is " + getName());
		System.out.println("this is Outer method 'inner'...,My name is " + Outer.this.getName());
	}

	public String getName() {
		return "outerName";
	}

	public class Inner {
		private String innerDesc = "innerDesc";
		private String age = "10";

		/**
		 * 知识点1：
		 * 当成员内部类拥有和外部类同名的成员变量或者方法时，会发生隐藏现象，即默认情况下访问的是成员内部类的成员。如果要访问外部类的同名成员，需要以下面的形式进行访问
		 * 外部类.this.成员变量 外部类.this.成员方法 即优先调用自己的
		 */
		public void sayHello() {
			System.out.println("this is Inner method 'inner'...,My inner_name is " + getName());
			System.out.println("this is Inner method 'inner'...,My outer_name is " + Outer.this.getName());
			System.out.println("this is the Inner age:" + age);
			System.out.println("this is the Inner age:" + Outer.this.age);
		}

		public String getName() {
			return "innerName";
		}

		/**
		 * 知识点2： 成员内部类可以无条件访问外部类的所有成员属性和成员方法（包括private成员和静态成员）
		 */
		public void getAllDesc() {
			System.out.println("this is the outer desc:" + outerDesc);
			System.out.println("this is the outer desc:" + innerDesc);
		}

		public void doBusiness() {
			System.out.println(" Inner class is doing business...");
		}

	}

	/**
	 * 知识点3：
	 * 虽然成员内部类可以无条件地访问外部类的成员，而外部类想访问成员内部类的成员却不是这么随心所欲了。在外部类中如果要访问成员内部类的成员，必须先创建一个成员内部类的对象，再通过指向这个对象的引用来访问
	 */
	public void doBusiness() {
		getInstance().doBusiness();
	}

	public Inner getInstance() {
		return new Inner();
	}

	/**
	 * 只能在外部类的内部访问
	 * 
	 * @author wb-dtw368035
	 *
	 */
	private class Inner1 {

	}

	/**
	 * 只能在同一个包下或者继承外部类的情况下访问
	 * 
	 * @author wb-dtw368035
	 *
	 */
	protected class Inner2 {
		// 这里的protected是指Outer的成员，而不是Inner2中的成员
	}

	/**
	 * 默认访问权限，则只能在同一个包下访问
	 * 
	 * @author wb-dtw368035
	 *
	 */
	class Inner3 {

	}
}

class Other {
	public static void main(String[] args) {
		// 无法看见private的成员内部类
		// Outer.Inner1 in;
	}
}