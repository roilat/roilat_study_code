package cn.roilat.study.j2ee.http.clientpool;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.message.BasicNameValuePair;


/**
 * POST璇锋眰 Created by guowei.lu on 2016-9-29.
 */
public class PostRequest extends AbstractRequest {

    private final HttpPost            httpPost;
    private final List<NameValuePair> nameValues;

    private PostRequest(int timeout, URI uri, String version){
        super(timeout, version);
        httpPost = new HttpPost(uri);
        nameValues = new ArrayList<NameValuePair>();
    }

    public static PostRequest newInstance(int timeout, URI uri, String version) {
        return new PostRequest(timeout, uri, version);
    }

    @Override
    protected HttpUriRequest newHttpRequest() {
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(nameValues, Consts.UTF_8);
        httpPost.setEntity(entity);
        RequestConfig requestConfig = RequestConfig.copy(RequestConfig.DEFAULT).setSocketTimeout(super.getTimeout()).setConnectTimeout(super.getTimeout()).setConnectionRequestTimeout(super.getTimeout()).build();
        httpPost.setConfig(requestConfig);

        return httpPost;
    }

    public PostRequest addParameter(String name, String value) {
        nameValues.add(new BasicNameValuePair(name, value));
        return this;
    }

    public PostRequest addHeader(String name, String value) {
        httpPost.addHeader(name, value);
        return this;
    }

    @Override
    public String methodName() {
        return HttpPost.METHOD_NAME;
    }
}
