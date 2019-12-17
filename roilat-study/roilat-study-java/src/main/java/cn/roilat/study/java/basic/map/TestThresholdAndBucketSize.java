/**
 * 
 */
package cn.roilat.study.java.basic.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author roilat-D TestThresholdAndBucketSize.java
 */
public class TestThresholdAndBucketSize {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>(10);// bucketSize=0，因为table为null;threshold=16(初始值)
		int i = 0;
		while (i++ < 12) {// 第一次put即resize后，bucketSize=16;threshold=12
			map.put("test" + i, "test" + i);
		}
		i++;
		map.put("test" + i, "test" + i);// size(13)>threshold(12)进行了一次resize，bucketSize=32;threshold=24
		System.out.println(map);
		
		
		//负载因子为1.0
		Map<String, String> map2 = new HashMap<String, String>(3,1);// bucketSize=0，因为table为null;threshold=4(初始值)
		i = 0;
		while (i++ < 4) {// 第一次put即resize后，bucketSize=4;threshold=4
			map2.put("test" + i, "test" + i);
		}
		i++;
		map2.put("test" + i, "test" + i);//达到4才开始resize,bucketSize=8;threshold=8
		System.out.println(map2);
		
		//负载因子为1.5
		Map<String, String> map3 = new HashMap<String, String>(3,1.5f);// bucketSize=0，因为table为null;threshold=4(初始值)
		i = 0;
		while (i++ < 6) {// 第一次put即resize后，bucketSize=4;threshold=6
			map3.put("test" + i, "test" + i);
		}
		i++;
		map3.put("test" + i, "test" + i);//达到4才开始resize,bucketSize=8;threshold=12
		System.out.println(map3);
	}

}
