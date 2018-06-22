package cn.roilat.study.utils.copybak;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

/*import com.hansy.apis.commons.HttpClientHelper;
import com.hansy.base.util.StringUtil;
*/
public class HttpClientUtils {
	
	/*private static Logger log =  LoggerFactory.getLogger(HttpClientHelper.class);
	*//**
	 * 连接超时时间
	 *//*
	public static final int CONNECTION_TIMEOUT_MS = 360000;
	*//**
	 * httpclient读取数据超时时间
	 *//*
	public static final int READ_TIMEOUT_MS = 360000;

	public static final String CONTENT_TYPE_JSON_CHARSET = "application/json;charset=UTF-8";

	public static final String CONTENT_TYPE_XML_CHARSET = "application/xml;charset=UTF-8";

	*//**
	 * httpclient读取内容时使用的字符集
	 *//*
	public static final String DEFAULT_CONTENT_CHARSET_STR = "UTF-8";

	public static final Charset DEFAULT_CONTENT_CHARSET = Charset.forName(DEFAULT_CONTENT_CHARSET_STR);
	
	public HttpClientUtils() {}

	*//**
	 * HttpClientGet调用
	 * @param url
	 * @param params
	 * @param charset
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 * @throws URISyntaxException
	 *//*
	public static String simpleGetInvoke(String url, Map<String, String> params, String charset,Map<String,String> headerMap) throws ClientProtocolException, IOException, URISyntaxException {
		charset = StringUtil.isEmpty(charset)?DEFAULT_CONTENT_CHARSET_STR:charset;
		HttpClient client = buildHttpClient(false);//获取http连接
		HttpGet get = buildHttpGet(url, params, charset);//创建httpGet请求
		if (headerMap != null && headerMap.size() > 0) {
			Iterator<Entry<String, String>> iter = headerMap.entrySet().iterator();
			Entry<String, String> ent;
			while(iter.hasNext()){
				ent = iter.next();
				get.setHeader(ent.getKey(), ent.getValue());
			}
		}
		HttpResponse response = client.execute(get);//请求调用
		assertStatus(response);
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			String returnStr = EntityUtils.toString(entity, charset);
			return returnStr;
		}
		return null;
	}

	*//**
	 * HttpClientPost调用
	 * 
	 * @param url
	 * @param params
	 * @param charset
	 * @return
	 * @throws URISyntaxException
	 * @throws ClientProtocolException
	 * @throws IOException
	 *//*

	public static String simplePostInvoke(String url, Map<String, String> postParams,Map<String,String> getParams, String charset,Map<String,String> headerMap) throws URISyntaxException, ClientProtocolException, IOException {
		charset = StringUtil.isEmpty(charset)?DEFAULT_CONTENT_CHARSET_STR:charset;
		HttpClient client = buildHttpClient(false);
		url = buildGetUrl(url, getParams, charset);
		HttpPost postMethod = buildHttpPost(url, postParams,Charset.forName(charset));
		if (headerMap != null && headerMap.size() > 0) {
			Iterator<Entry<String, String>> iter = headerMap.entrySet().iterator();
			Entry<String, String> ent;
			while(iter.hasNext()){
				ent = iter.next();
				postMethod.setHeader(ent.getKey(), ent.getValue());
			}
		}
		HttpResponse response = client.execute(postMethod);
//		assertStatus(response);
		System.out.println(response.getStatusLine());
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			String returnStr = EntityUtils.toString(entity, charset);
			return returnStr;
		}
		return null;
	}
	
	*//**
	 * HttpClientPost调用
	 * 
	 * @param url
	 * @param params
	 * @param charset
	 * @return
	 * @throws URISyntaxException
	 * @throws ClientProtocolException
	 * @throws IOException
	 *//*
	
	public static String simplePostInvoke(String url, Map<String, String> postParams, String charset,Map<String,String> headerMap) throws URISyntaxException, ClientProtocolException, IOException {
		charset = StringUtil.isEmpty(charset)?DEFAULT_CONTENT_CHARSET_STR:charset;
		HttpClient client = buildHttpClient(false);
		HttpPost postMethod = buildHttpPost(url, postParams,Charset.forName(charset));
		if (headerMap != null && headerMap.size() > 0) {
			Iterator<Entry<String, String>> iter = headerMap.entrySet().iterator();
			Entry<String, String> ent;
			while(iter.hasNext()){
				ent = iter.next();
				postMethod.setHeader(ent.getKey(), ent.getValue());
			}
		}
		HttpResponse response = client.execute(postMethod);
//		assertStatus(response);
		System.out.println(response.getStatusLine());
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			String returnStr = EntityUtils.toString(entity, charset);
			return returnStr;
		}
		return null;
	}
	
	*//**
	 * postJson返回json或普通字符串
	 * @param postUrl 请求的地址
	 * @param jsonStr 请求的json格式的报文
	 * @return String 返回接口响应的json字符串报文，失败返回null
	 *//*
	public static String postJson(String url,String jsonStr,Map<String,String> headerMap,String charset){
		String rs = null;
		charset = StringUtil.isEmpty(charset)?DEFAULT_CONTENT_CHARSET_STR:charset;
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost post = new HttpPost(url);
		setCommonHttpMethod(post);
		if (headerMap != null && headerMap.size() > 0) {
			Iterator<Entry<String, String>> iter = headerMap.entrySet().iterator();
			Entry<String, String> ent;
			while(iter.hasNext()){
				ent = iter.next();
				post.setHeader(ent.getKey(), ent.getValue());
			}
		}
		try {
			StringEntity reqEntity= new StringEntity(jsonStr, ContentType.APPLICATION_JSON);
			post.setEntity(reqEntity);
			log.debug("executing request：{} ",post.getURI());
			CloseableHttpResponse resp = null;
			try {
				resp = client.execute(post);
				StatusLine status = resp.getStatusLine();
				log.debug("respose status：{}",status);
				if(status.getStatusCode()==200){
					HttpEntity entity = resp.getEntity();
					if(entity!=null){
						BufferedHttpEntity bufferedEntity = new BufferedHttpEntity(entity);
						rs = EntityUtils.toString(bufferedEntity, "UTF-8");
					}
				}else{
					HttpEntity entity = resp.getEntity();
					if(entity!=null){
						BufferedHttpEntity bufferedEntity = new BufferedHttpEntity(entity);
						rs = EntityUtils.toString(bufferedEntity, "UTF-8");
					}
				}
			} catch (ClientProtocolException e) {
				log.error(e.getMessage());
				e.printStackTrace();
			} catch (IOException e) {
				log.error(e.getMessage());
				e.printStackTrace();
			} finally {
				if(resp!=null){
					resp.close();
				}
			}
		} catch (UnsupportedCharsetException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		} catch (ParseException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				if(client!=null)
					client.close();
			} catch (IOException e) {
				log.error(e.getMessage());
				e.printStackTrace();
			}
		}
		return rs;
	}
	
	*//**
	 * postJson返回json或普通字符串
	 * @param postUrl 请求的地址
	 * @param jsonStr 请求的json格式的报文
	 * @return String 返回接口响应的json字符串报文，失败返回null
	 *//*
	public static String postXml(String url,String xmlStr,Map<String,String> headerMap,String charset){
		String rs = null;
		charset = StringUtil.isEmpty(charset)?DEFAULT_CONTENT_CHARSET_STR:charset;
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost post = new HttpPost(url);
		setCommonHttpMethod(post);
		if (headerMap != null && headerMap.size() > 0) {
			Iterator<Entry<String, String>> iter = headerMap.entrySet().iterator();
			Entry<String, String> ent;
			while(iter.hasNext()){
				ent = iter.next();
				post.setHeader(ent.getKey(), ent.getValue());
			}
		}
		try {
			StringEntity reqEntity= new StringEntity(xmlStr, ContentType.APPLICATION_XML);
			post.setEntity(reqEntity);
			log.debug("executing request：{} ",post.getURI());
			CloseableHttpResponse resp = null;
			try {
				resp = client.execute(post);
				StatusLine status = resp.getStatusLine();
				log.debug("respose status：{}",status);
				if(status.getStatusCode()==200){
					HttpEntity entity = resp.getEntity();
					if(entity!=null){
						BufferedHttpEntity bufferedEntity = new BufferedHttpEntity(entity);
						rs = EntityUtils.toString(bufferedEntity, "UTF-8");
					}
				}else{
					HttpEntity entity = resp.getEntity();
					if(entity!=null){
						BufferedHttpEntity bufferedEntity = new BufferedHttpEntity(entity);
						rs = EntityUtils.toString(bufferedEntity, "UTF-8");
					}
				}
			} catch (ClientProtocolException e) {
				log.error(e.getMessage());
				e.printStackTrace();
			} catch (IOException e) {
				log.error(e.getMessage());
				e.printStackTrace();
			} finally {
				if(resp!=null){
					resp.close();
				}
			}
		} catch (UnsupportedCharsetException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		} catch (ParseException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				if(client!=null)
					client.close();
			} catch (IOException e) {
				log.error(e.getMessage());
				e.printStackTrace();
			}
		}
		return rs;
	}

	*//** 
	* 创建HttpClient 
	* @param isMultiThread 
	* @return 
	*//*
	private static HttpClient buildHttpClient(boolean isMultiThread) {
		CloseableHttpClient client;
		if (isMultiThread) {
			client = HttpClientBuilder.create().setConnectionManager(new PoolingHttpClientConnectionManager()).build();
		} else {
			client = HttpClientBuilder.create().build();
		}
		return client;
	}

	*//** 
	 * 构建httpGet对象 
	 *  
	 * @param url 
	 * @param charset 
	 * @param headers 
	 * @return 
	 * @throws URISyntaxException 
	 *//*
	private static HttpGet buildHttpGet(String url, Map<String, String> params, String charset) throws URISyntaxException {
		Assert.notNull(url, "构建HttpGet时,url不能为null");
		HttpGet get = new HttpGet(buildGetUrl(url, params,charset));
		return get;
	}
	
	*//** 
	  * build getUrl str 
	  *  
	  * @param url 
	  * @param params 
	  * @return 
	  *//*
	private static String buildGetUrl(String url, Map<String, String> params,String charset) {
		StringBuffer uriStr = new StringBuffer(url);
		if (params != null) {
			List<NameValuePair> ps = new ArrayList<NameValuePair>();
			for (String key : params.keySet()) {
				ps.add(new BasicNameValuePair(key, params.get(key)));
			}
			uriStr.append("?");
			uriStr.append(URLEncodedUtils.format(ps, StringUtil.isEmpty(charset)?DEFAULT_CONTENT_CHARSET_STR:charset));
		}
		return uriStr.toString();
	}

	*//** 
	 * 构建httpPost对象 
	 *  
	 * @param url 
	 * @param headers 
	 * @return 
	 * @throws UnsupportedEncodingException 
	 * @throws URISyntaxException 
	 *//*
	private static HttpPost buildHttpPost(String url, Map<String, String> params,Charset charset) throws UnsupportedEncodingException, URISyntaxException {
		Assert.notNull(url, "构建HttpPost时,url不能为null");
		HttpPost post = new HttpPost(url);
		setCommonHttpMethod(post);
		HttpEntity sq = null;
		if (params != null) {
			List<NameValuePair> formparams = new ArrayList<NameValuePair>();
			for (String key : params.keySet()) {
				formparams.add(new BasicNameValuePair(key, params.get(key)));
			}
			sq = new UrlEncodedFormEntity(formparams, (charset == null)?DEFAULT_CONTENT_CHARSET:charset);
			post.setEntity(sq);
		}
		return post;
	}

	*//**
	 * 设置HttpMethod通用配置
	 * @param httpMethod
	 *//*
	private static void setCommonHttpMethod(HttpRequestBase httpMethod) {
		httpMethod.setHeader(HTTP.CONTENT_ENCODING, DEFAULT_CONTENT_CHARSET_STR);
	}
	   
	   
	*//**
	 * @description: 响应的状态判断，如果不是200，则抛出异常
	 * @creator: roilat-D
	 * @createDate: 2016年11月24日 
	 * @param res
	 * @throws IOException
	 *//*
	static void assertStatus(HttpResponse res) throws IOException {
		Assert.notNull(res, "http响应对象为null");
		Assert.notNull(res.getStatusLine(), "http响应对象的状态为null");
		switch (res.getStatusLine().getStatusCode()) {
			case HttpStatus.SC_OK:
				break;
			default:
				throw new IOException("服务器响应状态异常,响应状态是["+res.getStatusLine().getStatusCode()+"]");
		}
	}

	public static void main(String[] args) throws ClientProtocolException, IOException, URISyntaxException {

		Map<String, String> map = new HashMap<String, String>();
		map.put("partner_code", "hansyinfo");
		map.put("secret_key", "71b4e3aa64ae4f1bb13e67dce341a1c0");
		map.put("token_id", "hansy1478617111988");
		map.put("event_id", "loan_professional_web");// 此处填写策略集上的事件标识
		map.put("id_number", "busiApplyRecords.getApplyCustCertNo");
		map.put("name", "busiApplyRecords.getApplyCustName()");
		map.put("mobile", "busiApplyRecords.getApplyCustMobileNo()");
		map.put("card_number", "busiApplyRecords.getApplyCustBankcardNo()");
//		JSONObject json = JSONObject.fromObject(map);
//		JsonSchema js = new JsonSchema(new ObjectNode(JsonNodeFactory.instance));
		System.out.println(simpleGetInvoke("https://apitest.tongdun.cn/riskService", map, "GBK",null));
	}*/
}

