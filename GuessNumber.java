import java.util.Random;
import java.util.Scanner;

public class GuessNumber{
	public static void main(String[] args){
		Random random = new Random();
		int number = random.nextInt(100);//[0,100)
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入数字");
		
		while(true){
			int data = scanner.nextInt();
			if(data > number){
				System.out.println("大了,请继续输入!");
			}else if(data < number){
				System.out.println("小了,请继续输入!");
			}else{
				System.out.println("恭喜你,猜对了!");
			}
		}
	}
}