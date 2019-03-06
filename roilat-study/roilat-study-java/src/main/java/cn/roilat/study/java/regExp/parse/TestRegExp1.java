package cn.roilat.study.java.regExp.parse;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegExp1 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("opt", "roilat");
        map.put("desc", "大帝空间");
        map.put("detail", "owner");
        String temp = "${opt}将你在“${desc}”空间中的角色修改为：${detail}，请知晓。";
        System.out.println("abc def".replaceFirst("(\\w+)\\s+(\\w+)", "$2 $1"));
        System.out.println(replace(temp,map));
        System.out.println(replace("aasfdsdf",map));
    }

    public static String replace(String template, Map<String, String> map) {
        //Pattern pattern = Pattern.compile("(?<=\\$\\{).+?(?=\\})");
        Pattern pattern = Pattern.compile("\\$\\{.+?\\}");
        Matcher matcher = pattern.matcher(template);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            String name = matcher.group();
            matcher.appendReplacement(sb, map.get(name.substring(2, name.length()-1)));
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
}
