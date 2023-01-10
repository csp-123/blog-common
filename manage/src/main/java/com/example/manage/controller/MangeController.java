package com.example.manage.controller;

import com.example.manage.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Title:
 * Description:
 * Project: manage
 * Author: csp
 * Create Time:2022/9/8 09:48
 */
@RestController
@RequestMapping("/front")
public class MangeController {

    @Autowired
    private ManageService manageService;

    @GetMapping("/test")
    public void test(HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException {
        manageService.test(httpServletRequest, response);
    }

}
