import java.util.Array
public class TestObject{
	
	//object能接受java所以类型的对象(类 接口 数组)
	/*Object obj1 = new int[]{1, 2, 3, 4}
    int[]
	
	//增强的for循环
	for(int value : int Array){
		System.out.println(value + " , ");
	}
	//obj接受接口类型
	//向上转型
	Object obj2 = new IMessage(){
		//匿名内部类
		public value print(){
			System.out.println("java is best");
		}
	};
	//向下转型
	IMessage imessage = (IMessage)obj2;
	imessage.print();
	
	Object obj3 = 10;//ok ok  基本数据类型
	//如何转型到引用类型 包装类型的内容
	System.out.println(obj3);
	
	*/
	public static void code6(){
		String str1 = "123";
		//默认是十进制
		int int1 = Integer.parseInt(str1);
		//radix: 当前转换的字符标识的数组的进制
		int int2 = Integer.parseInt(str1,16);
		//java数字标识的进制默认十进制
		System.out.println(int1);
		System.out.println(int2);
		
		String str2 = "123.41";
		double double1 = Double.parseDouble(str2);
		System.out.println(double1);
		
		//boolean 只要是true 就返回true 忽略大小写  其他的都是返回false
		
		
		//基本数据类型转字符串 String
		String intStr = String.valueOf(1);
		String doubleStr = String.valueOf(123.41);
		String booleanStr = String.valueOf(true);//false
		System.out.println(intStr);
		System.out.println(doubleStr);
		System.out.println(booleanStr);
		
		//JDK7
		int a = 100_000;
		int b = 0b0110;//二进制6
	}
    
	public static void swap(int a, final char[]ch){
		a = 10;
		char[] chars = ch;//复制一号对象
		chars[0] = 'A';
		//ch = new char[]{'C','D'};//改的不是一号对象,只是赋了一个新的值
	}
	
	public static void main(String[] args){
		int a = 20;
		char[] ch chars = new[]{'a', 'b'};//一号
		swap(a,ch);
		 
		System.out.println(a);//20
		System.out.println(java.util.Arrays.toString(ch));//A,b
		
		//java语言中参数传递:值传递(栈空间内容,栈空间放的是什么,最后出来的就是什么)
		//基本数据类型 ->栈空间 -> 值
		//引用数据类型变量 -> 栈空间 -> 引用的对象所在的堆空间的地址
	}
}

