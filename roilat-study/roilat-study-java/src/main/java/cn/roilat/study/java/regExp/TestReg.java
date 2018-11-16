package cn.roilat.study.java.regExp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * http://www.runoob.com/java/java-regular-expressions.html
 * 
 * @author roilat-J
 * @version $Id: TestReg.java, v 0.1 2018年11月15日 下午6:29:52 roilat-J Exp $
 */
public class TestReg {

    public static void simpleMatch() {
        System.out.println("-------simpleMatch------");
        System.out.println("\"aaaa\".matches(\"a{1,}\")=" + "aaaa".matches("a{1,}"));
        System.out.println("" + "aabbccddeeff12".matches("^a{2}\\w*\\d{2}$"));

        // 按指定模式在字符串查找
        String line = "This order was placed for QT3000! OK?";
        String pattern = "(\\D*)(\\d+)(.*)";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        if (m.find()) {
            System.out.println("Found value: " + m.group(0));
            System.out.println("Found value: " + m.group(1));
            System.out.println("Found value: " + m.group(2));
            System.out.println("Found value: " + m.group(3));
        } else {
            System.out.println("NO MATCH");
        }
        System.out.println("-------simpleMatch------");
    }

    /**
     * 测试全匹配
     */
    public static void testAllMatch() {
        System.out.println("-------testAllMatch------");
        Pattern pattern = Pattern.compile("^a{2}\\w*\\d{2}$");
        Matcher matcher = pattern.matcher("aabbccddeeff12");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
        System.out.println("-------testAllMatch------");
    }

    /**
     * 当此字符紧随任何其他限定符（*、+、?、{n}、{n,}、{n,m}）之后时，匹配模式是"非贪心的"。"非贪心的"模式匹配搜索到的、尽可能短的字符串，而默认的"贪心的"模式匹配搜索到的、尽可能长的字符串。例如，在字符串"oooo"中，"o+?"只匹配单个"o"，而"o+"匹配所有"o"。
     */
    public static void testNotGreed() {
        System.out.println("-------testNotGreed------");
        //Pattern pattern = Pattern.compile("d{1,}?");
        //Pattern pattern = Pattern.compile("d{3,}");
        //Pattern pattern = Pattern.compile("d{2,}");
        Pattern pattern = Pattern.compile("d{2,}?");
        Matcher matcher = pattern.matcher("abcddddabceellabcdddasdddabddc");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
        System.out.println("-------testNotGreed------");
    }

    /**
     * (?:pattern)
    匹配 pattern 但不捕获该匹配的子表达式，即它是一个非捕获匹配，不存储供以后使用的匹配。这对于用"or"字符 (|) 组合模式部件的情况很有用。例如，'industr(?:y|ies) 是比 'industry|industries' 更经济的表达式。
     */
    public static void testPattern1() {
        System.out.println("-------testPattern1------");
        Pattern pattern = Pattern.compile("industr(?:y|ies)");
        Matcher matcher = pattern.matcher("industry====industries");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
        /**
         * industry
         * industries
         */
        System.out.println("-------testPattern1------");
    }

    /**
     *(?=pattern)
     *执行正向预测先行搜索的子表达式，该表达式匹配处于匹配 pattern 的字符串的起始点的字符串。它是一个非捕获匹配，即不能捕获供以后使用的匹配。例如，'Windows (?=95|98|NT|2000)' 匹配"Windows 2000"中的"Windows"，但不匹配"Windows 3.1"中的"Windows"。预测先行不占用字符，即发生匹配后，下一匹配的搜索紧随上一匹配之后，而不是在组成预测先行的字符后。
     */
    public static void testPattern2() {
        System.out.println("-------testPattern2------");
        Pattern pattern = Pattern.compile("Windows (?=95|98|NT|2000)");
        Matcher matcher = pattern.matcher("Windows 2000     Windows 3.1");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
        /**
         * industry
         * industries
         */
        System.out.println("-------testPattern2------");
    }

    /**
     *(?!pattern)
     *   执行反向预测先行搜索的子表达式，该表达式匹配不处于匹配 pattern 的字符串的起始点的搜索字符串。它是一个非捕获匹配，即不能捕获供以后使用的匹配。例如，'Windows (?!95|98|NT|2000)' 匹配"Windows 3.1"中的 "Windows"，但不匹配"Windows 2000"中的"Windows"。预测先行不占用字符，即发生匹配后，下一匹配的搜索紧随上一匹配之后，而不是在组成预测先行的字符后。
     */
    public static void testPattern3() {
        System.out.println("-------testPattern3------");
        Pattern pattern = Pattern.compile("Windows (?!95|98|NT|2000)");
        Matcher matcher = pattern.matcher("Windows 2000     Windows 3.1");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
        /**
         * industry
         * industries
         */
        System.out.println("-------testPattern3------");
    }

    /**
     * matches 和 lookingAt 方法都用来尝试匹配一个输入序列模式。它们的不同是 matches 要求整个序列都匹配，而lookingAt 不要求。
     * lookingAt 方法虽然不需要整句都匹配，但是需要从第一个字符开始匹配。
     * 这两个方法经常在输入字符串的开始使用。
     */
    public static void testMatchAndLookAt() {
        System.out.println("-------testMatchAndLookAt------");

        String REGEX = "foo";
        String INPUT = "fooooooooooooooooo";
        String INPUT2 = "ooooofoooooooooooo";
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(INPUT);
        Matcher matcher2 = pattern.matcher(INPUT2);

        System.out.println("Current REGEX is: " + REGEX);
        System.out.println("Current INPUT is: " + INPUT);
        System.out.println("Current INPUT2 is: " + INPUT2);

        System.out.println("lookingAt(): " + matcher.lookingAt());
        System.out.println("matches(): " + matcher.matches());
        System.out.println("lookingAt(): " + matcher2.lookingAt());
        System.out.println("-------testMatchAndLookAt------");

    }

    /**
     */
    public static void testAppendReplacementAndTail() {
        System.out.println("-------testAppendReplacementAndTail------");
        String REGEX = "a*b";
        String INPUT = "aabfooaabfooabfoobkkk";
        String REPLACE = "-";
        Pattern p = Pattern.compile(REGEX);
        // 获取 matcher 对象
        Matcher m = p.matcher(INPUT);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sb, REPLACE);
        }
        m.appendTail(sb);
        System.out.println(sb.toString());
        System.out.println("-------testAppendReplacementAndTail------");
    }

    public static void main(String[] args) {
        simpleMatch();
        testAllMatch();
        testNotGreed();
        testPattern1();
        testPattern2();
        testPattern3();
        testMatchAndLookAt();
        testAppendReplacementAndTail();
    }
}
