/**
 * 
 */
package cn.roilat.study.algorithm.numberseries;

import org.testng.internal.Nullable;

/**
 * @author roilat-D OtherNumberSeries.java
 */
public class OtherNumberSeries {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		numberSeries1(10);
	}

	/**
	 * 0，1，3，8，21，55 规律是中间数等于前后的数除以3
	 */
	public static void numberSeries1(@Nullable int count) {
		int x = 0, y = 1, z;
		System.out.print(x + "	");
		System.out.print(y + "	");
		while (count-- > 2) {// 已经输二个
			z = y * 3 - x;
			System.out.print(z + "	");
			x = y;
			y = z;
		}
	}

}
