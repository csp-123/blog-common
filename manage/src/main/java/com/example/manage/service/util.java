package com.example.manage.service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;

/**
 * Title:
 * Description:
 * Project: manage
 * Author: csp
 * Create Time:2022/9/8 11:13
 */
public class util {


    public static void redirect(String url, String jsonParam, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");


        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println(" <HEAD><TITLE>sender</TITLE></HEAD>");
        out.println(" <BODY>");
        out.println("<form name=\"submitForm\" action=\""+url+"\" method=\"post\">");
        Iterator<String> it=params.keySet().iterator();
        while(it.hasNext()){
            String key=it.next();
            out.println("<input type=\"hidden\" name=\""+key+"\" value=\""+params.get(key)+"\"/>");
        }
        out.println("</from>");
        out.println("<script>window.document.submitForm.submit();</script>");
        out.println(" </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }
}
