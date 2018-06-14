
package cn.roilat.study.java.scriptengines;

import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class NewClass {
    public static void main(String[] args) throws ScriptException {
        final ScriptEngine s = new ScriptEngineManager().getEngineByExtension("js");
        s.getBindings(ScriptContext.ENGINE_SCOPE).put("manager", new ManagerClass());
        s.eval("manager.test(); manager.test2();");
    }
}