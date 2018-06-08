import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class DingImageUpload {

	private static String ENCODING_ISO_8859_1 = "ISO-8859-1";
	private static String ENCODING_UTF_8 = "UTF-8";
	private static String ACCESS_TOKEN = "f2f47de45e53308980d3e33e56b09913";

	public static void main(String[] args) throws ClientProtocolException, IOException {

		String fileStr = readFile("src/main/java/image.png");
		byte[] fileBs = fileStr.getBytes(ENCODING_ISO_8859_1);
		String url = String.format("https://oapi.dingtalk.com/media/upload?access_token=%s&type=image",
				ACCESS_TOKEN);
		String resultJson = doSend(url, fileBs, "image.png");
		System.out.println(resultJson);
	}

	public static String readFile(String file) throws IOException {
		FileInputStream fis = new FileInputStream(file);
		int len = 0;
		StringBuffer sb = new StringBuffer();
		byte[] bs = new byte[1024];
		while ((len = fis.read(bs)) > 0) {
			sb.append(new String(bs, 0, len, ENCODING_ISO_8859_1));
		}
		fis.close();
		return sb.toString();
	}

	public static String doSend(String url, byte[] fileBytes, String fileName)
			throws ClientProtocolException, IOException {
		String boundary = UUID.randomUUID().toString().replaceAll("-", "");
		// 构建client
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(url);
		// 设置头参数
		post.addHeader("Content-Type", String.format("multipart/form-data; boundary=%s", boundary));
		post.addHeader("Content-Encoding", "UTF-8");
		// 构建请求体
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		String begin = String.format("\r\n--%s", boundary);
		String fileFormdataTemplate = "\r\nContent-Disposition:form-data;name=\"media\";filename=\"%s\"\r\nfilelength=\"%d\""
				+ "\r\nContent-Type:application/octet-stream" + "\r\n\r\n";
		String formDataHeader = String.format(fileFormdataTemplate, fileName,fileBytes.length);
		String end = String.format("\r\n--%s--\r\n", boundary);
		baos.write(begin.getBytes(ENCODING_UTF_8));
		baos.write(formDataHeader.getBytes(ENCODING_UTF_8));
		baos.write(fileBytes);
		baos.write(end.getBytes(ENCODING_UTF_8));
		HttpEntity sq = new ByteArrayEntity(baos.toByteArray());
		baos.close();
		post.setEntity(sq);
		// 接口调用
		HttpResponse res = client.execute(post);
		HttpEntity entity = res.getEntity();
		if (entity != null) {
			String returnStr = EntityUtils.toString(entity, "UTF-8");
			return returnStr;
		}
		//{"errcode":0,"errmsg":"ok","media_id":"@lALPBY0V41sH6icqKg","created_at":1527148458636,"type":"image"}
		return null;
	}
}
