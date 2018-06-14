package cn.roilat.study.algorithm.base64;

import java.io.UnsupportedEncodingException;

public class TestBase64 {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String temp = "你好，我是你哥哥，这里有很长有一段字符串，好长好长张12";
		System.out.println(temp.length());
		String s1 = Base64.encode(temp.getBytes());
		String s2 = MyBase64.encode(temp.getBytes());
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s1.equals(s2));
		String tt = "FFD20F3240C31342B0F752089A9AF055314D31ADDEC411B017C3DA3B97323A98AA780B6D30D1CDE2561D1B376E75D3C51067ED62629D7498A0736EC2B62B2CE05DA8DDDA26D92A40291BFD981E3A99FC83B86E2622A46B53FD664CB61B4A57BD0A49BBDEF1F6BE12EC2D3B01ACB67B46C52FB48B73571CCF6DBA18E85952A4740B63F4B42F9BA60474D6C863A4E6D2490451758D01D3BF6AC9D8913243FEA78588633350575BCCB0AA9451FD5F155D785CDB50DE3FB9205C3CF4AC33961CF1ED81C0B4FE6F29B7A3DCEF26FCC28D3E0F277F70D448CE49511603D7B144519DEC";
		System.out.println(new String(Base64.decode(tt),"GBK"));
	}

}
