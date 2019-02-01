public class Person{
	private String name;
	private String sex;
	private long tel;
	private String post;
	private int age;
	private String adress;
	
	public Person(String name, String sex){
		this.name = name;
		this.sex = sex;
	}
	public Person(String name, String sex, long tel){
		this(name, sex);
		this.tel = tel;
	}
	public Person(String name, String sex, long tel, String post){
		this(name, sex, tel);
		this.post = post;
	}
	public Person(String name, String sex, long tel, String post, int age){
		this(name, sex, tel, post);
		this.age = age;
	}
	public Person(String name, String sex, long tel, String post, int age, String adress){
		this(name, sex, tel, post, age);
		this.adress = adress;
	}
	
	public String personInfo(){
		return "Name:"+name+"\tPost:"+post+"\n"+"Sex:"+sex+"Age:"+age+"\n"+"tel:"+tel+"adress"+adress;
	}
	
    public static void main(String[] args){
		Person person = new Person("Mary", "HD Director", "Female", 26, 180, "DaTun road no.6,chaoyang,beijing");
		System.out.println(person.personInfo());
	}
}
	