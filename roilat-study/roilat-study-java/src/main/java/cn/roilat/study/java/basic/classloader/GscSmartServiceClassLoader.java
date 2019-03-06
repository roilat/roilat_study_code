package cn.roilat.study.java.basic.classloader;

import java.net.JarURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * 
 * @author roilat-J
 * @version $Id: GscSmartServiceClassLoader.java, v 0.1 2018年10月20日 下午8:08:03 roilat-J Exp $
 */
public class GscSmartServiceClassLoader extends URLClassLoader {
    private List<JarURLConnection> cachedJarFiles = null;

    public GscSmartServiceClassLoader(String[] jarFiles) {
        super(new URL[] {}, findParentClassLoader());
        if (jarFiles != null && jarFiles.length > 0) {
            cachedJarFiles = new ArrayList<JarURLConnection>();
            for (String jarFile : jarFiles) {
                try {
                    addURLFile(new URL("jar:file:" + jarFile + "!/"));
                } catch (MalformedURLException e) {
                    System.out.println(e);
                }
            }
        }
    }

    /**
     * 将指定的文件url添加到类加载器的classpath中去，并缓存jar connection，方便以后卸载jar
     * 一个可想类加载器的classpath中添加的文件url
     * @param
     */
    @Transactional
    private void addURLFile(URL file) {
        try {
            // 打开并缓存文件url连接
            URLConnection uc = file.openConnection();
            if (uc instanceof JarURLConnection) {
                uc.setUseCaches(true);
                ((JarURLConnection) uc).getManifest();
                cachedJarFiles.add((JarURLConnection) uc);
            }
        } catch (Exception e) {
            System.out.println("Failed to cache plugin JAR file: " + file.toExternalForm());
        }
        addURL(file);
    }

    public void unloadJarFile() {
        for (int i = 0; i < cachedJarFiles.size(); i++) {
            JarURLConnection cachedJarFile = cachedJarFiles.get(i);
            if (cachedJarFile == null) {
                continue;
            }
            try {
                cachedJarFile.getJarFile().close();
                cachedJarFiles.remove(cachedJarFile);
                cachedJarFile = null;
                System.gc();
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("Failed to unload JAR file\n" + e);
            }
        }
    }

    /**
     * 定位基于当前上下文的父类加载器
     * @return 返回可用的父类加载器.
     */
    private static ClassLoader findParentClassLoader() {
        ClassLoader parent = GscSmartServiceClassLoader.class.getClassLoader();
        if (parent == null) {
            parent = GscSmartServiceClassLoader.class.getClassLoader();
        }
        if (parent == null) {
            parent = ClassLoader.getSystemClassLoader();
        }
        return parent;
    }

    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException {
        @SuppressWarnings("resource")
        GscSmartServiceClassLoader loader = new GscSmartServiceClassLoader(
            new String[] { "D:/classes/test.jar" });
        Class<?> clzz;
        System.out
            .println(clzz = loader.loadClass("cn.roilat.study.java.basic.classloader.TestClassLoader1"));
        System.out.println(String.format("jar:file:/%s!/","aaa/bbb/ccc"));
        System.out.println(clzz.getClassLoader());
        System.out.println(loader.getParent());
        loader.unloadJarFile();//未发现效果
        loader = null;
        System.out
                .println(clzz.getClassLoader().loadClass("cn.roilat.study.java.basic.classloader.TestClassLoader2"));
        //System.out.println(GscSmartServiceClassLoader.class.getClassLoader().loadClass("cn.roilat.study.java.basic.classloader.TestClassLoader2"));
    }
}