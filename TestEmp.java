package com.bittech.reflect.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: secondriver
 * Created: 2019/1/17
 * Description: 比特科技，只为更好的你；你只管学习，其它交给我。
 */
public class TestEmp {
    
    public static void main(String[] args) {
        
        //1.指定格式的字符串：
        /**
         * value =  emp.ename:Jack|emp.job:测试工程师
         */
        
        //ObjectUtil
        //2. setXxx ,  getXxx
        //2.1 setXxx   object , Xxx, Value
        //2.2 getXxx   object , Xxx
        
        Emp emp = new Emp();
        String content = "emp.ename:Jack|emp.job:测试工程师|emp.age:34";
        ObjectUtil objectUtil = new ObjectUtil();
        Map<String, Object> map = objectUtil.parseAttributeAndValue(content);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            objectUtil.setObjectValue(emp, entry.getKey(), entry.getValue());
        }
        System.out.println(emp);
        
    }
    
}


class ObjectUtil {
    
    public Map<String, Object> parseAttributeAndValue(String content) {
        Map<String, Object> attributeAndValueMap = new HashMap<>();
        if (content != null || content.length() > 0) {
            //value =  emp.ename:Jack|emp.job:测试工程师
            //emp.ename:Jack
            //emp.job:测试工程师
            String[] pairs = content.split("\\|");
            for (String p : pairs) {
                //emp.ename:Jack
                String[] attributeValue = p.split(":");
                String attributeTemp = attributeValue[0];
                int index = attributeTemp.lastIndexOf(".");
                if (index == -1) {
                } else {
                    String attribute = attributeTemp.substring(index + 1);
                    attribute =
                            attribute.substring(0, 1)
                                    .toUpperCase()
                                    +
                                    (attribute.length() == 1 ? "" : attribute.substring(1));
                    String value = attributeValue[1];
                    attributeAndValueMap.put(attribute, value);
                }
            }
            
        }
        return attributeAndValueMap;
    }
    
    public void setObjectValue(Object object, String attribute, Object value) {
        Class classes = object.getClass();
        try {
            Method[] methods = classes.getMethods();
            Method method = null;
            for (Method m : methods) {
                if (m.getName().equals("set" + attribute)) {
                    method = m;
                }
            }
            //单独处理Integer
            Parameter parameter = method.getParameters()[0];
            if (parameter.getType() == Integer.class) {
                method.invoke(object, Integer.parseInt(String.valueOf(value)));
                
            } else {
                method.invoke(object, value);
            }
            
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    
    public Object getObjectValue(Object object, String attribute) {
        Class classes = object.getClass();
        try {
            //获取getXxx
            Method method = classes.getMethod("get" + attribute);
            //调用getXxx
            return method.invoke(object);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}