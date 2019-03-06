package cn.roilat.study.java.basic.classloader;

import java.io.InputStream;

import cn.roilat.study.utils.StringUtil;

public class TestClassEquals {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
                                           IllegalAccessException {
        ClassLoader myClassLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                if (StringUtil.isEmpty(name)) {
                    return null;
                }
                Class<?> clazz = findLoadedClass(name);
                if (clazz != null) {
                    return clazz;
                }
                InputStream is = getClass().getClassLoader().getResourceAsStream(name.replace('.', '/') + ".class");
                try {
                    byte[] bs = new byte[is.available()];
                    is.read(bs);
                    clazz = defineClass(name, bs, 0, bs.length);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (clazz == null) {
                    return getClass().getClassLoader().loadClass(name);//这样可以使用AppClassLoader继续加载类
                }
                return clazz;
            }
        };
        Class<?> clazz = myClassLoader
            .loadClass("cn.roilat.study.java.basic.classloader.TestClassEquals");
        System.out.println(clazz);
        Object classEquals = clazz.newInstance();//这里不能做强制转型到 (TestClassEquals)，因为 (TestClassEquals)是AppClassLoader加载的，而不是myClassLoader加载的，会报错：Exception in thread "main" java.lang.ClassCastException: cn.roilat.study.java.basic.classloader.TestClassEquals cannot be cast to cn.roilat.study.java.basic.classloader.TestClassEquals
        System.out.println(classEquals instanceof TestClassEquals);//false 因为TestClassEquals是myClassLoader下的加载类的实例,而非AppClassLoader下的.
        System.out.println(clazz == TestClassEquals.class);//false
        System.out.println(clazz.hashCode() + "==" + TestClassEquals.class.hashCode());
    }
}
