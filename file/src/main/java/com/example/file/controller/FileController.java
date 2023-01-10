package com.example.file.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Title:
 * Description:
 * Project: file
 * Author: csp
 * Create Time:2022/9/8 10:02
 */
@RestController
@RequestMapping("/front")
public class FileController {

    @PostMapping("/testFile")
    public void test(String a, HttpServletResponse response) {
        try {

            String downLoadFileName = "file_" + System.currentTimeMillis() + ".zip";
            response.reset();
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(downLoadFileName, "UTF-8"));

            ServletOutputStream outputStream = response.getOutputStream();

            ZipOutputStream zos = new ZipOutputStream(outputStream);
            String path = "D:\\钉钉下载文件\\检索标注文档(1).txt";

            InputStream input = new FileInputStream(path);

            String zipFileName = "aaaaa" + path.substring(path.lastIndexOf("."));

            zos.putNextEntry(new ZipEntry(zipFileName));
            byte[] b = new byte[1024];

            int len;
            while ((len = input.read(b)) != -1) {
                zos.write(b, 0, len);
            }

            zos.flush();
            zos.closeEntry();

            input.close();
            zos.finish();
            zos.close();

            outputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
