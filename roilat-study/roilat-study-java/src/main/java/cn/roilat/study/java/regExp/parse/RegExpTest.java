package cn.roilat.study.java.regExp.parse;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpTest {

    public static void main(String[] args) {
        //find("aaabbb","a*b");
        find("aaabbb","a.+b");
        match("aaabbb","a.+b");
    }
    
    public static void find(String str,String regExp) {
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(str);
        while(matcher.find()) {
            System.out.println(matcher.group(0));
        }
    }
    public static void match(String str,String regExp) {
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(str);
        System.out.println(str + (matcher.matches()?"":" not")+" match " + regExp);
    }
}
