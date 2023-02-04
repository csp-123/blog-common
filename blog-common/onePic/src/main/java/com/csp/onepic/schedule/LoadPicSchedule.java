package com.csp.onepic.schedule;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.csp.onepic.pojo.Picture;
import com.csp.onepic.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Title:
 * Description:
 * Project: blog-common
 * Author: csp
 * Create Time:2023/1/17 14:20
 */
@Component
public class LoadPicSchedule {

    @Value("${onePic.picStoragePath}")
    private String picStoragePath;


    @Autowired
    private PictureService pictureService;

    /**
     * 凌晨两点执行
     */
    @Scheduled(cron = " 0 0 2 1/1 * ? ")
    public void loadPic() {
        // 加载目录下所有图片
        File picPath = new File(picStoragePath);
        Assert.isTrue(picPath.isDirectory(), "picStoragePath不是目录");
        // 获取所有文件
        File[] files = picPath.listFiles();
        if (files == null || files.length == 0) {
            return;
        }
        Stream<File> fileStream = Stream.of(files);
        List<File> collectFiles = fileStream
                .filter(file -> {
                    try {
                        BasicFileAttributes attributes = Files.readAttributes(Paths.get(file.getAbsolutePath()), BasicFileAttributes.class);
                        long lastModifiedTime = attributes.lastModifiedTime().toMillis();
                        long oneDay = 60 * 60 * 24 * 1000;
                        return System.currentTimeMillis() - lastModifiedTime > oneDay;

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return false;
                })
                .collect(Collectors.toList());
        // 转换为picture
        List<Picture> pictures = collectFiles.stream()
                .map(Picture::convert)
                .filter(picture -> "webp".equalsIgnoreCase(picture.getPicExt()))
                .filter(picture -> {
                    // 图片不会修改，所以数据库中如果已经有了就不同步了
                    LambdaQueryWrapper<Picture> wrapper = new LambdaQueryWrapper<>();
                    wrapper.eq(Picture::getPicSourceName, picture.getPicSourceName());
                    Picture one = pictureService.getOne(wrapper);
                    return one == null;
                })
                .collect(Collectors.toList());


        pictureService.saveBatch(pictures);


    }


    public void loadPicNow() {
        // 加载目录下所有图片
        File picPath = new File(picStoragePath);
        Assert.isTrue(picPath.isDirectory(), "picStoragePath不是目录");
        // 获取所有文件
        File[] files = picPath.listFiles();
        if (files == null || files.length == 0) {
            return;
        }
        Stream<File> fileStream = Stream.of(files);
        List<File> collectFiles = fileStream
                .filter(file -> {
                    try {
                        BasicFileAttributes attributes = Files.readAttributes(Paths.get(file.getAbsolutePath()), BasicFileAttributes.class);
                        long lastModifiedTime = attributes.lastModifiedTime().toMillis();
                        long oneDay = 60 * 60 * 24 * 1000;
                        return System.currentTimeMillis() - lastModifiedTime <= oneDay;

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return false;
                })
                .collect(Collectors.toList());
        // 转换为picture
        List<Picture> pictures = collectFiles.stream()
                .map(Picture::convert)
                .filter(picture -> "webp".equalsIgnoreCase(picture.getPicExt()))
                .filter(picture -> {
                    // 图片不会修改，所以数据库中如果已经有了就不同步了
                    LambdaQueryWrapper<Picture> wrapper = new LambdaQueryWrapper<>();
                    wrapper.eq(Picture::getPicSourceName, picture.getPicSourceName());
                    Picture one = pictureService.getOne(wrapper);
                    return one == null;
                })
                .collect(Collectors.toList());


        pictureService.saveBatch(pictures);


    }
}
