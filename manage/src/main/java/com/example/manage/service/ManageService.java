package com.example.manage.service;


import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Title:
 * Description:
 * Project: manage
 * Author: csp
 * Create Time:2022/9/8 09:50
 */
@Service
public class ManageService {

    public void test(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String url = "http://localhost:8081/front/testFile";

        List<TestDTO> list = new ArrayList<>();
        list.add(new TestDTO(1, "aa"));

        util.redirect(url, JSON.toJSONString(list), response);


        //response.setStatus(HttpServletResponse.SC_TEMPORARY_REDIRECT);
        //response.setHeader("Location", url);
        //try {
        //    response.sendRedirect(url);
        //} catch (IOException e) {
        //    e.printStackTrace();
        //}

        //RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);

        //requestDispatcher.forward();
        //
        //try {
        //    requestDispatcher.forward(request, response);
        //} catch (ServletException e) {
        //    System.out.println("请求异常");
        //} catch (IOException e) {
        //    e.printStackTrace();
        //}

        //HttpRequest.post(url)
        //        .form("response", response)
        //        .execute()
        //        .body();
    }


}
