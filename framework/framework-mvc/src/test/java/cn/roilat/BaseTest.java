package cn.roilat;

import java.util.Map;

import org.junit.runner.RunWith;

import cn.roilat.Application;
import cn.roilat.framework.common.result.CommonPageResult;
import cn.roilat.framework.common.result.CommonResult;
import cn.roilat.framework.util.URLHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试基类
 * 
 * @author roilat-J
 * @version $Id: BaseTest.java, v 0.1 2019年3月11日 下午5:02:01 roilat-J Exp $
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class BaseTest {
    protected Logger           logger      = LoggerFactory.getLogger("Junit-Test-Logger");
    @Autowired
    protected TestRestTemplate restTemplate;
    private HttpHeaders        httpHeaders = new HttpHeaders();
    {
        httpHeaders.add("content-type", "application/json;charset=UTF-8");
    }
    protected <T> CommonResult<?> doPost(String url, T requestBody) {
        HttpEntity<T> requestEntity = new HttpEntity<T>(requestBody, httpHeaders);
        return restTemplate.exchange(url, HttpMethod.POST, requestEntity, CommonResult.class)
            .getBody();
    }

    protected CommonResult<?> doGet(String url, Map<String, String> params) {
        return restTemplate.getForEntity(URLHelper.appendUrlParams(url, params), CommonResult.class)
            .getBody();
    }

    protected CommonPageResult<?> doGetPage(String url, Map<String, String> params) {
        return restTemplate
            .getForEntity(URLHelper.appendUrlParams(url, params), CommonPageResult.class).getBody();
    }

    protected <T> CommonResult<?> doPut(String url, T requestBody) {
        HttpEntity<T> requestEntity = new HttpEntity<T>(requestBody, httpHeaders);
        return restTemplate.exchange(url, HttpMethod.PUT, requestEntity, CommonResult.class)
            .getBody();
    }

    protected <T> CommonResult<?> doDelete(String url, T requestBody) {
        HttpEntity<T> requestEntity = new HttpEntity<T>(requestBody);
        return restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, CommonResult.class)
            .getBody();
    }
}
