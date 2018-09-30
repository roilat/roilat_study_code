package cn.roilat.study.java.basic.throwable;

public class TestCatchError {

    public static void main(String[] args) {
        try {
            throw new Error();
        }catch(Error er) {
            er.printStackTrace();
        }
    }

}
