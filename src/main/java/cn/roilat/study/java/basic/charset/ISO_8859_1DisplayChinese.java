package cn.roilat.study.java.basic.charset;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * java�ļ����뷽ʽ��ISO-8859-1ʱ����������Ĭ�ϵı���Ҳ��ISO-8859-1�������޸�
 * ���⣬ISO-8859-1��ʽ���ļ����ܴ�����ģ���ǰ�ļ����ȸĳ�UTF8
 * @author roilat-J
 *
 */
public class ISO_8859_1DisplayChinese {

	/**
	 * D6D0B9FAC8CB=�й��ˣ�����gbk����
	 * E4B8ADE59BBDE4BABA=�й��ˣ�����utf-8�ı���
	 * @param args
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		String s = "�й���";
		//����1�������ǰ�ļ���GBK(��s�ı��뷽ʽ��GBK),�����ı��뷽ʽ��utf8,��s��utf8��ʽ���롣
		System.out.println(s);
		System.out.println(new String(s.getBytes("UTF-8"),"GBK"));
		//����ʧ��
	}
	public static void test() throws FileNotFoundException, IOException {
		Properties pro = new Properties();
		pro.load(new FileInputStream("bin\\cn\\roilat\\study\\java\\basic\\charset\\iso_8859_1.properties"));
		String name = pro.getProperty("name");
		System.out.println("ISO-8859-1 name is=" + name);//ISO-8859-1 name is=�й���
		System.out.println("GBK name is=" + new String(name.getBytes("GBK"),"UTF-8"));//GBK name is=?��???
		System.out.println(ByteUtil.str2Hex(name.getBytes("GBK")));//D6D0B9FAC8CB
		System.out.println(ByteUtil.str2Hex(name.getBytes("UTF-8")));//E4B8ADE59BBDE4BABA
		//�ɴ˿ɼ���java�����İ���ָ���ı��뷽ʽ�����ڴ棨���������unicode�������Լ��ķ�ʽ���档Ȼ����Ը��ݲ�ͬ�ı����ȡ��Ӧ��byte[]
	}
}
