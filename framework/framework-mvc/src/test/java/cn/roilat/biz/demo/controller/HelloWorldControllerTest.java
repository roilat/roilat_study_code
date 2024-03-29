package cn.roilat.biz.demo.controller;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import cn.roilat.Application;
import cn.roilat.biz.demo.controller.HelloWorldController;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles("test")
public class HelloWorldControllerTest {
    private MockMvc mvc;
    @Resource
    private HelloWorldController helloWorldController;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(helloWorldController).build();
    }

    @Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print())
            .andReturn();
    }
}