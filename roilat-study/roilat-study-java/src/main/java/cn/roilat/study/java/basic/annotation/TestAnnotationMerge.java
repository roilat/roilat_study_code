package cn.roilat.study.java.basic.annotation;

import java.lang.annotation.Annotation;

public class TestAnnotationMerge {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> c = Class.forName("cn.roilat.study.java.basic.annotation.Student");
        System.out.println(c.getAnnotatedInterfaces().length);
        System.out.println(c.getAnnotations().length);
        Annotation user = c.getAnnotation(User.class);
        System.out.println(user);
        
        System.out.println(user.getClass());
        Annotation[] annotations = user.getClass().getInterfaces()[0].getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }

}
@User(id="id",name="name")
class Student{
    Annotation annotation;
}
