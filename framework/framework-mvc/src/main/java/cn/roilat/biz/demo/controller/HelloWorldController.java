package cn.roilat.biz.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @RequestMapping("/hello")
    @ResponseBody
    public Demo index() {
        return new Demo("hello");
    }
}
class Demo{
	private String name;

	public Demo(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Demo [name=" + name + "]";
	}
	
}
