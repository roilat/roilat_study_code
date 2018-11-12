package cn.roilat.study.java.multhread.casunsafe;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import sun.misc.Unsafe;

@SuppressWarnings("restriction")
public class TestCASAndUnsafe {

    public int value = 20;

    public static void main(String[] args) throws NoSuchFieldException, SecurityException,
                                           ClassNotFoundException, NoSuchMethodException,
                                           IllegalAccessException, IllegalArgumentException,
                                           InvocationTargetException, InstantiationException {
        
        
        @SuppressWarnings("unchecked")
        Class<sun.misc.Unsafe> unsafeClass = (Class<Unsafe>) TestCASAndUnsafe.class.getClassLoader().loadClass("sun.misc.Unsafe");
        System.out.println(unsafeClass);
        Unsafe unsafe;
        try {
            unsafe = (Unsafe) unsafeClass.getMethod("getUnsafe", new Class<?>[] {}).invoke(null,new Object[] {});
            System.out.println(unsafe);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 通过反射得到theUnsafe对应的Field对象
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        // 设置该Field为可访问
        field.setAccessible(true);
        // 通过Field得到该Field对应的具体对象，传入null是因为该Field为static的
        unsafe = (Unsafe) field.get(null);
        System.out.println(unsafe);

        TestCASAndUnsafe test = new TestCASAndUnsafe();
        long valueOffSet = unsafe.objectFieldOffset(TestCASAndUnsafe.class.getDeclaredField("value"));
        System.out.println("the value=" + valueOffSet);
        System.out.println(unsafe.compareAndSwapInt(test, valueOffSet, 20, 21)+ ",the value after update:" + test.value);
        System.out.println(unsafe.compareAndSwapInt(test, valueOffSet, 20, 22)+ ",the value after update:" + test.value);
        


        //通过allocateInstance直接创建对象
        User user = (User) unsafe.allocateInstance(User.class);

        Class<?> userClass = user.getClass();
        Field name = userClass.getDeclaredField("name");
        Field age = userClass.getDeclaredField("age");
        Field id = userClass.getDeclaredField("id");

        //获取实例变量name和age在对象内存中的偏移量并设置值
        unsafe.putInt(user, unsafe.objectFieldOffset(age), 18);
        unsafe.putObject(user, unsafe.objectFieldOffset(name), "android TV");

        // 这里返回 User.class，
        Object staticBase = unsafe.staticFieldBase(id);
        System.out.println("staticBase:" + staticBase);

        //获取静态变量id的偏移量staticOffset
        long staticOffset = unsafe.staticFieldOffset(userClass.getDeclaredField("id"));
        //获取静态变量的值
        System.out.println("设置前的ID:" + unsafe.getObject(staticBase, staticOffset));
        //设置值
        unsafe.putObject(staticBase, staticOffset, "SSSSSSSS");
        //获取静态变量的值
        System.out.println("设置后的ID:" + unsafe.getObject(staticBase, staticOffset));
        //输出USER
        System.out.println("输出USER:" + user.toString());

        long data = 1000;
        byte size = 1;//单位字节

        //调用allocateMemory分配内存,并获取内存地址memoryAddress
        long memoryAddress = unsafe.allocateMemory(size);
        //直接往内存写入数据
        unsafe.putAddress(memoryAddress, data);
        //获取指定内存地址的数据
        long addrData = unsafe.getAddress(memoryAddress);
        System.out.println("addrData:" + addrData);

        /**
         * 输出结果:
         sun.misc.Unsafe@6f94fa3e
         staticBase:class geym.conc.ch4.atomic.User
         设置前的ID:USER_ID
         设置前的ID:SSSSSSSS
         输出USER:User{name='android TV', age=18', id=SSSSSSSS'}
         addrData:1000
         */

    }
}

class User {
    public User() {
        System.out.println("user 构造方法被调用");
    }

    private String        name;
    private int           age;
    private static String id = "USER_ID";

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", age=" + age + '\'' + ", id=" + id + '\'' + '}';
    }
}
