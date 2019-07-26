package daily;

import java.util.Scanner;

/**
 * Author: Sweetie77
 * Created: 2019/7/22
 */
public class StudentAmI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String string = sc.nextLine();
        String []str = string.split(" ");
        for (int i = str.length-1; i >= 1; i--) {
            System.out.print(str[i]+" ");
        }

        System.out.println(str[0]);
    }
}
