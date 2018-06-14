package cn.roilat.study.j2ee.http.clientpool;

import org.apache.http.client.methods.HttpUriRequest;


/**
 * @author roilat-J
 */
public abstract class AbstractRequest {

    private final int timeout;


    private String accessKey;



    public AbstractRequest(int timeout,String version){
        this.timeout = timeout;
    }

    public HttpUriRequest getHttpRequest() {
        HttpUriRequest request = newHttpRequest();
        // 鍙傛暟鍔犵
        /*this.signature.method(methodName()).path(request.getURI().getPath()).secretKey(this.secretKey);
        String signStr;
        Header header = request.getFirstHeader(HttpConstants.X_HMAC_AUTH_ALGORITHM_HEADER);
        if (header == null) {
            // hmacsha256鍔犵
            signStr = signature.sign();
        } else {
            String algorithm = header.getValue();
            if (StringUtils.equals(algorithm, HttpConstants.X_HMAC_AUTH_ALGORITHM_MD5)) {
                // md5鍔犵
                signStr = this.signature.signMd5();
            } else {
                // hmacsha256鍔犵
                signStr = signature.sign();
            }
        }*/
        // 瀹夊叏缃戝叧鍗忚澶翠俊鎭�
        request.addHeader(HttpConstants.X_HMAC_AUTH_API_KEY_HEADER, this.accessKey);

        return request;
    }

    protected abstract HttpUriRequest newHttpRequest();

    public abstract String methodName();

    public int getTimeout() {
        return timeout;
    }

    public AbstractRequest accessKey(String accessKey) {
        this.accessKey = accessKey;
        return this;
    }

}