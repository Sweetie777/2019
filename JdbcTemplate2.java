package com.bittech;

/**
 * Author: Sweetie77
 * Created: 2019/3/28
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JdbcTemplate2 {

    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    //1.加载驱动程序
    public void loadDriverClass() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //2.连接
    public void createConnection() {
        String url = "jdbc:mysql://127.0.0.1:3306/memo";
        try {
            connection = DriverManager.getConnection(url, "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //3.创建命令
    public void createStatement() {
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //6.关闭资源
    public void closeResource() {
        //结果 -> 命令 -> 连接
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public final <T, R> R execute(String sql, Handler<T, R> handler) {
        this.loadDriverClass();
        this.createConnection();
        this.createStatement();
        try {
            if (sql.trim().startsWith("select") || sql.trim().startsWith("SELECT")) {
                resultSet = this.statement.executeQuery(sql);
                return handler.handler((T) resultSet);
            } else {
                Integer effect = this.statement.executeUpdate(sql);
                return handler.handler((T) effect);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeResource();
        }
        return null;
    }
}

interface Handler<T, R> {

    R handler(T t);
}

