package com.yuw.control;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldControl {

    /*
    * rest的ajax的请求处理
    * */
    @RequestMapping("/sayHello")
    public String sayHello() {
        return "HelloWorld!!!";
    }
}
