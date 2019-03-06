package cn.roilat.study.java.version52.newfunc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestLamda {
    public static void main(String[] args) {
        List<String> proNames = Arrays.asList(new String[] { "Ni", "Hao", "Lambda" });
        List<String> lowercaseNames2 = proNames.stream().map(name -> name.toLowerCase())
            .collect(Collectors.toList());
        System.out.println(lowercaseNames2);

        int p1 = 32;
        int p2 = 22;
        
        Operator1 operator1 = (a, b) -> {
            return a + b;
        };
        System.out.println(operator1.add(p1 , p2));
    }
}

interface Operator {
    int add(int a, int b);

    int minus(int a, int b);
}

interface Operator1 {
    int add(int a, int b);
}