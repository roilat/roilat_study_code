package cn.start.roilat.language.override;


public class OverLoadTest {
	public static void main(String[] args){
		
	}
}
class OverLoadClass{
	void say(int i){
		System.out.println("void say(int i)");
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

