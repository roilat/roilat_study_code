package cn.roilat.study.java.basic.genericity;

import java.util.ArrayList;
import java.util.List;

class Fruit {
}

class Apple extends Fruit {
}

class Jonathan extends Apple {
}

class Orange extends Fruit {
}

public class CovariantArrays {
	public static void main(String[] args) {
		
		// 上界 不arrayList的泛型类型是不是Fruit，add的时候都会出错
		List<Apple> fruits = new ArrayList<Apple>();
		fruits.add(new Apple());
		List<? extends Fruit> flistTop = fruits;// 实际对象的泛型类型可以是Fruit的任何子类
		flistTop.add(null);
		// add Fruit对象会报错
		// flistTop.add(new Fruit());
		// flistTop.add(new Apple());
		Fruit fruit1 = flistTop.get(0);// 而get的时候，只能返回extend后边这个类型，即最高层级的类型
		System.out.println(fruit1);
		
		// 下界	如下示例，就一定不能使用<? super Apple>来get了
		List<? super Apple> temp = new ArrayList<Apple>();
		temp.add(new Apple());
		List<? super Apple> flistBottem =temp;//实际对象的泛型类型可以是Apple自己或者父类
		flistBottem.add(new Apple());
		flistBottem.add(new Jonathan());
		// get Apple对象会报错
		Apple apple = (Apple) flistBottem.get(0);
		Fruit fruit = (Fruit) flistBottem.get(0);
		System.out.println(fruit);
		System.out.println(apple);
	}
}
