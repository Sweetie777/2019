public class CodeBlock{
	private int codeline;
	private int salary;
	private String codeFileName;
	
	static{
		System.out.println("静态块, 类");
	}
	
	
	
	{
		//暗示  它的执行在构造方法 CodeBlock之前
		System.out.println("构造块,非静态块");
		codeline = 10;
		//从这里进行初始化
		salary = codeline * 2;
	}
	
	public CodeBlock(){
		//在这里进行初始化
		System.out.println("构造方法执行");
		
	}
	
	public static void main(String[] args){

	
	}
	
}