package cn.roilat.study.j2ee.http.clientpool;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;


/**
 * 鍙墽琛岀殑http璇锋眰瀹㈡埛绔被 Created by guowei.lu on 2016-9-29.
 */
public class ExecutableClient {

    private CloseableHttpClient         httpClient;
    private IdleConnectionMonitorThread idleConnectionMonitorThread;
    private String                      uri;
    private String                      protocal;
    private String                      domainName;
    private String                      accessKey;
    private String                      secretKey;

    public static ExecutableClient getInstance() {
        return FactoryHodler.EXECUTABLE_CLIENT;
    }

    public void init() {
        uri = String.format("%s://%s", this.protocal, this.domainName);
        ConnectionSocketFactory plainsf = PlainConnectionSocketFactory.getSocketFactory();
        LayeredConnectionSocketFactory sslsf = SSLConnectionSocketFactory.getSocketFactory();
        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory> create().register("http",
                                                                                                                 plainsf).register("https",
                                                                                                                                   sslsf).build();
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(registry);
        cm.setMaxTotal(800);
        cm.setDefaultMaxPerRoute(400);
        httpClient = HttpClients.custom().setConnectionManager(cm).build();
        idleConnectionMonitorThread = new IdleConnectionMonitorThread(cm);
        idleConnectionMonitorThread.start();
    }

    public String execute(AbstractRequest httpRequest) throws Exception{
        String response;
        try {
            httpRequest.accessKey(accessKey);
            response = this.httpClient.execute(httpRequest.getHttpRequest(), FactoryHodler.STRING_RESPONSE_HANDLER);
        } catch (IOException e) {
            throw new Exception(e.getMessage(), e.getCause());
        }
        return response;
    }


    public PostClient newPostClient(String api) {
        return newPostClient(api, HttpConstants.HTTP_CLIENT_TIMEOUT);
    }

    /**
     * 鎸囧畾瓒呮椂鏃堕棿
     * 
     * @param api
     * @param timeout 鍗曚綅ms
     * @return
     */
    public PostClient newPostClient(String api, int timeout) {
        return newPostClient(api, "1.0", timeout);
    }

    public PostClient newPostClient(String api, String version) {
        return newPostClient(api, version, HttpConstants.HTTP_CLIENT_TIMEOUT);
    }

    /**
     * 鎸囧畾瓒呮椂鏃堕棿
     * 
     * @param api
     * @param version
     * @param timeout 鍗曚綅ms
     * @return
     */
    public PostClient newPostClient(String api, String version, int timeout) {
        return PostClient.newInstance(this, this.uri, api, version, timeout);
    }

    public void destroy() {
        if (idleConnectionMonitorThread != null) {
            idleConnectionMonitorThread.shutdown();
            try {
                idleConnectionMonitorThread.join();
            } catch (InterruptedException e) {
            }
        }
        if (httpClient != null) {
            try {
                httpClient.close();
            } catch (IOException e) {
            }
        }
    }

    public static class IdleConnectionMonitorThread extends Thread {

        private final HttpClientConnectionManager connMgr;
        private volatile boolean                  shutdown;

        public IdleConnectionMonitorThread(HttpClientConnectionManager connMgr){
            super();
            this.connMgr = connMgr;
        }

        @Override
        public void run() {
            try {
                while (!shutdown) {
                    synchronized (this) {
                        wait(5000);
                        // Close expired connections
                        connMgr.closeExpiredConnections();
                        // Optionally, close connections
                        // that have been idle longer than 30 sec
                        connMgr.closeIdleConnections(30, TimeUnit.SECONDS);
                    }
                }
            } catch (InterruptedException ex) {
                // terminate
            }
        }

        public void shutdown() {
            shutdown = true;
            synchronized (this) {
                notifyAll();
            }
        }
    }

    public static class StringResponseHandler implements ResponseHandler<String> {

        private String encode;

        public StringResponseHandler(String encode){
            this.encode = encode;
        }

        public String handleResponse(HttpResponse response) throws IOException {
            StatusLine statusLine = response.getStatusLine();
            HttpEntity entity = response.getEntity();
            String responseBody = entity == null ? null : EntityUtils.toString(entity, encode);
            if (statusLine.getStatusCode() >= 300 || statusLine.getStatusCode() == 203) {
                EntityUtils.consume(entity);
                throw new HttpResponseException(statusLine.getStatusCode(), responseBody);
            }
            return responseBody;
        }
    }

    private static class FactoryHodler {

        public static final ExecutableClient      EXECUTABLE_CLIENT       = new ExecutableClient();
        public static final StringResponseHandler STRING_RESPONSE_HANDLER = new StringResponseHandler(Consts.UTF_8.name());
    }

    public void setProtocal(String protocal) {
        this.protocal = protocal;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public CloseableHttpClient getHttpClient() {
        return httpClient;
    }

    public String getUri() {
        return uri;
    }
}
