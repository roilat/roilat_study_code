package cn.roilat.study.java.basic.datatype.primary;

public class TestDoubleAndFloatSave {
	public static void main(String[] args) {
		System.out.println(binary2Double("1.00110011001100110011010"));
		System.out.println(binary2Double("1100.10000000000000000000"));
		System.out.println(binary2Double("1.11111111111111111111111"));
		System.out.println(binary2Double("1.10000110011001100110011"));
		System.out.println("-----------------------------------------");
		floatData();
		//0 11111111 11111111111111111111111(23)=1.0..共128个0..011..共23个1..11*2(255-127=128次方)=1*3.4028235E38
		System.out.println("float.Max=="+Float.MAX_VALUE);
		System.out.println("float.Min=="+Float.MIN_VALUE);
	}

	/**
	 * 浮点数保存的字节格式如下： 地址 +0 +1 +2 +3 内容 SEEE EEEE EMMM MMMM MMMM MMMM MMMM MMMM
	 * S 代表符号位，1是负，0是正
	 * E 偏移127的幂，二进制阶码=(EEEEEEEE)-127。
	 * M 24位的尾数保存在23位中，只存储23位，最高位固定为1。此方法用最较少的位数实现了
	 * 较高的有效位数，提高了精度。
	 */
	public static void floatData() {
		System.out.println("-----------------------------------------");
		printHEXFloat(1.2f);
		System.out.println(Integer.toHexString(Float.floatToIntBits(1.2f)));
		System.out.println(Float.toHexString(1.2f));
		System.out.println("-----------------------------------------");

		/**
		 * 0 01111111 00110011001100110011010(1.00110011001100110011010)
		 * +(1.00110011001100110011010=1.2000000476837158=0x1.333334)(01111111-127=0)
		 * 0x1.333334*2^0次方=1.2000000476837158*1;
		 */
		
		System.out.println(Integer.toHexString(Float.floatToIntBits(0f)));
		System.out.println(Float.toHexString(0f));
		/**
		 * 零是一个特定值，幂是0 尾数也是0。
		 */
		System.out.println("-----------------------------------------");

		printHEXFloat(-12.5f);
		System.out.println(Integer.toHexString(Float.floatToIntBits(-12.5f)));
		System.out.println(Float.toHexString(-12.5f));
		/**
		 * 1 10000010 10010000000000000000000(1.10010000000000000000000)
		 * -(1.10010000000000000000000=1.5625=0x1.9)(10000010-127=3)
		 * -0x1.9*2^3次方=-1.5625*8=-12.5
		 */
		System.out.println("-----------------------------------------");

		printHEXFloat(12.2f);
		System.out.println(Integer.toHexString(Float.floatToIntBits(12.2f)));
		System.out.println(Float.toHexString(12.2f));
		/**
		 * 0 10000010 10000110011001100110011
		 * 0 10000010 10000110011001100110011(1.10000110011001100110011)
		 * +(1.10000110011001100110011=1.524999976158142=0x1.8666666)(10000010-127=3)
		 * 0x1.333334*2^0次方=1.2000000476837158*1;
		 */
		System.out.println("-----------------------------------------");

	}

	public static void printHEXFloat(Float f) {
		int temp = Float.floatToIntBits(f);
		char[] cs = "0123456789ABCDEF".toCharArray();
		char[] cc = new char[8];
		int i = 0;
		for (; i < 8; i++) {
			cc[i] = cs[temp & 0x0000000f];
			temp >>= 4;
		}
		for (; i > 0;) {
			if (i % 2 == 0) {
				System.out.print(" ");
			}
			System.out.print(String.format("%s", cc[ --i]));
		}
		System.out.println();
	}
	
	public static double binary2Double(String s) {
		String[] ss = s.split("\\.");
		int in = Integer.parseInt(ss[0], 2);
		double re = in;
		if(ss.length == 2) {
			char[] cs = ss[1].toCharArray();
			int i = 0;
			double temp = 1;
			while(i < cs.length) {
				temp /= 2;
				switch (cs[i++]) {
				case '1':
					re += temp;
				}
			}
		}
		return re;
	}
}
