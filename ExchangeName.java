package daily;

import java.util.Scanner;

/**
 * Author: Sweetie77
 * Created: 2019/7/22
 */
public class ExchangeName {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            String[]words = str.split("-");
            String result = words[0];
            for(int i = 1; i<words.length;i++){
                result += words[i].charAt(0)-'a'+'A';
                for(int j = 1; j<words[i].length();j++){
                    result += words[j];
                }
            }
            System.out.println(result);
        }
    }
}
