
package cn.roilat.study.java.basic;

public class Test99MultTable {

	public static void main(String[] args) {
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.printf("%1$3d * %2$-3d= %3$-3d\t", j, i, i * j);
			}
			System.out.println();
		}
		String s = "Hello World!";
		 int i = 13 ;
		 double d = 88.8 ;

		 System.out.printf("整形数据i = %2$+-10d \n字符串 s = %1$s \n浮点数据 d = %3$3.2f", s , i , d);
		 System.out.printf("\n不足10为用0来补：%010d" , i);
	}

}
