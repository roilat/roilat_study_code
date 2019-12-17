/**
 * 
 */
package cn.roilat.study.web;

import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;

/**
 * @author roilat-D TestEverit.java
 */
public class TestEverit {
	public static void main(String[] args) {
//		InputStream inputStream = TestEverit.class.getResourceAsStream("/JSONSchema-draft4.txt");
//		JSONObject Schema = new JSONObject(new JSONTokener(inputStream));
		test1();// test Everit success cost:25\n test Everit fail cost:7
		test2();// test Everit success cost:134\n test Everit fail cost:18
		/**
		 * 两个测试一起运行时，test2中，success的减少了一半，原因未知。
		 */

		/**
		 * ------------test1------------ test Everit success cost:22 test Everit fail
		 * cost:7 ------------end test1------------ ------------test2------------ test
		 * Everit success cost:45 test Everit fail cost:21 ------------end
		 * test2------------
		 */
	}

	/**
	 * 这里测试的是使用相同的配置信息，不用每次生成validator,因此时间提升了约4倍
	 */
	public static void test1() {
		System.out.println("------------test1------------");
		String data = new String("{\"foo\":\"1234\"}");
		String schemaStr = "{\"type\": \"object\", \"properties\" : {\"foo\" : {\"type\" : \"string\"}},\"required\" : [\"foo\"]}";
		Schema schema = SchemaLoader.load(new JSONObject(schemaStr));
		long start = System.currentTimeMillis();
		int n = 1000;
		int failCount = 0;
		while (n-- > 0) {
			if (!doEveritTest(new JSONObject(data), schema)) {
				failCount++;
			}
		}
		System.out.println(
				"test Everit success cost:" + (System.currentTimeMillis() - start) + ", fail count=" + failCount);
		start = System.currentTimeMillis();
		data = new String("{\"foo1\":1234}");
		n = 1000;
		failCount = 0;
		while (n-- > 0) {
			if (!doEveritTest(new JSONObject(data), schema)) {
				failCount++;
			}
		}
		System.out
				.println("test Everit fail cost:" + (System.currentTimeMillis() - start) + ", fail count=" + failCount);
		/**
		 * test JSV success cost:841\n test JSV fail cost:159
		 */
		System.out.println("------------end test1------------");

	}

	/**
	 * 这里测试的是各自生成验证器的情况
	 */
	public static void test2() {
		System.out.println("------------test2------------");
		String data = new String("{\"foo\":\"1234\"}");
		String schema = "{\"type\": \"object\", \"properties\" : {\"foo\" : {\"type\" : \"string\"}},\"required\" : [\"foo\"]}";
		long start = System.currentTimeMillis();
		int n = 1000;
		int failCount = 0;
		while (n-- > 0) {
			if (!doEveritTest(new JSONObject(data), new JSONObject(schema))) {
				failCount++;
			}
		}
		System.out.println(
				"test Everit success cost:" + (System.currentTimeMillis() - start) + ", fail count=" + failCount);
		start = System.currentTimeMillis();
		data = new String("{\"foo1\":1234}");
		System.out.println(new JSONObject(data));
		n = 1000;
		failCount = 0;
		while (n-- > 0) {
			if (!doEveritTest(new JSONObject(data), new JSONObject(schema))) {
				failCount++;
			}
		}
		System.out
				.println("test Everit fail cost:" + (System.currentTimeMillis() - start) + ", fail count=" + failCount);
		/**
		 * 
		 */
		System.out.println("------------end test2------------");

	}

	public static boolean doEveritTest(JSONObject data, Schema schema) {
		try {
			schema.validate(data);
			return true;
		} catch (ValidationException e) {
			return false;
			// System.out.println(e.getMessage());
		}
	}

	public static boolean doEveritTest(JSONObject data, JSONObject jsonScheme) {
		Schema schema = SchemaLoader.load(jsonScheme);
		try {
			schema.validate(data);
			return true;
		} catch (ValidationException e) {
			return false;

			// System.out.println(e.getMessage());
		}
	}
}
