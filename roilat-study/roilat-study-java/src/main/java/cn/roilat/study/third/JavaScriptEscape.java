package cn.roilat.study.third;

import javax.swing.text.html.HTMLWriter;

import com.alibaba.china.fasttext.security.util.FastEntities;

public class JavaScriptEscape {
    public static void main(String[] args) {
        FastEntities fastEntities = new FastEntities();
        System.out.println(fastEntities.escapeJavaScript("<test>"));
        System.out.println(fastEntities.escape("<test>"));
        HTMLWriter htmlWriter =  new HTMLWriter(null, null);
        
    }
}
