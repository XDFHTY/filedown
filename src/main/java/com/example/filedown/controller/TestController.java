package com.example.filedown.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class TestController {


    @RequestMapping("/test2")
    @ResponseBody
    public String testHttps(String str){

        log.info("str=={}",str);
        return "请求成功！！";
    }
}
