package cn.roilat.study.java.string;

import org.springframework.util.StringUtils;

public class TestOtherStringUtils {
    public static void main(String[] args) {
        String s = "helloaaahellobbbaaahelloccc";
        System.out.println(StringUtils.arrayToDelimitedString(StringUtils.delimitedListToStringArray(s, "aaa", "bbbb"), ","));
        System.out.println(StringUtils.arrayToDelimitedString(StringUtils.delimitedListToStringArray(s, "aaa", ""), ","));
        System.out.println(StringUtils.arrayToDelimitedString(StringUtils.delimitedListToStringArray(s, "aa", ""), ","));
        System.out.println(StringUtils.arrayToDelimitedString(StringUtils.delimitedListToStringArray(s, "aa", "a"), ","));
        System.out.println(StringUtils.arrayToDelimitedString(StringUtils.delimitedListToStringArray(s, "a", "a"), ","));
        System.out.println(StringUtils.arrayToDelimitedString(s.split("a"),","));
        /**
         * 
         * 
         * 
         * hello,hello,helloccc
         * hello,hellobbb,helloccc
         * hello,ahellobbb,ahelloccc
         * hello,hellobbb,helloccc
         * hello,,,hellobbb,,,helloccc
         * hello,,,hellobbb,,,helloccc
         */
    }

}
