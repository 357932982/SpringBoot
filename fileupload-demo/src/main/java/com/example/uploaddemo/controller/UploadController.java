package com.example.uploaddemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * MultipartFile是Spring上传文件的封装类，包含了文件的二进制流和文件属性等信息，在配置文件中也可对相关属性进行配置，
 * 基本的配置信息如下：
 *
 * spring.http.multipart.enabled=true #默认支持文件上传.
 * spring.http.multipart.file-size-threshold=0 #支持文件写入磁盘.
 * spring.http.multipart.location=# 上传文件的临时目录
 * spring.http.multipart.max-file-size=1Mb # 最大支持文件大小
 * spring.http.multipart.max-request-size=10Mb # 最大支持请求大小
 */

@Controller
public class UploadController {

    private  final static String UPLOADED_FOLDER = "E://temp//";

    @GetMapping("/")
    public String index(){
        return "upload";
    }

    @PostMapping("/upload")
    public String singleFileupload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes){
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }

        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/uploadStatus";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "status";
    }

}


