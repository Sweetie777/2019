package com.java6.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author: Sweetie77
 * Created: 2019/5/11
 */
@WebServlet(urlPatterns = "/hello")
public class DemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset = UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.append("<html>")
                .append("<head")
                .append("<body>")
                .append("<h1>")
                .append("hello world")
                .append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()))
                .append("</h1>")
                .append("</body>")
                .append("</head>")
                .append("</html>");
    }


}


