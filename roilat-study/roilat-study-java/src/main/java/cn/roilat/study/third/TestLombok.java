/**
 * 
 */
package cn.roilat.study.third;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author roilat-D TestLombok.java
 */
public class TestLombok {

	/**
	 * 对于使用了lombok的代码 虽然在idea编译检查时会报错，但是实际运行时却不会报错
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new TestLombok().new User1("aaa", "bbb").equals(new TestLombok().new User1("aaa", "bbb")));// true，已默认实现了equals方法
		System.out.println(new TestLombok().new User1("aaa", "bbb"));// 实现了toString方法
		System.out.println(new TestLombok().new User2("aaa", "bbb").equals(new TestLombok().new User2("aaa", "bbb")));// false
		System.out.println(new TestLombok().new User2("aaa", "bbb"));// 必须写构造函数
	}

	@Data
	@AllArgsConstructor
	public class User1 {
		private String name;
		private String id;

		/**
		 * 也可以直接覆盖lombok生成的方法
		 * 
		 * @return
		 */
		public String getName() {
			return "hello " + name;
		}

	}

	@SuppressWarnings("unused")
	public class User2 {
		/**
		 * @param string
		 * @param string2
		 */
		public User2(String name, String id) {
			this.name = name;
			this.id = id;
		}

		private String name;
		private String id;
	}
}
