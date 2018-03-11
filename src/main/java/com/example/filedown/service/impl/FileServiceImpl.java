package com.example.filedown.service.impl;

import com.example.filedown.entity.DownWx;
import com.example.filedown.mapper.DownWxMapper;
import com.example.filedown.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@Service
public class FileServiceImpl implements FileService {

    @Value("${web.upload-path}")
    private String path;


    @Autowired
    private DownWxMapper downWxMapper;


    @Override
    public int addDownWX(DownWx downWx) {
        return downWxMapper.insertSelective(downWx);
    }


    /**
     * 文件下载
     * @param request
     * @param response
     * @throws IOException
     */
    public void downLoad(HttpServletRequest request, HttpServletResponse response, String name) throws IOException{
        String fileName = name;

//        String transcoding = new String(fileName.getBytes("iso8859-1"), "utf-8");
        String transcoding = fileName;
        String downloadName = URLEncoder.encode(transcoding, "UTF-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/x-msdownload");
        response.setHeader("Content-Disposition", "attachment;fileName=" + downloadName);

        InputStream is = null;
        OutputStream os = null;
        try {
//            String path = request.getServletContext().getContextPath();
            is = new FileInputStream(new File(path+transcoding));
            os = response.getOutputStream();
            byte[] b = new byte[2048];
            int length;
            while ((length = is.read(b)) > 0) {
                os.write(b, 0, length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            os.close();
            is.close();
        }
    }

}
