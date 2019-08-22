package JDBC;

import java.sql.*;

/**
 * Author: Sweetie77
 * Created: 2019/8/22
 */
public class testJDBC {
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    try{
        /**
         * 加载驱动有两种方式
         * 1. 会导致驱动会注册两次,过度依赖mysql的api,脱离mysql的开发包,程序将无法编译
         * 2. 驱动只会加载一次,不需要依赖具体的驱动,灵活性高
         */
        //1.
        // DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //2.
        Class.forName("com.mysql.jdbc.Driver");
        //获取与数据库连接的对象Connection
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/xxx", "root", "root");
        //获取执行sql语句的statement对象
        statement = connection.createStatement();
        //执行sql语句,拿到结果集
        resultSet = statement.executeQuery("SELECT * FROM user");
        //遍历结果集,得到数据
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1));
            System.out.println(resultSet.getString(2));
        }
    }catch(SQLException e){
        e.printStackTrace();
    }catch(ClassNotFoundException e){
        e.printStackTrace();
    }finally{
        //关闭资源,后调的先关闭
        //关闭之前,要先判断对象是否存在
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
