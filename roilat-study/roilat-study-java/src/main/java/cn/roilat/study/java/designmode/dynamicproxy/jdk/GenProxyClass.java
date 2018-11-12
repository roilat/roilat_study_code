package cn.roilat.study.java.designmode.dynamicproxy.jdk;

import java.io.FileOutputStream;

import cn.roilat.study.java.designmode.dynamicproxy.UserServiceImpl;

public class GenProxyClass {
    public static void main(String[] args) {
        @SuppressWarnings("restriction")
        byte[] classFile = sun.misc.ProxyGenerator.generateProxyClass("$Proxy0", UserServiceImpl.class.getInterfaces());
        String path = "D:/Test.class";
        try(FileOutputStream fos = new FileOutputStream(path)) {
            fos.write(classFile);
            fos.flush();
            System.out.println("代理类class文件写入成功");
        } catch (Exception e) {
           System.out.println("写文件错误");
        }
    }
}
