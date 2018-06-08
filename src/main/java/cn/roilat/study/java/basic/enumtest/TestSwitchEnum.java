package cn.roilat.study.java.basic.enumtest;

public class TestSwitchEnum {
    public static void main(String[] args) {
        TrafficLight tl = new TrafficLight();
        tl.change();
        tl.change();
        tl.change();
        tl.change();
        tl.change();
        tl.change();
        tl.change();
    }
}
//JDK1.6之前的switch语句只支持int,char,enum类型，使用枚举，能让我们的代码可读性更强。 
enum Signal {
             GREEN, YELLOW, RED
}

class TrafficLight {
    Signal color = Signal.RED;

    public void change() {
        switch (color) {
            case RED:
                color = Signal.GREEN;
                break;
            case YELLOW:
                color = Signal.RED;
                break;
            case GREEN:
                color = Signal.YELLOW;
                break;
        }
        System.out.println(color);
    }
}