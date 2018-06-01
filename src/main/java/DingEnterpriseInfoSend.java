import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.CorpMessageCorpconversationAsyncsendRequest;
import com.dingtalk.api.request.CorpMessageCorpconversationGetsendprogressRequest;
import com.dingtalk.api.response.CorpMessageCorpconversationAsyncsendResponse;
import com.dingtalk.api.response.CorpMessageCorpconversationGetsendprogressResponse;
import com.taobao.api.ApiException;

public class DingEnterpriseInfoSend {
	public static String access_token = "8a671a77352c35b7a9a5217fb3929012";
	public static Long agent_id = 176869871L;

	public static void main(String[] args) throws ApiException {
		/*Long taskId = send();
		query(taskId);*/
		query(10734730196L);
	}
	
	public static Long send() throws ApiException {
		DingTalkClient client = new DefaultDingTalkClient("https://eco.taobao.com/router/rest");
		CorpMessageCorpconversationAsyncsendRequest req = new CorpMessageCorpconversationAsyncsendRequest();
		req.setMsgtype("oa");
		//req.setMsgtype("link");
		req.setAgentId(agent_id);
		req.setUseridList("36015334896118,051226180826178168,manager6087,083402174535649191,071601596135515211,040036041523332277,033129516519836901,010656261224493,040036041523332277,033129516519836901,25085037852508,0567010503654861");
//		req.setDeptIdList("123,456");
		//req.setToAllUser(true);
		req.setMsgcontentString(genMsg());
		//req.setMsgcontentString("{\"message_url\": \"http://dingtalk.com\",\"head\": {\"bgcolor\": \"FFBBBBBB\",\"text\": \"头部标题\"},\"body\": {\"title\": \"正文标题\",\"form\": [{\"key\": \"姓名:\",\"value\": \"张三\"},{\"key\": \"爱好:\",\"value\": \"打球、听音乐\"}],\"rich\": {\"num\": \"15.6\",\"unit\": \"元\"},\"content\": \"111为什么不成功，成功了吗？\",\"image\": \"@lADOADmaWMzazQKA\",\"file_count\": \"3\",\"author\": \"李四 \"}}");
		//req.setMsgcontentString("{\"messageUrl\": \"http://www.iachina.cn/art/2017/12/27/art_25_101133.html\",\"picUrl\":\"@lALOACZwe2Rk\",\"title\": \"【媒体聚焦】保监会拟禁止险企与问题私募合作--金融--人民网\",\"text\": \"北京商报讯（记者 许晨辉）随着私募股权投资规模不断扩大，股权基金投资机构内部管理问题也开始显露。12月26日，保监会官网对外通报，前海方舟资产管理有限公司等5家股权投资基金管理机构违反保险资金运用监管规定，合规意识不强，内部管理存在问题。\"}");
		CorpMessageCorpconversationAsyncsendResponse rsp = client.execute(req, access_token);
		System.out.println(rsp.getBody());
		System.out.println(rsp.getErrorCode());
		System.out.println(rsp.getErrcode());
		System.out.println(rsp.getSubCode());
		System.out.println(rsp.getResult().getSuccess());
		return rsp.getResult().getTaskId();
	}
	public static void query(Long taskId) throws ApiException {
		DingTalkClient client = new DefaultDingTalkClient("https://eco.taobao.com/router/rest");
		CorpMessageCorpconversationGetsendprogressRequest req = new CorpMessageCorpconversationGetsendprogressRequest();
		req.setAgentId(agent_id);
		req.setTaskId(taskId);
		CorpMessageCorpconversationGetsendprogressResponse rsp = client.execute(req, access_token);
		System.out.println(rsp.getBody());
	}
	
	public static String genMsg() {
		JSONObject head = new JSONObject();
		head.put("bgcolor", "FFBBBBBB");
		head.put("text", "【媒体聚焦】保监会拟禁止险企与问题私募合作--金融--人民网");
		
		JSONArray form = new JSONArray();
		JSONObject temp = new JSONObject();
		temp.put("key", "保险业协会：媒体聚焦");
		temp.put("value", "");
		form.add(temp);
		
		JSONObject body = new JSONObject();
		body.put("title", "【媒体聚焦】保监会拟禁止险企与问题私募合作--金融--人民网");
		body.put("form", form);
		body.put("content", "         　　北京商报讯（记者 许晨辉）随着私募股权投资规模不断扩大，股权基金投资机构内部管理问题也开始显露。12月26日，保监会官网对外通报，前海方舟资产管理有限公司等5家股权投资基金管理机构违反保险资金运用监管规定，合规意识不强，内部管理存在问题。    　　通报显示，今年以来，保监会开展了保险资金运用风险排查专项整治工作。在有关保险资金投资股权投资基金业务风险排查中，经非现场监管和质询发现，前海方舟资产管理有限公司、人保远望资产管理公司、上海鼎迎投资管理中心、东方国新创业投资管理（新疆）有限公司、信达风投资管理有限公司等股权基金投资机构对涉及保险资金运用的合规意识不强，内部管理存在问题，未依据规定按时向保监会报送年度报告。    　　保监会要求，保险资金投资私募股权基金的投资机构应当于每年3月31日前，就保险资金投资股权投资基金的情况向保监会提交年度报告。而投资上述机构管理的股权基金保险公司应当切实加强投后管理，定期了解投资情况和相关机构合规运作情况。上述投资机构也应当认真整改，杜绝类似事件再次发生。为了防止私募股权投资风险，保监会还透露将探索建立黑名单制度，禁止保险机构与存在合规问题的相关机构开展业务。                         (责编：李栋、赵爽)       ".trim());
		
		JSONObject msg = new JSONObject();
		msg.put("message_url", "http://www.cbrc.gov.cn/chinese/home/docView/C9C43805D3534C91A705DA5968A26220.html");
		msg.put("pc_message_url", "http://www.cbrc.gov.cn/chinese/home/docView/C9C43805D3534C91A705DA5968A26220.html");
		msg.put("head", head);
		msg.put("body", body);
		return msg.toJSONString();
	}
}
