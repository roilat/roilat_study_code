package cn.roilat.study.java.basic.innerclass.anonymity;

import java.io.UnsupportedEncodingException;

/**
 * 就是匿名内部类的使用。代码中需要给按钮设置监听器对象，使用匿名内部类能够在实现父类或者接口中的方法情况下同时产生一个相应的对象，但是前提是这个父类或者接口必须先存在才能这样使用。当然像下面这种写法也是可以的，跟上面使用匿名内部类达到效果相同。
 * @author wb-dtw368035
 * 匿名内部类是唯一一种没有构造器的类。正因为其没有构造器，所以匿名内部类的使用范围非常有限，大部分匿名内部类用于接口回调。匿名内部类在编译的时候由系统自动起名为Outter$1.class。一般来说，匿名内部类用于继承其他类或是实现接口，并不需要增加额外的方法，只是对继承方法的实现或是重写
 * 优点：代码简单易读
 * PS:局部内部类和匿名内部类的主要区别是：一、前者有构造函数，后者没有；二、后者代码书写简单易读
 */
public class AnonymityTest {

	public static void main(String[] args) throws UnsupportedEncodingException {
		SpeachingHander speachingHander = new SpeachingHander();
		way1(speachingHander);
		way2(speachingHander);
	}
	
	/**
	 * 匿名内部类实现
	 */
	public static void way1(SpeachingHander speachingHander) {
		speachingHander.doSpeach(new Speaker() {
			
			@Override
			public String getSpeakerName() {
				return "Obama";
			}
			
			@Override
			public String getContent() {
				return "Welcome...";
			}
		});
	}
	/**
	 * 替代方法
	 */
	public static void way2(SpeachingHander speachingHander) {
		class Obama implements Speaker{

			public Obama() {
				System.out.println("I have contructor...");
			}
			@Override
			public String getContent() {
				return "Welcome...";
			}

			@Override
			public String getSpeakerName() {
				return "Obama";
			}
		}
		Speaker obama = new Obama();
		speachingHander.doSpeach(obama);
	}
	
}
class SpeachingHander {
	public void doSpeach(Speaker speaker) {
		System.out.println(speaker.getSpeakerName() + " said that:" + speaker.getContent());
	}
}
interface Speaker{
	public String getContent();
	public String getSpeakerName();
}