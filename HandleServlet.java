package com.tang.servlet;

import com.tang.service.QueryService;
import com.tang.vo.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Author: Sweetie77
 * Created: 2019/5/18
 */

@WebServlet("/handlerServlet")
public class HandleServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 获取用户请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(username);
        userInfo.setPassword(password);

        QueryService queryService = new QueryService();
        List<UserInfo> userInfoList = queryService.queryDb(userInfo);
        if(userInfoList != null){
            req.getSession().setAttribute("key_userinfolist",userInfoList);
            req.getRequestDispatcher("successServlet").forward(req,resp);
        }else{
            req.getRequestDispatcher("failureServlet").forward(req,resp);
        }
    }
}
