package cn.roilat.framework.utils;

import java.io.Serializable;
import java.util.Date;

public class DemoUser implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 699678450020994635L;

	private String name;
	
	private int age;
	
	private Date birthday;
	public DemoUser(){}
	public DemoUser(String name, int age, Date birthday) {
		super();
		this.name = name;
		this.age = age;
		this.birthday = birthday;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
}
