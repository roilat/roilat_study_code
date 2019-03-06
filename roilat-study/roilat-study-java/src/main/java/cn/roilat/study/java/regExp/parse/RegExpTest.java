package cn.roilat.study.java.regExp.parse;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.tools.ant.util.regexp.Regexp;

/**
 * @see https://www.cnblogs.com/tsql/p/6386218.html
 * 
 * @author roilat-J
 * @version $Id: RegExpTest.java, v 0.1 2018年12月22日 上午11:16:18 roilat-J Exp $
 */
public class RegExpTest {

    public static void main(String[] args) {
        //find("aaabbb","a*b");
        find("aaabbb","a.+b");
        find("<div>a</div><div>b</div>","<div>(.*?)</div>");//?表示非贪婪
        find("<div>a</div><div>b</div>","<div>(.*)</div>");
        match("aaabbb","a.+b");
        match1();
        matchAssert();
        String s = "/123/321/222/111/333/444";
        Matcher matcher = Pattern.compile("(/[0-9]+){3}").matcher(s);
        if(matcher.find()) {
            System.out.println(matcher.group(0));
            System.out.println(matcher.end());
            System.out.println(s.substring(matcher.end()));
        }
        
        findLast();
        
        testRegStringAndRegExp();
    }
    
    /**
     * 需要注意的是，在string中进行替换时，需要使用4个'\'
     */
    public static void testRegStringAndRegExp() {
        String p = "/lcopr/**/*.json";
        System.out.println(p);
        //p = p.replaceAll("\\*{2}","\\\\w+(/\\\\w+)+").replaceAll("\\*","\\\\w+").replaceAll("\\.","\\\\.");
        p = "/lcopr/\\w+(/\\w+)+/\\w+\\.json";
        System.out.println(p);
        Pattern pattern = Pattern.compile(p);
        System.out.println(pattern.matcher("/lcopr/aaa/bbb/ccc/ddd.json").matches());//
        System.out.println(Pattern.compile("/lcopr/\\w+(/\\w+)+/\\w+\\.json").matcher("/lcopr/aaa/bbb/ccc/ddd.json").matches());//
        System.out.println(Pattern.compile("/lcopr/\\w+(/\\w+)+/\\w+\\.json").matcher("/lcopr/aaa/bbb/ccc/ddd.json").matches());//
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
    /**
     * 正则的贪婪模式和非贪婪模式是一个比较容易混淆的概念，不过，我们可以这么理解，一个人很贪婪，所以他会能拿多少拿多少，换过来，那就是贪婪模式下的正则表达式，能匹配多少就匹配多少，尽可能最多。而非贪婪模式，则是能不匹配就不匹配，尽可能最少。
下面举个例子，示例二：
需求：匹配1后面跟任意个0
源串：10001
使用贪婪模式：10*       结果：1000 和 1
使用非贪婪模式：10*?    结果：1 和 1
首先，*是匹配0个或多个的意思。
贪婪模式下，它表示，首先匹配一个1，然后匹配1后面的0，最多可以匹配3个0，因此得到1000，然后第二次又匹配到一个1，但是后面没有0，因此得到1；
非贪婪模式下，它表示，首先匹配一个1，然后1后面的0，能不匹配就不匹配了，所以，它每次都只是匹配了一个1。
     */
    public static void match1() {
        System.out.println("match1");

        System.out.println("<div>abcdfa\nsdf213123</div>");
        System.out.println("<div>abcdfa\nsdf213123</div>".matches("<div>(.*?)</div>"));//false
        System.out.println("<div>abcdfasdf213123</div>".matches("<div>(.*?)</div>"));//true
        System.out.println("<div>abcdfa\nsdf213123</div>".matches("<div>[\\s\\S]+</div>"));//true
        System.out.println("match1");

    }
    
    /**
     * 环视（断言/零宽断言）
     */
    public static void matchAssert() {
        Pattern pattern = Pattern.compile("(?<=B)AAA");
        System.out.println("matchAssert");
        System.out.println(pattern.matcher("CAAA").matches());//false
        System.out.println(pattern.matcher("BAAA").matches());//true
        System.out.println("matchAssert");
    }
    
    public static void findLast() {
        
        System.out.println("--------------findLast-----------------");
        String str = "<user>\r\n" + 
                "    <user>\r\n" + 
                "        <name>a</name>\r\n" + 
                "    </user>\r\n" + 
                "    <user>\r\n" + 
                "        <name>a</name>\r\n" + 
                "    </user>\r\n" + 
                "</user>\r\n" + 
                "<password>123</password>";
        Pattern pattern = Pattern.compile("(?<=</user>)(?![\\w\\W]*</user>)[\\w\\W]+");
        Matcher matcher = pattern.matcher(str);
        if(matcher.find()) {
            System.out.println(str.substring(matcher.start()));
        }
        System.out.println("--------------findLast-----------------");

    }
}
