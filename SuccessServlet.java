package com.tang.servlet;

import com.tang.vo.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Author: Sweetie77
 * Created: 2019/5/18
 */

@WebServlet("/successServlet")
public class SuccessServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset = utf-8");
        PrintWriter writer = resp.getWriter();

        List<UserInfo> userInfoList = (List<UserInfo>) req.getSession().getAttribute("key_userinfolist");
        writer.append("<html>")
                .append("<head><title></title></head>")
                .append("<body>")
                .append("<font color = 'red' size = '50px'>")
                .append("登陆成功, 你的用户名和密码如下 : </br>")
                .append("</font>")
                .append("<table border='1' width='50' height=\"50\">");
        for (UserInfo userInfo : userInfoList) {
            writer.append("<tr>")
                    .append("<td>username</td>")
                    .append("<td>'" + userInfo.getUsername() + "'</td>")
                    .append("</tr>")
                    .append("<tr>")
                    .append("<td>password</td>")
                    .append("<td>'" + userInfo.getPassword() + "'</td>")
                    .append("</tr>");
        }
        writer.append("</table>")
                .append("</body>")
                .append("</html>");
    }
}
