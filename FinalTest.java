public class FinalTest{
	//关键字final
	//1.被final修饰的关键字不能被继承,final修饰的方法不能被覆写
	//2.final能修饰类 方法 属性 变量 参数
	//3.final修饰的属性 在构造方法中初始化,或者直接初始化
	//4.final修饰的属性,变量, 其他引用,  一旦初始化之后就不能再赋值
	//5.final定义常量: static final <DateType> A_B
	
	public static void main(String[] args){
		A a = new A("jack");
		
	}
	
	class A{
		private final String name;
		public A(String name){
			this.name = name;
		}
	}
}


class Person{
	public void print(){
	    System.out.printsln("这是person的print");
	}
}
class Student extends Person{
	void print(){
		System.out.println("这是student的print");
	}
}