public class SendFlower{
	public static void main(String[] args){
		Sender sender = Factory.getInstance() ;
		sender.buyFlower() ; 
	}
}

interface Sender{
	public void buyFlower();
}

class ZhangSan implements Sender{
	public void buyFlower(){
		System.out.println("买一束花.");
	}
}

class LiSi implements Sender{
	private Sender sender ; 
	public LiSi(Sender sender) {
		this.sender = sender;
	}		
	public void prepareFlower() {
	    System.out.println("1.准备好花.");
	}
	public void sendFlower(){
		System.out.println("3.送花给李四.");
	}
    public void	buyFlower(){
		this.prepareFlower();
		this.sender.buyFlower();
		this.sendFlower();
		
	}
}
class Factory{
	public static Sender getInstance(){
		return new LiSi(new LiSi());
	}
}









