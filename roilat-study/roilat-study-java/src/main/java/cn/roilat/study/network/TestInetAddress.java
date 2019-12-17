package cn.roilat.study.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestInetAddress {

	public static void main(String[] args) throws UnknownHostException {
		System.out.println(InetAddress.getLocalHost().getHostName());// PC-20160124BSJA
		System.out.println(InetAddress.getLocalHost().getHostAddress());// 192.168.129.65
	}

}
