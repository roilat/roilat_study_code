package cn.roilat.study.java.basic.debug;

import java.util.HashMap;
import java.util.Map;

/**
 * 相关文章参考：
 * http://adwrytuh.blog.163.com/blog/static/807736152010112643818359/
 * https://www.cnblogs.com/m-xy/p/3301242.html
 * 
 * @author roilat-J
 * @version $Id: TestDebugWays.java, v 0.1 2018年11月28日 上午11:45:49 roilat-J Exp $
 */
public class TestDebugWays {
    public static void main(String[] args) {
        try {
            testExceptionPoint();
        } catch (Exception e) {
        }

        testDropToFrame();
        testCondtionBreakPoint();
        testShowStructure();
        
        //测试成员变量上的断点
        TestClass tc = new TestClass();
        tc.setName("name1");//此外，Expressions窗口中可以使用表达式："tc.getName();"获取值
        tc.setName("name2");
        System.out.println(tc.getName());
        
        

    }

    /**
     * 这个方法不需要打断点，只需要在breakpoints中增加一个NullPointerException的监控断点即可
     */
    public static void testExceptionPoint() {
        throw new NullPointerException();
    }
    
    /**
     * Drop To Frame好像不能对入口main函数起作用
     */
    public static void testDropToFrame() {
        String s;//这个地点无法增加断点
        s = "123";
        s = "321";//在此处右键修改s的值为"abc"
        System.out.println(s);//输出后，对Debug窗口中的当前线程右键"Drop To Frame"可以重新调试当前方法（第一行开始）
    }
    
    public static void testCondtionBreakPoint() {
        String name;
        for (int i = 0; i < 10; i++) {
            if (i % 3 == 0) {
                name = "name" + i;
                System.out.println(name);//条件断点设置成：name.equals("name3")，则不会进来一次
            }
        }
    }
    
    /**
     * 可以在Variables窗口中，对变量右键->Show Lodical Structure->Map Entry(其它对象可能不一样)把勾去掉，就可以看到HashMap中详细细节了
     * 可以对变量中的属性右键使用上述操作
     */
    public static void testShowStructure() {
        Map<Integer,String> map = new HashMap<Integer,String>();
        map.put(1, "value1");
        map.put(2, "value2");
        map.put(17, "value17");//1和17应该在一个bucket中，实现上，1和17两个Node是以链表的方式存在
        map.put(3, "value3");
    }
}

class TestClass {
    /**
     * 断点可以打在变量上，变量变化或者访问时都可以定位到
     */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}