package cn.roilat.study.java.collection.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestComparator {

    public static void main(String[] args) {
        List<User> list = new ArrayList<User>();
        list.add(new User("name3"));
        list.add(new User("name1"));
        list.add(new User("name2"));
        List<User> list2 = new ArrayList<User>(list);
        Collections.sort(list);
        list2.sort(new UserComparator());
        System.out.println(list);
        System.out.println(list2);
    }

}

class UserComparator implements Comparator<User> {

    @Override
    public int compare(User user1, User user2) {
        return user1.getName().compareTo(user2.getName());
    }
}

class User implements Comparable<User> {
    private String name;

    public User(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(User o) {
        return this.name.compareTo(o.getName());
    }

}