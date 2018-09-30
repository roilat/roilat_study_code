package cn.roilat.study.java.basic.throwable;

import java.io.Closeable;
import java.io.IOException;

/**
 * try(e)会默认调用e.close方法，如果e实现了closeable接口。
 * 
 * @author roilat-J
 * @version $Id: TestClosable.java, v 0.1 2018年9月28日 上午11:11:15 roilat-J Exp $
 */
public class TestClosable {
    
    public static void main(String[] args){
        
        try(MyCloseable myCloseable = new MyCloseable();){
            System.out.println("do anything...");
        } catch (IOException e) {
            System.out.println("this is the IOException...");
        }finally {
            System.out.println("this is the finally...");
        }
    }

}
class MyCloseable implements Closeable{

    @Override
    public void close() throws IOException {
        System.out.println("MyCloseable is closed");
    }
    
}