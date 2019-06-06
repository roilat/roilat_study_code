package cn.roilat.biz.blog.services;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import cn.roilat.Application;
import cn.roilat.biz.blog.model.BlogArticle;
import cn.roilat.biz.blog.po.BlogArticlePO;
import cn.roilat.biz.blog.services.BlogArticleService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext
@EnableTransactionManagement
public class BlogArticleServiceTest {
    @Resource
    BlogArticleService blogArticleService;

    @Test
    public void pageList() {
        BlogArticlePO blogArticlePO = new BlogArticlePO();
        blogArticlePO.setId(8);
        System.out.println(blogArticleService.pageList(blogArticlePO));
    }

    @Test
    public void save() {
        BlogArticle blogArticle = new BlogArticle();
        blogArticle.setAttachments("");
        blogArticle.setCode("00001");
        blogArticle.setCover("http://www.baidu.com");
        blogArticle.setCreateDt(new Date());
        blogArticle.setCreator("admin");
        blogArticle.setIfComment("1");
        blogArticle.setIfPublish("1");
        blogArticle.setSource("own");
        blogArticle.setTitle("我是大哥测试标题");
        blogArticle.setUpdateDt(new Date());
        blogArticle.setUpdator("admin");
        System.out.println(blogArticleService.save(blogArticle));
    }
}
