package com.alex.helloworld.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * @author alex
 * @version 1.0
 * @description: TODO
 * @date 2023/2/4 17:03
 */
@RestController
public class FileController {
    private static final String UPLOAD_FOLDER = System.getProperty("user.dir")+"/upload/";

    // 前端请求参数要为form-data,
    @PostMapping("/upload")
    public String upload(String nickname, MultipartFile f, HttpServletRequest request) throws IOException{
        // 获取文件大小
        System.out.println("文件大小："+f.getSize());
        // 获取文件类型
        System.out.println(f.getContentType());
        // 获取图片原始名称
        System.out.println(f.getOriginalFilename());
        System.out.println(System.getProperty("user.dir"));
        // 下面在调试的时候没有固定路径；tomcat运行的路径
        String path = request.getServletContext().getRealPath("/upload/");
        System.out.println("tomcat运行路径:"+path);
        saveFile(path,f);
        return "上传成功";
    }

    private void saveFile(String path,MultipartFile f) throws IOException {
        File upDir = new File(path);
        if(!upDir.exists()){
            upDir.mkdirs();
        }
        File file = new File(path+f.getOriginalFilename());
        f.transferTo(file);
    }
}
