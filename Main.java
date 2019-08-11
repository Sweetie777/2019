package com.tang;


import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

/**
 * Author: Sweetie77
 * Created: 2019/8/2
 */


/**
 * 1.因为有很多代码是相同的
 * 为了提升代码复用率
 * 专门增加了一层 ProtocolInputStream
 * readLine 和readInteger放进去
 *
 * 2.Error Integer Bulking Array
 * 3.把异常独立出来, 方便array处理
 */
public class Main {
    public static void main(String[] args) {
        String message = "+ok\r\n";

        ByteInputStream is = new ByteInputStream(message.getBytes(),message.getBytes().length);
        Object o = new ProtocolInputStream(is);
        System.out.println(o);

    }
}
