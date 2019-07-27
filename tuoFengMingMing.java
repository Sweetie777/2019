package daily;

import java.util.Scanner;

/**
 * Author: Sweetie77
 * Created: 2019/7/27
 */
public class tuoFengMingMing {
    // 思路很简单.
    // 首先一个字符一个字符的读取内容
    // 1. 遇到 _ 就直接跳过
    // 2. 如果上一个字符是 _ 则下一个字符转为大写字母

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            // 先将字符串按 _ 切分
            String[] words = str.split("_");
            String result = words[0];
            for (int i = 1; i < words.length; i++) {
                // 将首字母转为大写即可.
                result += (char) (words[i].charAt(0) - 'a' + 'A');
                for (int j = 1; j < words[i].length(); j++) {
                    result += words[i].charAt(j);
                }
            }
            System.out.println(result);
        }
    }
}
