package cn.roilat.study.java.basic.testtransient;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @description 使用transient关键字不序列化某个变量
 *        注意读取的时候，读取数据的顺序一定要和存放数据的顺序保持一致
 * @author roilat-J
 *
 */
public class TransientTest1 {
	public static void main(String[] args) {

		User1 user = new User1();
		user.setUsername("Alexia");
		user.setPasswd("123456");
		user.a = new A();

		System.out.println("read before Serializable: ");
		System.out.println("username: " + user.getUsername());
		System.err.println("password: " + user.getPasswd());
		System.err.println("a: " + user.a);

		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("src/main/java/cn/roilat/study/java/basic/testtransient/user.txt"));
			os.writeObject(user); // 将User对象写进文件
			os.flush();
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("src/main/java/cn/roilat/study/java/basic/testtransient/user.txt"));
			user = (User1) is.readObject(); // 从流中读取User的数据
			is.close();

			System.out.println("\nread after Serializable: ");
			System.out.println("username: " + user.getUsername());
			System.err.println("password: " + user.getPasswd());
		     System.err.println("a: " + user.a);


		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

/**
 * 如果未实现Serializable接口,将无法进行序列化
 * 
 * @author roilat-J
 * @version $Id: TransientTest1.java, v 0.1 2018年9月28日 上午10:41:35 roilat-J Exp $
 */
class User1 implements Serializable {
	private static final long serialVersionUID = 8294180014912103005L;

	private String username;
	private transient String passwd;
	public A a;//变量如果是用户自定义类变量，则该类需要实现Serializable接口

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

}

/**
 * 成员变量是类时，也要实现Serializable接口
 * 
 * 
 * @author roilat-J
 * @version $Id: TransientTest1.java, v 0.1 2018年9月28日 下午3:53:04 roilat-J Exp $
 */
class A implements Serializable{

    /**  */
    private static final long serialVersionUID = -1893238706189587565L;
    
}