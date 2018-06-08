package cn.roilat.study.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * http工具,没事别手贱改
 * 
 * @author ashy
 *
 */
public class HttpUtilsForXMl {
	public static String doHttpsPost(String url, String param) throws Exception {
		return postApache(url, param);
	}

	public static String postApache(String url, String param) {
		HttpPost post = new HttpPost(url);
		StringBuffer buff = new StringBuffer();
		String rep = "";
		try {
			StringEntity s = new StringEntity(param, "utf-8");
			s.setContentEncoding("UTF-8");
			s.setContentType("application/json");
			post.setEntity(s);
			CloseableHttpResponse response = HttpClients.createDefault().execute(post);
			HttpEntity entity = response.getEntity();
			if (null  != entity) {
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(entity.getContent(),"utf-8"));
				while ((rep = bufferedReader.readLine()) != null)
					buff.append(rep);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return buff.toString();
	}

	protected static String clientCustomPost(String url, String param, CloseableHttpClient httpclient) {
		StringBuffer buff = new StringBuffer();
		String retData = "";
		try {
			HttpPost post = new HttpPost(url);
			StringEntity s = new StringEntity(param, "utf-8");
			s.setContentEncoding("UTF-8");
			s.setContentType("application/json");
			post.setEntity(s);
			CloseableHttpResponse response = httpclient.execute(post);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(entity.getContent()));
				while ((retData = bufferedReader.readLine()) != null) {
					buff.append(retData);
				}
			}
			httpclient.close();
			response.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return buff.toString();
	}

}
