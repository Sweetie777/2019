import java.util.Scanner;
public class DesignPattern{
    
    
    //普通方式
    public static void code1(){
        Client client = new Client();
        
        //我买的计算机，需要在客户端明确指定
        //高内聚，低耦合
        client.buy(new MacbookProComputer());
        client.buy(new AlienwareComputer());
    }

    public static void code2(){
         Client client  = new Client();
         //客户端不需要知道计算机接口的具体实现类，指定类型名称（编号）
         client.buy(SimpleComputerFactory.getInstance("mac"));
         //client.buy(SimpleComputerFactory.getInstance("mi"));//null 
    }
    
    
    public static void code3(){
         Client client = new Client();
         //1.通过参数
         //java DesignPattern mac 
         /*
         if(args.length > 0){
             String type = args[0];
             Computer computer =SimpleComputerFactory.getInstance(type);
             if(computer == null){
                 System.out.println("输入的类型："+type+" 不支持");
             }else{
                 client.buy(computer);
             }
         }else{
             System.out.println("请输入计算机类型：mac , surface, alienware");
         }
         */

         
         //2.通过读取客户端用户输入数据（控制台）
         Scanner scanner = new Scanner(System.in);
         while(true){
             System.out.println("请输入计算机类型：mac , surface, alienware, 输入q 退出");
             String type = scanner.nextLine();
             if(type.equals("q")){
                 break;
             }
             Computer computer = SimpleComputerFactory.getInstance(type);
             if(computer == null){
                  System.out.println("输入的类型："+type+" 不支持");
             }else{
                  client.buy(computer);
             }
         }
    }
    
    public static void code4(){
          Client client = new Client();
         //客户端此时与工程类耦合
         ComputerFactory computerFactory  = new MacbookProComputerFactory();
         Computer computer = computerFactory.createComputer();
         //new MacbookProComputer 
         client.buy(computer);
    }
    
    public static void main(String[] args){
         
       ProductFactory productFactory = new AppleProductFactory();
     
       Product product  = productFactory.createProduct();
       product.printProductInfo();
         
         
    }
}

class Client{
    
    public void buy(Computer computer){
        computer.printComputer();
    }
    
}

class Product{
    
    private OperatorSystem system;
    private Computer computer;
    
    public Product(OperatorSystem system, Computer computer){
        this.system= system;
        this.computer = computer;
    }
    
    public void printProductInfo(){
        this.computer.printComputer();
        this.system.printSystem();
    }
}

interface Computer{
  
    void printComputer();
    
}

interface OperatorSystem{
    void printSystem();
}

//简单工厂
class SimpleComputerFactory {
    
    public static Computer getInstance(String type){
        //type: mac, surface, alienware, mi
        Computer computer = null;
        switch(type){
            case "mac":
                computer = new MacbookProComputer();
                break;
            case "surface":
                computer = new SurfaceComputer();
                break;
            case "alienware":
                computer = new AlienwareComputer();
                break;
            case "mi":
                computer = new MiComputer();
                break;
            default :
                System.out.println("计算机工厂不能创建指定类型："+type+"的计算机");                        
        }
        return computer;
    }
    
}

//工厂方法
interface ComputerFactory{
    
    Computer createComputer();
   
}


//抽象工厂
interface ProductFactory{
    //工厂创建计算机
    Computer createComputer();
    //工厂创建操作系统
    OperatorSystem createSystem();
    
    //创建的产品
    Product createProduct();
}

class MacbookProComputer implements Computer{
    public void printComputer(){
        System.out.println("这是一台 MacbookProComputer");
    }
}

class MacbookProComputerFactory implements ComputerFactory{
     public Computer createComputer(){
         return new MacbookProComputer();
     } 
}

class MacOs implements OperatorSystem{
    public void printSystem(){
        System.out.println("这是MacOS");
    }
}

class AppleProductFactory implements ProductFactory{
    
    public Computer createComputer(){
        return new MacbookProComputer();
    }
    
    public OperatorSystem createSystem(){
        return new MacOs();
    }
    
    public Product createProduct(){
        //制作过程客户端不感知的
        return new Product(this.createSystem(),this.createComputer());
    }
    
}


class SurfaceComputer implements Computer{
    
    public void printComputer(){
        System.out.println("这是一台 SurfaceComputer");
    }
}

class SurfaceComputerFactory implements ComputerFactory{
     public Computer createComputer(){
         return new SurfaceComputer();
     } 
}

class Windows8 implements OperatorSystem{
    public void printSystem(){
        System.out.println("这是Windows8");
    }
} 


class MsProductFactory implements ProductFactory{
    
    public Computer createComputer(){
        return new SurfaceComputer();
    }
    
    public OperatorSystem createSystem(){
        return new Windows8();
    }
    
    public Product createProduct(){
        return new Product(this.createSystem(),this.createComputer());
    }
    
}




class AlienwareComputer implements Computer{
    
    public void printComputer(){
        System.out.println("这是一台 AlienwareComputer");
    }
}

class MiComputer implements Computer{
    public void printComputer(){
        System.out.println("这是一台 MiComputer");
    }
}

