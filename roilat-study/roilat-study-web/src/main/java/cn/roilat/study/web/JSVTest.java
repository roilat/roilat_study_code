/**
 * 
 */
package cn.roilat.study.web;

import java.io.IOException;
import java.util.Iterator;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.github.fge.jsonschema.main.JsonValidator;

/**
 * @author roilat-D JSVTest.java
 */
public class JSVTest {
	public static void main(String[] args) {
		
		String data = new String("{\"foo\":1234}");
		String schema = "{\"type\": \"object\", \"properties\" : {\"foo\" : {\"type\" : \"string\"}},\"required\" : [\"foo\"]}";
		System.out.println(doJSR(data,schema));
		JsonValidator validator = JsonSchemaFactory.byDefault().getValidator();
		try {
			ProcessingReport report = validator.validateUnchecked(JsonLoader.fromString(schema), JsonLoader.fromString(data));
			System.out.println(report.isSuccess());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		test1();// test JSV success cost:210\ntest JSV fail cost:46
		test2();// test JSV success cost:841\n test JSV fail cost:159
		/**
		 * 两个测试一起运行时，test2中，success的减少了一半，原因未知。
		 */
	}

	/**
	 * 这里测试的是使用相同的配置信息，不用每次生成validator,因此时间提升了约4倍
	 */
	public static void test1() {
		System.out.println("------------test1------------");
		String data = new String("{\"foo\":\"1234\"}");
		String schema = "{\"type\": \"object\", \"properties\" : {\"foo\" : {\"type\" : \"string\"}},\"required\" : [\"foo\"]}";
		JsonValidator validator = JsonSchemaFactory.byDefault().getValidator();
		long start = System.currentTimeMillis();
		int n = 1000;
		int failCount = 0;
		while (n-- > 0) {
			if (!doJSR(data, schema, validator)) {
				failCount++;
			}
		}
		System.out
				.println("test JSV success cost:" + (System.currentTimeMillis() - start) + ", fail count=" + failCount);
		start = System.currentTimeMillis();
		data = new String("{\"foo\":\"1234\"}");
		n = 1000;
		failCount = 0;
		while (n-- > 0) {
			if (!doJSR(data, schema, validator)) {
				failCount++;
			}
		}
		System.out.println("test JSV fail cost:" + (System.currentTimeMillis() - start) + ", fail count=" + failCount);
		/**
		 * test JSV success cost:841\n test JSV fail cost:159
		 */
		System.out.println("------------end test1------------");

	}

	/**
	 * 这里测试的是各自生成验证器的情况,此时成功是失败的5倍左右
	 */
	public static void test2() {
		System.out.println("------------test2------------");
		String data = new String("{\"foo\":\"1234\"}");
		String schema = "{\"type\": \"object\", \"properties\" : {\"foo\" : {\"type\" : \"string\"}},\"required\" : [\"foo\"]}";
		long start = System.currentTimeMillis();
		int n = 1000;
		int failCount = 0;
		while (n-- > 0) {
			if (!doJSR(data, schema)) {
				failCount++;
			}
		}
		System.out
				.println("test JSV success cost:" + (System.currentTimeMillis() - start) + ", fail count=" + failCount);
		start = System.currentTimeMillis();
		data = new String("{\"foo1\":1234}");
		n = 1000;
		failCount = 0;
		while (n-- > 0) {
			if (!doJSR(data, schema)) {
				failCount++;
			}
		}
		System.out.println("test JSV fail cost:" + (System.currentTimeMillis() - start) + ", fail count=" + failCount);
		/**
		 * 
		 */
		System.out.println("------------end test2------------");

	}

	public static boolean doJSR(String data, String schema) {
		ProcessingReport report = null;
		try {
			JsonNode dataJson = JsonLoader.fromString(data);
			JsonNode schemaJson = JsonLoader.fromString(schema);
			report = JsonSchemaFactory.byDefault().getValidator().validateUnchecked(schemaJson, dataJson);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		if (report.isSuccess()) {
			return true;
		} else {
			Iterator<ProcessingMessage> it = report.iterator();
			/*
			 * while (it.hasNext()) { System.out.println(it.next()); }
			 */
			return false;
		}
	}

	public static boolean doJSR(String data, String schema, JsonValidator jsonValidator) {
		ProcessingReport report = null;
		try {
			JsonNode dataJson = JsonLoader.fromString(data);
			JsonNode schemaJson = JsonLoader.fromString(schema);
			report = jsonValidator.validateUnchecked(schemaJson, dataJson);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		if (report.isSuccess()) {
			return true;
		} else {
			Iterator<ProcessingMessage> it = report.iterator();
			/*
			 * while (it.hasNext()) { System.out.println(it.next()); }
			 */
			return false;
		}
	}

}
