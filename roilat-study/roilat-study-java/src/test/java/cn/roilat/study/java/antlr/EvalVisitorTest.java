package cn.roilat.study.java.antlr;
/*
import java.io.FileInputStream;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import cn.roilat.study.java.antlr.CalParser.ProgContext;

public class EvalVisitorTest {

    @Test
    public void testEvalVisitor() throws Exception {
        String file = "src/test/java/cn/roilat/study/java/antlr/test.in";
        //创建输入文件流
        FileInputStream inputStream = new FileInputStream(file);
        //转化为字符流
        CharStream input = CharStreams.fromStream(inputStream);
        //创建词法分析器
        CalLexer lexer = new CalLexer(input);
        //获取Token集
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        //创建语法分析器
        CalParser parser = new CalParser(tokenStream);
        //分析语法
        ProgContext tree = parser.prog();
        //遍历语法树，输出结果
        EvalVisitor visitor = new EvalVisitor();
        //当遍历树时如果出错，会返回空指针，在这里捕获
        try {
            visitor.visit(tree);
        } catch (NullPointerException e) {
            System.out.println("oops, we have some problem");
        }
    }

}*/
