package jcl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Author: Sweetie77
 * Created: 2019/7/16
 */
public class CollectionTest {
    public static void main(String[] args) {
        List<String>list = new ArrayList<>();
        list.add("hello");
        list.add("bit");
        list.add("hello");
        list.add("java");

        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String str = iterator.next();
            if(str.equals("bit")){
                list.remove("bit");
            }
            System.out.println(str);
        }
    }
}
