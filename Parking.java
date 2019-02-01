public class Parking{
	public static void main(String[] args){
		Parking parking  = new Parking;
		
		Car bus = new Bus();
		
		System.out.println();
	}
}

class Parking{
	private static final int standardLength = 3;
	private static final int standardWidth = 2;
	public void park(Car car){
		
	}
}

interface Car{
	int length();
	int width();
}



class Bus implements Car{
	
	public int length(){
		return 9;
	}
	public int width(){
		return 4;
	}
	
	//覆写了Object类中的toString()
	

}

class Auto implements Car{
	public int length(){
		return 9;
	}
	public int width(){
		return 4;
	}
}

class Motor implements Car{
	public int length(){
		return 3;
	}
	public int width(){
		return 2;
	}

}

class Track implements Car{
	public int length(){
		return 8;
	}
	public int width(){
		return 4;
	}

}