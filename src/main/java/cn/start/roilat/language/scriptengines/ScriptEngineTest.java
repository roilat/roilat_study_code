package cn.start.roilat.language.scriptengines;

import javax.script.Bindings;
import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ScriptEngineTest {

	public static void main(String[] args) throws Exception {
		ScriptEngineManager factory = new ScriptEngineManager();
		ScriptEngine engine = factory.getEngineByName("JavaScript");
		Bindings binds;
		if (engine.getBindings(javax.script.ScriptContext.ENGINE_SCOPE) == null) {
			engine.createBindings();
			System.out.println("createBindings");
		}
		binds = engine.getBindings(javax.script.ScriptContext.ENGINE_SCOPE);
		binds.put("test", new ScriptTestObj());
		engine.getBindings(ScriptContext.GLOBAL_SCOPE).put("scriptEngine", engine);
		System.out.println(engine.eval("1==1"));
		//System.out.println(engine.eval("scriptEngine.hello()"));
//		System.out.println(engine.eval("test.hello()"));
		test1();
	}

	public static void test1() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		try {
			System.out.println(ScriptTestObj.class.getName());
			ScriptEngine engine = new ScriptEngineManager().getEngineByExtension("js");
//			ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
			Compilable compilable = (Compilable) engine;
			Bindings bindings = engine.getBindings(ScriptContext.ENGINE_SCOPE);//createBindings(); //Local级别的Binding
			String script = "function add(op1,op2){return op1+op2} add(a, b)"; //定义函数并调用
			CompiledScript JSFunction = compilable.compile(script); //解析编译脚本函数
			bindings.put("a", 1);
			bindings.put("aaa", Class.forName(ScriptTestObj.class.getName()).newInstance());
			bindings.put("b", 2); //通过Bindings加入参数
			Object result = JSFunction.eval(bindings);
			System.out.println(result); //调用缓存着的脚本函数对象，Bindings作为参数容器传入
			engine.setBindings(bindings, ScriptContext.ENGINE_SCOPE);
			System.out.println("==after setBindings==");
			System.out.println(engine.eval("aaa.hello()"));

		}

		catch (ScriptException e) {e.printStackTrace();}

	}
}
