package com.tang;

import javax.swing.*;

/**
 * Author: Sweetie77
 * Created: 2019/8/19
 */
public class Menu {
    JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8;//创建按钮
    JLabel jlb1,jlb2,jlb3;//标签
    public Menu(){
        jb1 = new JButton("查询");
        jb2 = new JButton("存款");
        jb3 = new JButton("取款");
        jb4 = new JButton("转账");
        jb5 = new JButton("改密");
        jb6 = new JButton("开户");
        jb7 = new JButton("退卡");
        jb8 = new JButton("挂失");

        jlb1 = new JLabel("77BANK");
        //设置字体类型,加粗,字号
        jlb1.setFont(new java.awt.Font("Dialog",1,23));
        jlb2 = new JLabel("欢迎您!");
        jlb2.setFont(new java.awt.Font("Dialog",1,20));
        jlb3 = new JLabel("请你选择服务");
        jlb3.setFont(new java.awt.Font("Dialog",1,22));

        jb1.addActionListener(this);   //事件监听
        jb2.addActionListener(this);
        jb3.addActionListener(this);
        jb4.addActionListener(this);
        jb5.addActionListener(this);
        jb6.addActionListener(this);
        jb7.addActionListener(this);
        jb8.addActionListener(this);


        this.setTitle("银行管理管理系统");  //设置窗体标题
        this.setSize(450, 500); 		//设置窗体大小
        this.setLocation(400, 200);		//设置位置
        this.setLayout(null);			//设置布局，不采用布局
    }
}
