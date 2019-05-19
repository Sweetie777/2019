package com.tang.service;

import com.tang.db.DbManager;
import com.tang.vo.UserInfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Sweetie77
 * Created: 2019/5/18
 */
public class QueryService {
    private Connection conn = null;
    private ResultSet rs = null;

    public List<UserInfo> queryDb(UserInfo userInfo){
        String db_username;
        String db_password;
        List<UserInfo> userInfoList = new ArrayList<>();
        String strSql = "select * from t_userinfo where username="+
                "'"+userInfo.getUsername() + "'and password='" +userInfo.getUsername() + "'";
        try{
            DbManager db = new DbManager();
            conn = db.getConn();
            rs = db.queryExecuteFun(strSql);
            while(rs.next()){
                db_username = rs.getString("username");
                db_password = rs.getString("password");
                if(userInfo.getUsername().equals(db_username) && userInfo.getPassword().equals(db_password)){
                    userInfoList.add(userInfo);
                    return userInfoList;
                }else{
                    return null;
                }


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
