package com.bittech.reflect.example;

/**
 * Author: secondriver
 * Created: 2019/1/17
 * Description: 比特科技，只为更好的你；你只管学习，其它交给我。
 */
public class Emp {
    
    private String ename;
    private String job;
    private Integer age;
    
    public String getEname() {
        return ename;
    }
    
    public void setEname(String ename) {
        this.ename = ename;
    }
    
    public String getJob() {
        return job;
    }
    
    public void setJob(String job) {
        this.job = job;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    
    @Override
    public String toString() {
        return "Emp{" +
                "ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", age=" + age +
                '}';
    }
}
