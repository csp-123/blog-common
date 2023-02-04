package com.csp.onepic.controller;


import com.csp.onepic.base.Result;
import com.csp.onepic.pojo.Picture;
import com.csp.onepic.service.PictureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author baomidou
 * @since 2023-01-17
 */
@RestController
@RequestMapping("/onepic/picture")
public class PictureController {

    private final Logger logger = LoggerFactory.getLogger(PictureController.class);

    @Value("${onePic.nginxRequestPath}")
    private String nginxRequestPath;

    @Autowired
    private PictureService pictureService;

    @GetMapping("randomOne")
    public Result randomOne(Integer type, HttpServletResponse response) {

        Date start = new Date();
        logger.error("请求时间：" + start);

        Picture randomOnePicture = pictureService.randomOne(type);

        String newPath = nginxRequestPath + randomOnePicture.getPicSourceName();

        try {
            response.sendRedirect(newPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Date end = new Date();
        logger.error("响应时间：" + end);

        logger.error("耗时：" + ((end.getTime() - start.getTime())/1000) + "s");

        return Result.success();
    }


}
