package cn.roilat.study.java.basic.override;


public class OverLoadTest {
	public static void main(String[] args){
		new OverLoadClass().say(12L);
	}
}
class OverLoadClass{
	void say(int i){
		System.out.println("void say(int i)");
	}
	void say(Integer i){
	    System.out.println("void say(Integer i)");
	}
	void say(Long i){
	    System.out.println("void say(Long i)");
	}
	void say(String s){
		System.out.println("void say(String s)");
	}
	/*String say(String s){
		System.out.println("void say(String s)");
		return s;
	}*/
	long say(long l){
		System.out.println("void say(int i)");
		return l;
	}
}

