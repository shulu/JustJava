package com.restful.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class FileUploadController {

    @PostMapping("/upload")
    public String upload(@RequestParam("uploadFile") MultipartFile uploadFile, HttpServletRequest request) {
        // TODO: process POST request
        if (uploadFile == null || uploadFile.isEmpty()) {
            return "NULL FILE";
        }
        String realPath = request.getServletContext().getRealPath("/uploadFile");
        System.out.println("realPath:" + realPath);
        File parentDir = new File(realPath);
        if (!parentDir.isDirectory()) {
            parentDir.mkdir();
        }
        String filename = uploadFile.getOriginalFilename();
        File target = new File(parentDir, filename);
        try {
            uploadFile.transferTo(target);
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return "SUCCESS";
    }

}
