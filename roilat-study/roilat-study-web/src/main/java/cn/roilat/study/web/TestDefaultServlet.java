package cn.roilat.study.web;

import org.apache.catalina.servlets.DefaultServlet;

public class TestDefaultServlet {

    public static void main(String[] args) {
        DefaultServlet ds = new DefaultServlet();
        ds.getServletContext();
    }

}
