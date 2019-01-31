import java.util.Random;
import java.util.Scanner;
public class GuessNumber2{

    private final int value; 
    
    public GuessNumber2(){
        Random random = new Random();
        this.value =  random.nextInt(100);
    }
  
    public void play(){
        System.out.println("欢迎进入猜数字游戏");
        int count =0;
        Scanner scanner = new Scanner(System.in);
        while(true){
            count ++;
            System.out.println("请输入您猜的数字：");
            int guessNumber = scanner.nextInt();
            if(guessNumber > this.value){
                System.out.println("您猜的数字太大了");
            }else if(guessNumber < this.value){
                System.out.println("您猜的数字太小了");
            }else{
               System.out.println("恭喜猜中了"); 
               break;
            }
        }
        System.out.println("您一共猜了"+count +"次");
    }

    
    public static void main(String[] args){
        
        GuessNumber2 guessNumber = new GuessNumber2();
        guessNumber.play();
        
    }
}