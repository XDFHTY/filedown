package com.example.filedown.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DownWx {
    /**
     * 微信助手下载记录
     */
    private Long id;

    /**
     * 
     */
    private Long userId;

    /**
     * 请求ip
     */
    private String ip;

    /**
     * 下载时间
     */
    private Date createTime;

    /**
     * 其他信息
     */
    private String msg;


}