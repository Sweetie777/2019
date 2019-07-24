package daily;

import java.util.Scanner;

/**
 * Author: Sweetie77
 * Created: 2019/7/23
 */
public class DateToDay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int year = sc.nextInt();
            int month = sc.nextInt();
            int day = sc.nextInt();
            int days = outDay(year, month, day);
            System.out.println(days);
        }
        sc.close();
    }
    private static int outDay(int year, int month, int day){
        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
        if(year<=0 || month <=0||month>12||day<0||day>days[month-1])
            return -1;
        if( year % 4==0 && year %100!=0 ||year %400 == 0)
            days[1] = 29;
        int sum = 0;
        for(int i = 0;i<month-1;i++){
            sum+=days[i];
        }
        return sum+day;
    }
}
