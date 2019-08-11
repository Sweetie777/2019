package com.tang;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Sweetie77
 * Created: 2019/8/2
 */


/**
 * 专门做协议处理
 * read读取信息
 * process  processSimpleString
 * <p>
 * ProtocolInputStream是FilterInputStream的子类
 */
public class Protocol {
    private static String processSimpleString(ProtocolInputStream is) throws IOException {
        return is.readLine();
    }

    private static String processError(ProtocolInputStream is) throws IOException {
        return is.readLine();
    }

    private static long processInteger(ProtocolInputStream is) throws IOException {
        return is.readInteger();
    }

    private static byte[] processBulking(ProtocolInputStream is) throws IOException {
        int len = (int) is.readInteger();
        if (len == -1) {
            return null;
        }
        byte[] r = new byte[len];
        is.read(r,0,len);

//        for (int i = 0; i < len; i++) {
//            int b = is.read();
//            r[i] = (byte) b;
//        }

        //"$5\r\nhello\r\n"
        is.read();
        is.read();
        return r;
    }

    private static List<Object> processArray(ProtocolInputStream is) throws IOException {
        int len = (int) is.readInteger();
        if (len == -1) {
            return null;
        }
        List<Object> list = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            try {
                list.add(process(is));
            } catch (RemoteException e) {
                list.add(e);
            }
        }
        return list;
    }


    private static Object read(ProtocolInputStream is)throws IOException{
        return process(is);
    }

    private static Object process(ProtocolInputStream is) throws IOException {
        int b = is.read();
        if(b == -1){
            throw new RuntimeException("不应当读到结尾");
        }

        switch (b)
        {
            case '+':
                return processSimpleString(is);
            case '-':
                throw new RemoteException(processError(is));
            case ':':
                return processInteger(is);
            case '$':
                return processBulking(is);
            case '*':
                return processArray(is);
            default:
                throw new RuntimeException("不识别的类型");
        }
    }

    private
}

