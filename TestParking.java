public class TestParking{
    
    public static void main(String[] args){
        Parking parking = new Parking(9,4);
        /*
        Car bus = new Bus();
        Car truck = new Truck();
        Car auto = new Auto();
        Car motor = new Motor();
        
        parking.park(bus);
        parking.park(truck);
        parking.park(auto);
        parking.park(motor);
         */
         //对象数组
         Car[] cars  = new Car[]{
             new Bus(), new Truck(), new Auto(), new Motor()
         };
         for(int i=0; i<cars.length; i++){
             parking.park(cars[i]);
         }
        
    }
}

class Parking{
    
    private  int standardLength = 3;
    private  int standardWidth = 2;
    
    public Parking(){
        
    }
    
    public Parking(int length, int width){
        this.standardLength = length;
        this.standardWidth = width;
    }
    
    
    public void park(Car car){
        if(car.length() <=standardLength && car.width() <=standardWidth){
            System.out.println("这个车可以停:"+car);
        }else{
            System.out.println("这个车不可以停:"+car);
        }
        
    }
}

interface Car{
    
    //车的长度 单位m
    int length();
    //车的宽度
    int width();
}

class Truck implements Car{
     public int length(){
         return 8;
     }
     public int width(){
         return 4;
     }
     
     //覆写了Object类中toString(); Java所有类继承Object类
     public String toString(){
         return "Truck width="+this.width()+" length="+this.length();
     }
}

class Bus implements Car {
     public int length(){
         return 9;
     }
     public int width(){
         return 4;
     }
      public String toString(){
         return "Bus width="+this.width()+" length="+this.length();
     }
}

class Auto implements Car{
     
     private static final int MAX_LENGTH = 3;
     private static final int MAX_WIDTH=3;
    
     private int length  =3;
     private int width = 2;
     
     public Auto(){
         
     }
    
     public Auto(int length, int width){
         if(length > MAX_LENGTH || width > MAX_WIDTH){
             //以后的内容，很重要
             throw new IllegalArgumentException("参数不合法");
         }
         this.length = length;
         this.width = width;
     }
    
     public int length(){
         return this.length;
     }
     public int width(){
         return this.width;
     }
      public String toString(){
         return "Auto width="+this.width()+" length="+this.length();
     }
}

class Motor implements Car{
     public int length(){
         return 2;
     }
     public int width(){
         return 1;
     }
       public String toString(){
         return "Motor width="+this.width()+" length="+this.length();
     }
}


