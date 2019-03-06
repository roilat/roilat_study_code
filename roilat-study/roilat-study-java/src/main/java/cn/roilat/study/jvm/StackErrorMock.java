package cn.roilat.study.jvm;

public class StackErrorMock {
    private int index = 1;

    public void call() {
        index++;
        call();
    }

    public static void main(String[] args) {
        StackErrorMock mock = new StackErrorMock();
        try {
            mock.call();
        } catch (Throwable e) {
            System.out.println("Stack deep : " + mock.index);
        }
    }
    /**
     * Stack deep : 18893
     * Stack deep : 19138
     * Stack deep : 18944
     * Stack deep : 19144
     * Stack deep : 17942
     */

}
