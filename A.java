class A{
    public int x = 0;
	public int y = 0;
	public int z = 0;
	A(int x){
		this.x = x;
	}
	A(int x, int y){
		this.x = x;
		this.y = y;
	}
	A(int x, int y, int z){
		this(x, y);
		this.z = z;
	}
	public int A(){
		return x + y + z;
	}
}

class B extends A{
	int a = 0;
	int b = 0;
	int c = 0;
	B(int x){
		super(x);
		a = x + 7;
	}
	B(int x, int y){
		super(x, y);
		a = x + 5;
		b = y + 5;
	}
	B(int x, int y, int z){
		super(x, y, z);
		a = x + 4;
		b = x + 4;
		c = x + 4;
	}
	
	public int A(){
		System.out.println("super.x+y+z="+super.A());
		return a + b + c;
	}
}

public static void main(String[] args){
		B p1 = new B(2, 3, 4);
		B p2 = new B(10, 20);
		B p3 = new B(1);
		System.out.println("a+b+c="+p1.A());
		System.out.println("a+b="+p2.A());
		System.out.println("a="+p3.A());
}