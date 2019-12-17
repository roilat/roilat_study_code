package cn.roilat.demo.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TestModel {
    private String name;
    private String id;

    public static void main(String[] args) {
        System.out.println(new TestModel("aaa","bbb"));
    }
}
