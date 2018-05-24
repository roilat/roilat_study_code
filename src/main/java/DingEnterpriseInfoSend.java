import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.CorpMessageCorpconversationAsyncsendRequest;
import com.dingtalk.api.response.CorpMessageCorpconversationAsyncsendResponse;
import com.taobao.api.ApiException;

public class DingEnterpriseInfoSend {

	public static void main(String[] args) throws ApiException {
		DingTalkClient client = new DefaultDingTalkClient("https://eco.taobao.com/router/rest");
		CorpMessageCorpconversationAsyncsendRequest req = new CorpMessageCorpconversationAsyncsendRequest();
		req.setMsgtype("oa");
		req.setAgentId(176759951L);
//		req.setUseridList("zhangsan,lisi");
//		req.setDeptIdList("123,456");
		req.setToAllUser(true);
		req.setMsgcontentString("{\"message_url\": \"http://dingtalk.com\",\"head\": {\"bgcolor\": \"FFBBBBBB\",\"text\": \"头部标题\"},\"body\": {\"title\": \"正文标题\",\"form\": [{\"key\": \"姓名:\",\"value\": \"张三\"},{\"key\": \"爱好:\",\"value\": \"打球、听音乐\"}],\"rich\": {\"num\": \"15.6\",\"unit\": \"元\"},\"content\": \"大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本\",\"image\": \"@lADOADmaWMzazQKA\",\"file_count\": \"3\",\"author\": \"李四 \"}}");
		CorpMessageCorpconversationAsyncsendResponse rsp = client.execute(req, "5aafafca3c2e3a8ebe4eebc1271687b4");
		System.out.println(rsp.getBody());
		//{"dingtalk_corp_message_corpconversation_asyncsend_response":{"result":{"ding_open_errcode":0,"success":true,"task_id":10110942547},"request_id":"3jvzjc9vx101"}}
	}
}
