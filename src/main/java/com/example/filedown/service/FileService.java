package com.example.filedown.service;

import com.example.filedown.entity.DownWx;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface FileService {

    //添加微信助手下载记录
    public int addDownWX(DownWx downWx);


    //文件下载
    public void downLoad(HttpServletRequest request, HttpServletResponse response, String name) throws IOException;
}
