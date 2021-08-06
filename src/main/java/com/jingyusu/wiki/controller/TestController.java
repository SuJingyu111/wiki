package com.jingyusu.wiki.controller;

import com.jingyusu.wiki.domain.Test;
import com.jingyusu.wiki.service.TestService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TestController {

    @Value("${test.hello:WARNING:MISSING CONFIG test.hello}")
    private String testHello;

    @Resource
    private TestService testService;

    @GetMapping ("/hello")
    public String hello() {
        return "hello world!" + testHello;
    }

    @PostMapping("/hello/post")
    public String helloPost(String name) {
        return "Hello World! Post，" + name;
    }

    @GetMapping ("/test/list")
    public List<Test> list() {
        return testService.list();
    }
}
