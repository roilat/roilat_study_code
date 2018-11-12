package cn.roilat.study.java.basic.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * 自定义的类加载器【子类优先】
 * 
 * @author roilat-J
 * @version $Id: MyWebAppLoader.java, v 0.1 2018年10月30日 下午4:43:10 roilat-J Exp $
 */
public class MyWebAppLoader extends ClassLoader {
    /**
     * lib:表示加载的文件在jar包中
     * 类似tomcat就是{PROJECT}/WEB-INF/lib/
     */
    private String              lib;
    /**
     * classes:表示加载的文件是单纯的class文件
     * 类似tomcat就是{PROJECT}/WEB-INF/classes/
     */
    private String              classes;
    /**
     * 采取将所有的jar包中的class读取到内存中
     * 然后如果需要读取的时候，再从map中查找
     */
    private Map<String, byte[]> map;

    /**
     * 只需要指定项目路径就好
     * 默认jar加载路径是目录下{PROJECT}/WEB-INF/lib/
     * 默认class加载路径是目录下{PROJECT}/WEB-INF/classes/
     * @param webPath
     * @throws MalformedURLException 
     * @throws SecurityException 
     * @throws NoSuchMethodException 
     */
    public MyWebAppLoader(String webPath) throws NoSuchMethodException, SecurityException,
                                          MalformedURLException {
        lib = webPath + "WEB-INF/lib/";
        classes = webPath + "WEB-INF/classes/";
        map = new HashMap<String, byte[]>(64);

        preReadJarFile();
    }

    /**
     * 按照父类的机制，如果在父类中没有找到的类
     * 才会调用这个findClass来加载
     * 这样只会加载放在自己目录下的文件
     * 而系统自带需要的class并不是由这个加载
     */
    @Override
    protected Class<?> findClass(String name) {
        try {
            byte[] result = getClassFromFileOrMap(name);
            if (result == null) {
                throw new FileNotFoundException();
            } else {
                return defineClass(name, result, 0, result.length);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 从指定的classes文件夹下找到文件
     * @param name
     * @return
     */
    private byte[] getClassFromFileOrMap(String name) {
        String classPath = classes + name.replace('.', File.separatorChar) + ".class";
        File file = new File(classPath);
        if (file.exists()) {
            InputStream input = null;
            try {
                input = new FileInputStream(file);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                int bufferSize = 4096;
                byte[] buffer = new byte[bufferSize];
                int bytesNumRead = 0;
                while ((bytesNumRead = input.read(buffer)) != -1) {
                    baos.write(buffer, 0, bytesNumRead);
                }
                return baos.toByteArray();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (input != null) {
                    try {
                        input.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        } else {
            if (map.containsKey(name)) {
                //去除map中的引用，避免GC无法回收无用的class文件
                return map.remove(name);
            }
        }
        return null;
    }

    /**
     * 预读lib下面的包
     */
    private void preReadJarFile() {
        List<File> list = scanDir();
        for (File f : list) {
            JarFile jar;
            try {
                jar = new JarFile(f);
                readJAR(jar);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 读取一个jar包内的class文件，并存在当前加载器的map中
     * @param jar
     * @throws IOException
     */
    private void readJAR(JarFile jar) throws IOException {
        Enumeration<JarEntry> en = jar.entries();
        while (en.hasMoreElements()) {
            JarEntry je = en.nextElement();
            String name = je.getName();
            if (name.endsWith(".class")) {
                String clss = name.replace(".class", "").replaceAll("/", ".");
                if (this.findLoadedClass(clss) != null)
                    continue;

                InputStream input = jar.getInputStream(je);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                int bufferSize = 4096;
                byte[] buffer = new byte[bufferSize];
                int bytesNumRead = 0;
                while ((bytesNumRead = input.read(buffer)) != -1) {
                    baos.write(buffer, 0, bytesNumRead);
                }
                byte[] cc = baos.toByteArray();
                input.close();
                map.put(clss, cc);//暂时保存下来
            }
        }
    }

    /**
     * 扫描lib下面的所有jar包
     * @return
     */
    private List<File> scanDir() {
        List<File> list = new ArrayList<File>();
        File[] files = new File(lib).listFiles();
        for (File f : files) {
            if (f.isFile() && f.getName().endsWith(".jar"))
                list.add(f);
        }
        return list;
    }

    /**
     * 添加一个jar包到加载器中去。
     * @param jarPath
     * @throws IOException 
     */
    public void addJar(String jarPath) throws IOException {
        File file = new File(jarPath);
        if (file.exists()) {
            JarFile jar = new JarFile(file);
            readJAR(jar);
        }
    }

    public static void main(String[] args) throws NoSuchMethodException, SecurityException,
                                           MalformedURLException, ClassNotFoundException {
        MyWebAppLoader appLoader = new MyWebAppLoader("D:\\MyWebApp\\");
        Class<?> class1;
        Class<?> class2;
        Class<?> class3;
        Class<?> class4;
        System.out.println(class1 = appLoader.loadClass("java.lang.String"));//来自jdk自带的jar包，由bootStrapClassLoader加载
        System.out.println(class2 = appLoader.loadClass("com.sun.nio.zipfs.ZipCoder"));//来自jdk自带扩展的jar包($JAVA_HOME/jre/lib/ext)
        System.out.println(class3 = appLoader.loadClass("cn.roilat.study.java.basic.classloader.TestClassLoader3"));//class cn.roilat.study.java.basic.classloader.TestClassLoader3
        System.out.println(class4 = appLoader.loadClass("cn.roilat.study.java.basic.classloader.TestClassLoader"));//class cn.roilat.study.java.basic.classloader.TestClassLoader
        System.out.println(class1.getClassLoader());//null(因为是bootStrapClassLoader加载的)
        System.out.println(class2.getClassLoader());//sun.misc.Launcher$ExtClassLoader@28d93b30
        System.out.println(class3.getClassLoader());//sun.misc.Launcher$AppClassLoader@659e0bfd
        System.out.println(class4.getClassLoader());//cn.roilat.study.java.basic.classloader.MyWebAppLoader@4ee285c6
        try {
            System.out
                .println("bootStrapClassLoader无法加载AppClassLoader中的类：" + class1.getClassLoader()
                    .loadClass("cn.roilat.study.java.basic.classloader.TestClassLoader"));//空指针是因为父类加载器找不子类中的类
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println("bootStrapClassLoader无法加载ExtClassLoader中的类："
                               + class1.getClassLoader().loadClass("com.sun.nio.zipfs.ZipCoder"));//空指针是因为父类加载器找不子类中的类
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("当前线程的classLoader是：" + Thread.currentThread().getContextClassLoader());//

        try {
            ((TestClassLoader3) class3.newInstance()).test1();//class3的类加载器是sun.misc.Launcher$AppClassLoader@659e0bfd，加载不了cn.roilat.study.java.basic.classloader.MyWebAppLoader中拥有的类
        } catch (InstantiationException | IllegalAccessException|ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Thread.currentThread().setContextClassLoader(appLoader);
            ((TestClassLoader3) class3.newInstance()).test2();//通过当前线程的上下文classLoader应该是可以加载的
        } catch (InstantiationException | IllegalAccessException|ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
