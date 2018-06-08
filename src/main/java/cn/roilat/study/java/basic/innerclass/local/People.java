package cn.roilat.study.java.basic.innerclass.local;


/**
 * 局部内部类
 * 是定义在一个方法或者一个作用域里面的类，它和成员内部类的区别在于局部内部类的访问仅限于方法内或者该作用域内。
 * @author wb-dtw368035
 * PS:局部内部类和匿名内部类的主要区别是：一、前者有构造函数，后者没有；二、后者代码书写简单易读
 * 优点：有构造函数
 */
public class People {
	
	public static void main(String[] args) {
		Man man = new Man();
		man.getWoman().sayHello();
		man.proxyLocalInnerClass();
	}
	public People() {

	}
	public void sayHello() {
		System.out.println("this is People...");
	}
	public void sayHello3() {
		System.out.println("this is People's public sayHello3...");
	}
}

class Man {
	public Man() {

	}

	public People getWoman() {
		
		/**
		 * 局部内部类就像是方法里面的一个局部变量一样，是不能有public、protected、private以及static修饰符的。
		 * @author wb-dtw368035
		 *
		 */
		/*public/protected/private */class Woman extends People { // 局部内部类
			//public int age = 0;

			void sayHello1() {
				System.out.println("this is default sayHello1...");
			}
			private void sayHello2() {
				System.out.println("this is private sayHello2...");
			}
			public void sayHello3() {
				System.out.println("this is Woman's public sayHello3...");
			}
			public void doBusiness() {
				//必然都可以调用
				System.out.println("doBusiness");
				this.sayHello1();
				this.sayHello2();
				this.sayHello3();
				System.out.println("doBusiness");

			}
		}
		
		Woman woman = new Woman();
		/**不管局部内部类中的方法修饰是什么，定义它的方法域内都是可见*/
		System.out.println("local invoke");
		woman.sayHello1();
		woman.sayHello2();//private
		woman.sayHello3();
		System.out.println("local invoke");
		/**不管局部内部类中的方法修饰是什么，定义它的方法域内都是可见*/
		woman.doBusiness();
		return new Woman();
	}
	public void proxyLocalInnerClass() {
		People woman = this.getWoman();
		System.out.println("proxyLocalInnerClass");
		woman.sayHello3();
/*		woman.sayHello2();
		woman.sayHello1();*///只有局部内部类实现的接口或重写的方法可以在外部被调用
		woman.sayHello();
		System.out.println("proxyLocalInnerClass");
	}
}