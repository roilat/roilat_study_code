package cn.roilat.study.j2ee.http.clientpool;

import java.net.URI;


/**
* Post http client璇锋眰绫� Created by guowei.lu on 2016-9-29.
*/
public class PostClient {

   private final PostRequest      postRequest;
   private final ExecutableClient executableClient;

   private PostClient(ExecutableClient executableClient, String uri, String api, String version, int timeout){
       URI url = URI.create(String.format("%s%s", uri, api));
       this.postRequest = PostRequest.newInstance(timeout, url, version);
       this.executableClient = executableClient;
   }

   public static PostClient newInstance(ExecutableClient executableClient, String uri, String api, String version,
                                        int timeout) {
       return new PostClient(executableClient, uri, api, version, timeout);
   }

   /**
    * 瀹夊叏缃戝叧鎺ㄨ崘hmacsha256鍔犵绠楁硶鎻愪氦璇锋眰
    * @return
    */
   public String post() {
       try {
           return executableClient.execute(this.postRequest);
       } catch (Exception e) {
           return e.getMessage();
       }
   }

   public PostClient addParameter(String name, String value) {
       this.postRequest.addParameter(name, value);
       return this;
   }

   public PostClient addHeader(String name, String value) {
       this.postRequest.addHeader(name, value);
       return this;
   }
}

