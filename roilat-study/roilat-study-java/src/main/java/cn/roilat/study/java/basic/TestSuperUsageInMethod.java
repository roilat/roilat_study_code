package cn.roilat.study.java.basic;

public class TestSuperUsageInMethod {

	//
	public static void main(String[] args) {
		class FatherC {
			public synchronized void doSomething() {
				System.out.println("call local father override method");
			}
		}

		class ChildrenC extends FatherC {
			@Override
			public synchronized void doSomething() {
				System.out.println("call local childrenC override method");
				super.doSomething();
			}
		}
		FatherC fc = new ChildrenC();
		fc.doSomething();
	}
}
class FatherC {  
    public synchronized void doSomething() {  
		System.out.println("call father override method");
    }  
}  
   
class ChildrenC extends FatherC {  
     @Override  
     public synchronized void doSomething() {  
         System.out.println("call childrenC override method");  
         super.doSomething();  
     }  
}  