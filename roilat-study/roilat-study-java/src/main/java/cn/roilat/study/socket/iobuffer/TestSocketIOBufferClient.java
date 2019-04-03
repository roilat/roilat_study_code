package cn.roilat.study.socket.iobuffer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class TestSocketIOBufferClient {
    static Socket                 server;

    public static void main(String[] args) throws IOException {
        server = new Socket("127.0.0.1", 6776);
        // BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
        PrintWriter out = new PrintWriter(server.getOutputStream());
        BufferedReader wt = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String str = wt.readLine();
            out.println(str);
            out.flush();
            if ("end".equals(str)) {
                break;
            }
            // System.out.println(Crf3Des.cdsDecrypt(in.readLine()));
        }
        server.close();
    }

}
