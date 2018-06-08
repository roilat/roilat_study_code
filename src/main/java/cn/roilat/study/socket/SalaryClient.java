package cn.roilat.study.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import cn.roilat.study.utils.Crf3Des;


/**
 * @ClassName��SalaryClient
 * @Description��
 * @company:zhph
 * @author Administrator
 * @date: 2017-5-2 ����9:28:58
 */

public class SalaryClient {
	
	static Socket server;
	
    public static void main(String[] args)
        throws Exception {
		server = new Socket("127.0.0.1", 6776);
        // BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
		PrintWriter out = new PrintWriter(server.getOutputStream());
		BufferedReader wt = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String str = wt.readLine();
			String encryptStr = Crf3Des.cdsEncrypt(str);
			out.println(encryptStr);
			out.flush();
			if ("end".equals(str)) {
				break;
			}
            // System.out.println(Crf3Des.cdsDecrypt(in.readLine()));
		}
		server.close();
	}
	
}