
package cn.roilat.study.java.scriptengines;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;

public class ListScriptEngines {

	public static void main(String args[]) {
		ScriptEngineManager manager = new ScriptEngineManager();
		// �õ����еĽű����湤��

		List<ScriptEngineFactory> factories = manager.getEngineFactories();
		// ����Java SE 5 ��Java SE 6����For����﷨

		for (ScriptEngineFactory factory : factories) {
			// ��ӡ�ű���Ϣ

			System.out.printf("Name: %s%n"
					+ "Version: %s%n"
					+ "Language name: %s%n"
					+ "Language version: %s%n"
					+ "Extensions: %s%n"
					+ "Mime types: %s%n"
					+ "Names: %s%n",
					factory.getEngineName(), factory.getEngineVersion(), factory.getLanguageName(), factory.getLanguageVersion(), factory.getExtensions(), factory.getMimeTypes(),
					factory.getNames());
			// �õ���ǰ�Ľű�����

			ScriptEngine engine = factory.getScriptEngine();
		}
	}
}
