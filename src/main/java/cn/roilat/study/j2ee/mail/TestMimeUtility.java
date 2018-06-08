package cn.roilat.study.j2ee.mail;

import java.io.UnsupportedEncodingException;

import javax.mail.internet.MimeUtility;

public class TestMimeUtility {

	public static void main(String[] args) throws UnsupportedEncodingException {
		System.out.println(MimeUtility.encodeText("中国人"));
		System.out.println(MimeUtility.decodeText("=?UTF-8?B?5Lit5Zu95Lq6?="));
	}
}
