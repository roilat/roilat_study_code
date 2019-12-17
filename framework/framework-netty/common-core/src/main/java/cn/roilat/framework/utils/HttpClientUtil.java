package cn.roilat.framework.utils;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpClientUtil {

	public static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

	public static String doGet(String url, Map<String, String> param) {
		logger.info("开始调用请求：URL=" + url);
		// 创建Httpclient对象
		CloseableHttpClient httpclient = HttpClients.createDefault();

		String resultString = "";
		CloseableHttpResponse response = null;
		try {
			// 创建uri
			URIBuilder builder = new URIBuilder(url);
			if (param != null) {
				for (String key : param.keySet()) {
					builder.addParameter(key, param.get(key));
				}
			}
			URI uri = builder.build();

			// 创建http GET请求
			HttpGet httpGet = new HttpGet(uri);

			// 执行请求
			response = httpclient.execute(httpGet);
			// 判断返回状态是否为200
			if (response.getStatusLine().getStatusCode() == 200) {
				resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
			}
			logger.info("请求结果：RESULT=" + resultString);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (response != null) {
					response.close();
				}
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resultString;
	}

	public static String doGet(String url) {
		return doGet(url, null);
	}

	public static String doPost(String url, Map<String, String> param, Map<String, String> header) throws Exception {
		// 创建Httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		String resultString = "";
		try {
			// 创建Http Post请求
			HttpPost httpPost = new HttpPost(url);

			if (header != null) {
				for (String key : header.keySet()) {
					httpPost.setHeader(key, header.get(key));
				}
			}

			// 创建参数列表
			if (param != null) {
				List<NameValuePair> paramList = new ArrayList<>();
				for (String key : param.keySet()) {
					paramList.add(new BasicNameValuePair(key, param.get(key)));
				}
				// 模拟表单
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList, "utf-8");
				httpPost.setEntity(entity);
			}
			// 执行http请求
			response = httpClient.execute(httpPost);
			resultString = EntityUtils.toString(response.getEntity(), "utf-8");
			logger.info("请求结果：RESULT=" + resultString);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage(), e);
			throw e;
		} finally {
			try {
				if (response != null) {
					response.close();
				}
				if (httpClient != null) {
					httpClient.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return resultString;
	}

	public static String doPost(String url) throws Exception {
		return doPost(url, null, null);
	}

	public static String doPostJson(String url, String json) {
		logger.info("开始调用请求：URL=" + url);
		// 创建Httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		String resultString = "";
		try {
			// 创建Http Post请求
			HttpPost httpPost = new HttpPost(url);
			// 创建请求内容
			StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
			httpPost.setEntity(entity);
			// 执行http请求
			response = httpClient.execute(httpPost);
			resultString = EntityUtils.toString(response.getEntity(), "utf-8");
			logger.info("请求结果：RESULT=" + resultString);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage(), e);
		} finally {
			try {
				response.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resultString;
	}

	public static String doPostForUpload(String url) throws Exception {
		File file = new File("f:\\12.jpg");
		CloseableHttpClient httpClient = HttpClients.createDefault();
		String BoundaryStr = "------------7da2e536604c8";
		CloseableHttpResponse response = null;
		HttpEntity reqEntity = MultipartEntityBuilder.create().setBoundary(BoundaryStr)
				.setCharset(Charset.forName("utf-8")).setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
				.addBinaryBody("media", file, ContentType.APPLICATION_OCTET_STREAM, file.getName()).build();
		HttpPost httpPost = new HttpPost(url);
		httpPost.addHeader("Connection", "keep-alive");
		httpPost.addHeader("Accept", "*/*");
		httpPost.addHeader("Content-Type", "multipart/form-data;boundary=" + BoundaryStr);
		httpPost.addHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0) ");
		httpPost.setEntity(reqEntity);
		response = httpClient.execute(httpPost);
		String resultString = EntityUtils.toString(response.getEntity(), "utf-8");
		return resultString;
	}

	public static void main(String[] args) throws Exception {
		String token = "15_779Zc2H_GjGaCnofExjZ_-JYQ06RKcgjf-Zxn7SpQlAbF81Gy3bvIEpCd3hlu3ZJGra8ugPaYRtRYiHoaYBr9RJ04R-Denc4ip1tgab4Sup5QNenEqtCv6Yg5Zei1onV_-0wNUKW9uYE4HqIEJMgADAXCF";
		String url = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=%s&type=image";
		String result = doPostForUpload(String.format(url, token));
		System.out.println("rs-->" + result);
		// System.out.println(doGet(String.format(WxConstant.ACCESS_TOKEN_URI,
		// WxConstant.AppId,WxConstant.AppSecret)));
	}
}
