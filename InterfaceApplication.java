public class InterfaceApplication{
    
    public static void main(String[] args){
        Computer computer =new Computer();
        
        //多态的一种实现方法
        //Usb udisk = new UDisk();//向上转型
        computer.plugin(new UDisk());
    
        //Usb keyboard = new KeyBoard();
        computer.plugin(new KeyBoard());
        
    }

}

interface Usb{
    
    //安装驱动-设备厂商提供
    void setup();
    
    //设备工作
    void work();
    
}

class Computer{
    
    public void plugin(Usb usb){
        usb.setup();
        usb.work();
    }
}


class UDisk implements Usb{
    
    public void setup(){
        System.out.println("安装U盘的驱动程序");
    }
    
    public void work(){
        System.out.println("通过U盘与计算机之间进行数据传输");
    }
}

class KeyBoard implements Usb{
    public void setup(){
        System.out.println("安装键盘的驱动程序");
    }
    public void work(){
        System.out.println("通过键盘操作计算");
    }
}



