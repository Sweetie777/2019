package JDBC;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Author: Sweetie77
 * Created: 2019/8/22
 */
public class connection {
    public Connection getConnection()throws SQLException{
        if(list.size() > 0){
            final Connection connection = list.removeFirst();
            //查看池的大小
            System.out.println(list.size());
            //返回一个动态代理对象
            return (Connection)Proxy.newProxyInstance(Demo1.class.getClassLoader(), connection.getClass().getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    if(!method.getName().equals("close")){
                        method.invoke(connection,args);
                    }else{
                        //进到这里,说明调用的时close方法
                        list.add(connection);
                        //再看看池的大小
                        System.out.println(list.size());
                    }
                    return null;
                }
            });
        }
        return null;
    }
}
