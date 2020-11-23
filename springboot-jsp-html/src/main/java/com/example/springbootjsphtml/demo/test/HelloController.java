package com.example.springbootjsphtml.demo.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Classname HelloController
 * @Description TODO
 * @Date 2020/9/22 20:48
 * @Created by nihongyu
 */
@Controller
public class HelloController {

    @RequestMapping("jsp")
    public String helloJsp(){
        System.out.println("hello=jsp");
        return "/hello.jsp";
    }


    @RequestMapping("html")
    public String helloHtml(){
        System.out.println("hello=html");
        return "dataSource.html";
    }

}
