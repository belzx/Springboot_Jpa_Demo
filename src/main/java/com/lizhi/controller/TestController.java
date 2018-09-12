package com.lizhi.controller;

import com.lizhi.bean.Email;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 测试controller
 */
@Controller
public class TestController {

    @Resource
    private Email email;

    @Value("${book.name}") //配置文件
    private String bookName;

    /**
     * @RequestMapping produces ： 指定处理请求的提交内容类型（Content-Type），例如application/json, text/html;
     * @return          method  ： 方法
     */
    @RequestMapping("/a")
    @ResponseBody
    public String action1() {
        return email.getName()+email.getPrice();
    }

    @RequestMapping("/")
    public String action2(Model model) {
        model.addAttribute("email",email);
        //其引入的地址已经由springboot框架自动默认引入在templates 下
        //ThymeleafProperties
        //必须pom引入
        return "index";
    }

}
