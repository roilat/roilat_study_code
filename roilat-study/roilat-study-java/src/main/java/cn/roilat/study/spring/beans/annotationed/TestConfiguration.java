package cn.roilat.study.spring.beans.annotationed;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class TestConfiguration {
    public static void main(String[] args) throws ClassNotFoundException {
        System.setProperty("spring.profiles.active", "dev");
        @SuppressWarnings("resource")
        ApplicationContext context = new AnnotationConfigApplicationContext(
            TestConfiguration.class);
        System.out.println(Arrays.asList(context.getBeanNamesForType(String.class)));
        System.out.println(Arrays.asList(context.getBeanNamesForType(User.class)));
        User user = (User) context.getBean("myUser");
        System.out.println(user.getName());
    }

    @Bean()
    @Profile("test")
    public String str1() {
        return "str1";
    }

    @Bean
    @Profile("dev")
    public String str2() {
        return "str2";
    }

    @Bean
    public String str3() {
        return "str3";
    }

    @Bean(name = "myUser", initMethod = "init")
    @Profile("test")
    public User getUser() {
        return new User("roilat");
    }
}

class User {
    private String name = "default";

    public void init() {
        System.out.println("init method");
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}