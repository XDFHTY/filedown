package com.example.filedown.controller;

import com.example.filedown.entity.DownWx;
import com.example.filedown.service.FileService;
import com.example.filedown.utils.CookieTool;
import com.example.filedown.utils.FileDown;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

import static com.example.filedown.utils.FileDown.getIpAddr;

@Controller
public class WXQFController {

    @Autowired
    private FileService fileService;



    @RequestMapping("/")
    public String toYx(HttpServletRequest request,HttpServletResponse response){
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

        CookieTool.addCookie(response,"basePath",basePath,30*60);

        return "redirect:/index.html";
    }

    //文件下载
    @RequestMapping("/wxqfzs")
    public void download(HttpServletRequest request, HttpServletResponse response) throws IOException {
        DownWx downWx = new DownWx();
        downWx.setIp(getIpAddr(request));
        downWx.setCreateTime(new Date());

        fileService.addDownWX(downWx);

       fileService.downLoad(request,response,"WechatHelper.exe");

    }

}
