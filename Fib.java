public class Fib{	
    public static void main(String[] args){
       int x = 1;
	   int y = 1;
	   int sum = 0;
	   for(int i = 0; i <= 5; i++){
		   sum = x+y;
		   x = y;
		   y = sum;
	   }
	   System.out.println(sum);
	   System.out.println(x);
	   System.out.println(y);
	   
    }
}



