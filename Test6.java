class Person{
		System.out.println(",,,");
	}
class Student extends Person{
		System.out.println("...");
	}
public class{	
	public static void main(String[] args){
		//子类对象 向上转型
		Person person = new Student();
		System.out.println(person.getPersonInfo());
		person.print();//运行结果是子类对象的print内容
		
		//父类对象  向下转型  少用CCE(class cast exception)
		//Student student  = (Student) new Person();// 编译可以通过 但是不可以运行 cce
		Student student  = (Student)person;//如果是student = person编译不通过  //强转
		
		//对象 instanceof 类名    
		Person per = new Student();        
		System.out.println(per instanceof Person);        
		System.out.println(per instanceof Student);        
		if (per instanceof Student) { //避免ClassCastException            
		Student stu = (Student) per ;            
		stu.fun();        
		}
	}
}