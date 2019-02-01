public class Per{
	
	private int age;
	private String name;
	private String gender;
	private String secret;
	
	public Per(int age,String name){
		this.age = age;
		this.name = name;
	}
	public Per(int age, String name, String gender){
		this(age, name);
		this.gender = gender;
	}
	public Per(int age, String name, String gender, String secret){
		this(age, name, gender);
		this.secret = secret;
	}
	
	//setter 可以修改设置
	//getter 属性内容的取得
	public String perInfo(){
		return "这个人的年龄是"+age+",名字是"+name+",性别是"+gender;
	}
	public static void main(String[] args){
		Per per = new Per(12,"jack", "男");
		System.out.println(per.perInfo());
	}
	
	
}