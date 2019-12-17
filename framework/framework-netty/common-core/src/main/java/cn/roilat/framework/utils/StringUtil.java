package cn.roilat.framework.utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.util.StringUtils;

import com.google.common.collect.Lists;

public class StringUtil {

	public static final String EMPTY = "";

	/********
	 * 将字符串为null转换成空白字符
	 * 
	 * @param str
	 * @return
	 */
	public static String nullToEmpty(String str) {
		return str == null ? EMPTY : str;
	}

	/********
	 * 判断字符串是否为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return str == null || str.trim().length() == 0;
	}

	/********
	 * 判断字符串是否不为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}

	/******
	 * 去掉字符串两端空白
	 * 
	 * @param str
	 * @return
	 */
	public static String trimWhitespace(String str) {
		return isEmpty(str) ? str : str.trim();
	}

	/******
	 * 字符串集合转换成数组
	 * 
	 * @param collection
	 * @return
	 */
	public static String[] listToStringArray(Collection<String> collection) {
		return (collection == null || collection.size() == 0) ? null : collection.stream().toArray(String[]::new);
	}

	/*********
	 * 将数组转换成集合
	 * 
	 * @param str
	 *            数组列表
	 * @return
	 */
	public static List<String> arrayToStringList(String[] str) {
		return (str == null || str.length == 0) ? null : Stream.of(str).collect(Collectors.toList());
	}

	public static boolean startsWithIgnoreCase(String str, String prefix) {
		if (isEmpty(str) || isEmpty(prefix)) {
			return false;
		}
		if (str.startsWith(prefix)) {
			return true;
		}
		String lcstr = str.substring(0, prefix.length()).toLowerCase();
		String lcprefix = prefix.toLowerCase();
		return lcstr.equals(lcprefix);
	}

	public static boolean endsWithIgnoreCase(String str, String suffix) {
		if (isEmpty(str) || isEmpty(suffix)) {
			return false;
		}
		if (str.endsWith(suffix)) {
			return true;
		}
		String lcstr = str.substring(str.length() - suffix.length()).toLowerCase();
		String lcsuffix = suffix.toLowerCase();
		return lcstr.equals(lcsuffix);
	}

	/******
	 * 将字符串按照给定的分隔符(,)进行拆分
	 * 
	 * @param str
	 *            字符串
	 * @return
	 */
	public static String[] splitStringToArray(String str) {
		return splitStringToArray(str, ",");
	}

	/******
	 * 将字符串按照给定的分隔符进行拆分
	 * 
	 * @param str
	 *            字符串
	 * @param delim
	 *            分隔符
	 * @return
	 */
	public static String[] splitStringToArray(String str, String delim) {
		if (isEmpty(str)) {
			return null;
		}
		if (isEmpty(delim)) {
			return new String[] { str };
		}

		return Stream.of(str.split(delim)).toArray(String[]::new);
	}

	public static List<String> splitStringToList(String str, String delim) {
		if (isEmpty(str)) {
			return null;
		}
		if (isEmpty(delim)) {
			return Lists.newArrayList(str);
		}
		return Stream.of(str.split(delim, -1)).collect(Collectors.toList());
	}

	/**********
	 * 给定的字符串数组按照分隔符(,)进行组合
	 * 
	 * @param arr
	 * @return
	 */
	public static String arrayToDelimitedString(String[] arr) {
		return arrayToDelimitedString(arr, ",");
	}

	/**********
	 * 给定的字符串数组按照分隔符进行组合
	 * 
	 * @param arr
	 * @param delim
	 *            指定分割符号
	 * @return
	 */
	public static String arrayToDelimitedString(String[] arr, String delim) {
		if (ObjectUtil.isEmptyForObject(arr)) {
			return null;
		}
		if (arr.length == 1) {
			return arr[0];
		}
		delim = nullToEmpty(delim);
		return Stream.of(arr).collect(Collectors.joining(delim));
	}

	/**
	 * 使用正则表达式来判断字符串中是否包含大写字母
	 * 
	 * @param str
	 *            待检验的字符串
	 * @return 返回是否包含 true: 包含 ;false 不包
	 */
	public static boolean judgeContainsUpperCase(String str) {
		String regex = ".*[A-Z]+.*";
		Matcher m = Pattern.compile(regex).matcher(str);
		return m.matches();
	}

	/**
	 * 参数格式 key=value&key=value&key=value
	 * 
	 * @param str
	 * @return
	 */
	public static Map<String, String> string2Map(String str) {
		Map<String, String> map = new HashMap<String, String>();
		if (!str.contains("&")) {
			return map;
		}
		String[] strs = str.split("&");
		for (int i = 0; i < strs.length; i++) {
			String s = strs[i];
			String[] keyValue = s.split("=");
			if (keyValue != null && keyValue.length == 2) {
				String key = keyValue[0];
				String value = keyValue[1];
				map.put(key, value);
			}
		}
		return map;
	}

	public static void main(String[] args) {
		String str = "工号|姓名|身份证号|机构编码|机构名称|参加工作时间|出生日期|邮箱|性别|本公司入职时间|金融工作开始时间|政治面貌|年龄|手机号|本公司合同签订时间|籍贯|用工类别|出生地|最高学历|职务|护照信息|血型|工作地点|婚姻状况|家庭电话|所在单位|一级部门|二级部门|三级部门|四级部门|证件签发机构|从事现岗位时间|岗位|民族|国籍|证件有效期始|证件有效期至|现居住地| QQ|是否减员";
		StringTokenizer st = new StringTokenizer(str,"\\|");
		while(st.hasMoreTokens()){
			System.out.println(st.nextToken().trim());
		}
		List<String> list = Lists.newArrayList("c","a","b");
		System.out.println(list.stream().map(String::toUpperCase).collect(Collectors.counting()).toString());
	}

	/**
	 * 检查指定的字符串列表是否不为空。
	 */
	public static boolean areNotEmpty(String... values) {
		boolean result = true;
		if (values == null || values.length == 0) {
			result = false;
		} else {
			for (String value : values) {
				result &= !StringUtils.isEmpty(value);
			}
		}
		return result;
	}
}
