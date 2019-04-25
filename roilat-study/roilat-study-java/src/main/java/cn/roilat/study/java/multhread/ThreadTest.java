
package cn.roilat.study.java.multhread;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;

public class ThreadTest {

    public static void main(String[] args) throws Exception {
        testConcurrent();
        //		new MyWriter().writeLog(new String("132"));
        System.out.println(MyWorker.successCount + " has complete!");
        System.out.println(MyWorker.exceptionCount + " has exception!");
    }

    public static void testConcurrent() {
        final int num = 1000;
        final CountDownLatch begin = new CountDownLatch(1);
        final CountDownLatch end = new CountDownLatch(num);
        for (int i = 0; i < num; i++) {
            new Thread(new MyWorker(i, begin, end)).start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        System.out.println(MyWorker.startedCount + " has ready!");
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        System.out.println("开始进行并发测试");

        try {
            end.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            begin.countDown();
            long startTime = System.currentTimeMillis();
            MyWriter.getInstance().close();
            long endTime = System.currentTimeMillis();
            System.out.println("结束并发测试 !");
            System.out.println("花费时间: " + (endTime - startTime));
        }
    }
}

class MyWorker implements Runnable {

    final CountDownLatch begin;
    final CountDownLatch end;
    public static int    successCount   = 0;
    public static int    startedCount   = 0;
    public static int    exceptionCount = 0;
    //final String urlString = "http://fcrcportal-eu95-8.gz00b.dev.alipay.net/hgboss/api/gateway.json?_input_charset=utf-8&componentName=RC_INDUSTRY_INFO_SUBSCRIBE_RULE&actionName=QUERY_ALL_SOURCE";//"http://www.roilat.cn/blog/";
    final String         urlString      = "http://localhost:8081/hello";//"http://www.roilat.cn/blog/";

    final int            id;

    public MyWorker(final int id, final CountDownLatch begin, final CountDownLatch end) {
        this.id = id;
        this.begin = begin;
        this.end = end;
    }

    public void run() {
        try {
            System.out.println(this.id + " ready !");
            startedCount++;
            begin.await();
            // execute your logic
            requestWebUrl();
            successCount++;
        } catch (Throwable e) {
            exceptionCount++;
            try {
                MyWriter.getInstance().writeLog(e);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            System.out.println(this.id + " 完成测试 !");

            end.countDown();
        }
    }

    public void requestWebUrl() throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(false);//允许连接提交信息
        connection.setRequestMethod("GET");//网页提交方式“GET”、“POST”
        //		 connection.setRequestProperty("User-Agent", "Mozilla/4.7 [en] (Win98; I)");
        StringBuffer sb = new StringBuffer();
        sb.append("userName=admin");
        sb.append("&passWord=21232f297a57a5a743894a0e4a801fc3");
        //		 OutputStream os = connection.getOutputStream();
        //		 os.write(1);
        //		 os.close();
        List<String> pageInfo = readLine(connection.getInputStream());
        for (String s : pageInfo) {
            System.out.println(s);
        }
    }

    public static List<String> readLine(InputStream inputStream) throws IOException {
        List<String> list = new ArrayList<String>();
        BufferedReader bufferReader = null;
        try {
            bufferReader = new BufferedReader(new InputStreamReader(inputStream));

            String readline;
            while ((readline = bufferReader.readLine()) != null) {
                list.add(readline);
            }
        } finally {
            bufferReader.close();
        }
        return list;
    }

}

class MyWriter {
    private static MyWriter myWriter = new MyWriter();
    File                    file     = new File("log-" + UUID.randomUUID().toString() + ".txt");
    FileWriter              fw;

    private MyWriter() {
        try {
            fw = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeLog(Object o) throws Exception {
        fw.append(o.toString());
    }

    public void close() {
        try {
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static MyWriter getInstance() {
        return myWriter;
    }
}
