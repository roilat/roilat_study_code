import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;

public class DingImageUpload {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		
		String ss = "{\"method\":\"dingtalk.corp.message.corpconversation.asyncsend\",\"session\":\"5aafafca3c2e3a8ebe4eebc1271687b4\",\"timestamp\":\"2018-05-23 19:40:00\",\"format\":\"json\",\"v\":\"2.0\",\"msgtype\":\"oa\",\"agent_id\":\"176759951\",\"to_all_user\":\"true\",\"msgcontent\":{\"message_url\": \"http://dingtalk.com\",\"head\": {\"bgcolor\": \"FFBBBBBB\",\"text\": \"头部标题\"},\"body\": {\"title\": \"正文标题\",\"form\": [{\"key\": \"姓名:\",\"value\": \"张三\"},{\"key\": \"爱好:\",\"value\": \"打球、听音乐\"}],\"rich\": {\"num\": \"15.6\",\"unit\": \"元\"},\"content\": \"大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本\",\"image\": \"@lADOADmaWMzazQKA\",\"file_count\": \"3\",\"author\": \"李四 \"}}}";
		System.out.println(JSONObject.parse(ss));
		System.out.println(String.format("bb%s---%s", "aaa","ccc"));
		
		String fileStr = readFile("src/main/java/image.png");
		System.out.println(fileStr);
		String resultJson = doSend(null, "media", fileStr , "image.png", 10000);
		System.out.println(resultJson);
	}
	
	public static String readFile(String file) throws IOException {
		FileInputStream fis = new FileInputStream(file);
		int len = 0;
		StringBuffer sb = new StringBuffer();
		byte[] bs = new byte[1024];
		while((len = fis.read(bs)) > 0) {
			sb.append(new String(bs,0,len,"ISO-8859-1"));
		}
		fis.close();
		return sb.toString();
	}

	public static String doSend(String url, String fileKeyName, String fileStr, String fileName, int timeout) throws ClientProtocolException, IOException {
		String boundary = UUID.randomUUID().toString().replaceAll("-", "");
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(
				"https://oapi.dingtalk.com/media/upload?access_token=5aafafca3c2e3a8ebe4eebc1271687b4&type=image");
		post.addHeader("Content-Type", String.format("multipart/form-data; boundary=%s", boundary));
		post.addHeader("Content-Encoding", "UTF-8");
		StringBuffer reqBody = new StringBuffer();
		String fileFormdataTemplate = "\r\n--" + boundary
				+ "\r\nContent-Disposition:form-data;name=\"%s\";filename=\"%s\""
				+ "\r\nContent-Type:application/octet-stream" + "\r\n\r\n";
		String formDataHeader = String.format(fileFormdataTemplate, "media", fileName);

		String begin = String.format("--%s\r\n",boundary);

		String end = String.format("\r\n--%s--\r\n",boundary);
		reqBody.append(formDataHeader).append(begin).append(end);
		HttpEntity sq = new StringEntity(reqBody.toString());
		post.setEntity(sq);
		HttpResponse res = client.execute(post);
		HttpEntity entity = res.getEntity();
		if (entity != null) {
			String returnStr = EntityUtils.toString(entity, "UTF-8");
			return returnStr;
		}
		//{"errcode":0,"errmsg":"ok","media_id":"@lALPBY0V41n3eujNAljNAyA","created_at":1527074704381,"type":"image"}
		return null;
	}
}
