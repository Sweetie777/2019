package com.bittech.test;

/**
 * Author: Sweetie77
 * Created: 2019/2/27
 */

public class SendGiftTest {

    public static void main(String[] args) {
        BoyFriendSendGift target = new BoyFriendSendGift("张三", "李四");

        CourierSendGift proxyObject = new CourierSendGift(target);

        proxyObject.send();
    }
}

//业务接口
interface SendGift {
    void send();
}

//业务类
class BoyFriendSendGift implements SendGift {

    private String boyFirendName;
    private String grilFirendName;

    public BoyFriendSendGift(String boyFirendName, String grilFirendName) {
        this.boyFirendName = boyFirendName;
        this.grilFirendName = grilFirendName;
    }

    public void send() {
        System.out.println(this.boyFirendName + "送礼物给" + this.grilFirendName);
    }
}

//代理类
class CourierSendGift implements SendGift {

    private final SendGift target;

    public CourierSendGift(SendGift target) {
        this.target = target;
    }

    public void send() {
        System.out.println("快递员打电话给客户");
        this.target.send();
        System.out.println("客户签收");
    }
}

