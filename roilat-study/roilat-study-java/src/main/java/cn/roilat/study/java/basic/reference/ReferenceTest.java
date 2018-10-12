package cn.roilat.study.java.basic.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试不能引用的内存回收情况
 * @author wb-dtw368035
 *-XX:+PrintGCDetails -XX:+TraceClassLoading -Xmx12m
 *
 *当-Xmx12m时,会出现不断的full GC,一直不抛错误.
 *但是当-Xmx13m时,则直接抛了错误.
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
		
		/**
		 * 
当-Xmx12m时:
Heap
 PSYoungGen      total 4096K, used 2143K [0x00000000ffb80000, 0x0000000100000000, 0x0000000100000000)
  eden space 3584K, 59% used [0x00000000ffb80000,0x00000000ffd97fa8,0x00000000fff00000)
  from space 512K, 0% used [0x00000000fff00000,0x00000000fff00000,0x00000000fff80000)
  to   space 512K, 0% used [0x00000000fff80000,0x00000000fff80000,0x0000000100000000)
 ParOldGen       total 9728K, used 9293K [0x00000000ff200000, 0x00000000ffb80000, 0x00000000ffb80000)
  object space 9728K, 95% used [0x00000000ff200000,0x00000000ffb13698,0x00000000ffb80000)
 Metaspace       used 2816K, capacity 4490K, committed 4864K, reserved 1056768K
  class space    used 304K, capacity 386K, committed 512K, reserved 1048576K
		 */
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