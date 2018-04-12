package cn.roilat.study.java.basic.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试不能引用的内存回收情况
 * @author wb-dtw368035
 *-XX:+PrintGCDetails -XX:+TraceClassLoading 
 *
 */
public class ReferenceTest {

	public static void main(String[] args) throws InterruptedException {
		ReferenceObj obj = new ReferenceObj();
		SoftReference<ReferenceObj> softReference = new SoftReference<ReferenceObj>(new ReferenceObj());
		WeakReference<ReferenceObj> weakReference = new WeakReference<ReferenceObj>(new ReferenceObj());
		PhantomReference<ReferenceObj> phantomReference = new PhantomReference<ReferenceObj>(new ReferenceObj(), null);
		
		System.out.println(obj);
		System.out.println(softReference.get());
		System.out.println(weakReference.get());
		System.out.println(phantomReference.get());//虚引用无法获取对象
		/**
		 * cn.roilat.study.java.basic.ReferenceObj@6d06d69c
		 * cn.roilat.study.java.basic.ReferenceObj@7852e922
		 * cn.roilat.study.java.basic.ReferenceObj@4e25154f
		 * null
		 */
		System.gc();
		Thread.sleep(300);
		int i = 600000;
		List<ReferenceObj> list = new ArrayList<ReferenceObj>();
		try {
			while(i-- > 0) {
				list.add(new ReferenceObj());
			}
		} catch (Error e) {//错误后不做任何处理
			e.printStackTrace();
		}
		
		
		System.out.println(obj);
		System.out.println(softReference.get());//-Xmx5M,实际需要xxxM获取
		System.out.println(weakReference.get());//gc 后就没有了
		System.out.println(phantomReference.get());//虚引用无法获取对象
		/**
		 * cn.roilat.study.java.basic.ReferenceObj@6d06d69c
		 * null
		 * null
		 * null
		 */
		
		//TODO 待进一步完善测试代码
	}
	/**
	 * java.lang.OutOfMemoryError: GC overhead limit exceeded,多次Full GC后会出这个错误
	 */
	

}
class ReferenceObj{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}