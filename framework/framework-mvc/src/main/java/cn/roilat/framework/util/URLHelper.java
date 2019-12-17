package cn.roilat.framework.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class URLHelper {
    public static String appendUrlParams(String url, Map<String, String> params) {
        if (params != null && !params.isEmpty()) {
            StringBuilder sb = new StringBuilder(url);
            sb.append(url.indexOf('?') >= 0 ? "&" : "?");
            Iterator<Entry<String, String>> iter = params.entrySet().iterator();
            while (iter.hasNext()) {
                Entry<String, String> entry = iter.next();
                sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
            return sb.deleteCharAt(sb.length() - 1).toString();
        } else {
            return url;
        }
    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("aaa", "dssd");
        map.put("bbb", "dssd");
        System.out.println(URLHelper.appendUrlParams("http://localhost:8080/test", map));
        System.out.println(URLHelper.appendUrlParams("http://localhost:8080/test?name=1", map));
    }
}
