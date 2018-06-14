
package cn.roilat.study.java.basic;


/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {
		System.out.println("Hello World!");

		String acctNo = "13666241521";
		boolean b = acctNo.matches("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
		System.out.println(b);

		StringBuffer txCodes = new StringBuffer();
//		System.out.println(StringUtil.isEmpty(txCodes.toString()));
		txCodes.append("123','123','123','");
		System.out.println(txCodes.insert(0, "('").replace(txCodes.length() - 2, txCodes.length(), ")").toString());
	}
}
