package cn.roilat.study.utils;

public class StringUtil {

    public static boolean equals(String key, String expression) {
        if (key == null) {
            return expression == null;
        }
        return key.equals(expression);
    }

    public static void main(String[] args) {
        System.out.println(equals(null, null));
        System.out.println(equals(null, ""));
        System.out.println(equals("", null));
        System.out.println(equals("", ""));
        System.out.println("   \t:"+isBlank("   \t"));

    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() <= 0;
    }

    public static boolean isBlank(String str) {
        return str == null || str.replaceAll("\\s|\\t|\\n|\\r", "").length() <= 0;
    }
}
