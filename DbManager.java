package com.tang.db;

import java.sql.*;

/**
 * Author: Sweetie77
 * Created: 2019/5/18
 */
public class DbManager {
    public String driver = "com.mysql.jdbc.Driver";
    public String username = "root";
    public String password = "root";
    public String url = "jdbc:mysql://127.0.0.1:3307/serverletdb";

    public Connection conn = null;
    public Statement state = null;
    public ResultSet rs = null;

    public DbManager() {
    }

    public Connection getConn() {
        try {
            Class.forName(driver);
            try {
                conn = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public ResultSet queryExecuteFun(String strSql) {
        try {
            state = conn.createStatement();
            rs = state.executeQuery(strSql);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public void closeDb() {
        try {
            if (rs != null) rs.close();
            if (state != null) rs.close();
            if (conn != null) rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
