package cn.roilat.study.jvm;

import java.io.File;
import java.lang.management.ClassLoadingMXBean;
import java.lang.management.ManagementFactory;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

/**
 * 这个是jdk1.8支持的参数：-XX:MaxMetaspaceSize=8m
 * 这个参数jdk1.8不支持： -XX:MaxPermSize=8m
 * @author roilat-J
 * @version $Id: PermGenOomMock.java, v 0.1 2019年2月12日 下午3:24:39 roilat-J Exp $
 */
public class PermGenOomMock {
    public static void main(String[] args) {
        System.out.println(new File(".").getAbsolutePath());
        try {
            //准备url  
            URL url = new File(".").toURI().toURL();
            URL[] urls = { url };
            //获取有关类型加载的JMX接口  
            ClassLoadingMXBean loadingBean = ManagementFactory.getClassLoadingMXBean();
            //用于缓存类加载器  
            List<ClassLoader> classLoaders = new ArrayList<ClassLoader>();
            while (true) {
                //加载类型并缓存类加载器实例  
                ClassLoader classLoader = new URLClassLoader(urls);
                classLoaders.add(classLoader);
                classLoader.loadClass("cn.roilat.study.jvm.PermGenOomMock");
                //显示数量信息（共加载过的类型数目，当前还有效的类型数目，已经被卸载的类型数目）  
                System.out.println("total: " + loadingBean.getTotalLoadedClassCount());
                System.out.println("active: " + loadingBean.getLoadedClassCount());
                System.out.println("unloaded: " + loadingBean.getUnloadedClassCount());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        /**
         * 配置：-XX:MetaspaceSize=8m -XX:MaxMetaspaceSize=80m
         * 一开始：
         * unloaded: 0 
         * total: 458
         * active: 458
         * 后来：
         * active: 1568
         * unloaded: 0
         * total: 1568
         */
    }
}
