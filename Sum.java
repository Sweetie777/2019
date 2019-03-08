
第九章:
   finally{}无论什么情况下都会执行
1. 如果在finally之前调用System.exit()  VM停止
2. 未知错误(断电,硬件损坏等)
3. finally在return之后执行,不要在finally{}中return

   throws 方法声明上使用. 告诉方法调用者,这里可能会抛出异常.可以写多个异常
   throw 用于方法内部,表示手工异常抛出
   如果多个catch捕获异常,由子类到父类来写  因为它是从第一个catch开始按顺序执行的
   检查异常必须处理
   不要总是把异常抛在main方法中

   RuntimeException类(面试重点)
例子:(还有很多,要多记几个)
NullPointerException是一个典型的运行时异常
IllegalAccessException
ClassCastException
如果它的父类里没有RuntimeException就是非检查异常,如果有Excpetion就是检查异常,必须捕获(!)
在项目的系统设计或者架构设计时，一定会涉及到与业务相关的异常问题，此时需要自定义异常类。
以后所有java中的问题都去https://stackoverﬂow.com/网站查询。


java是默认不开启断言的
要开启Java-ea
error有个子类AssertionError


第十一章:
1.枚举类: private构造方法
2.指定实例化对象啊构造方法之前
3.枚举类同样可以指定成员属性,通常属性在构造时初始化,并提供getter
4.访问枚举类的实例化对象直接通过类名访问  类名.实例化的对象名
5.获取枚举类的所有实例化对象通过 类名.values();
6.通过枚举的实例化对象名(常量名)获取对象  类名.valueoOf(name);

switch()支持数字,字符串,枚举

枚举类不能继承,默认已经继承了一个enum类

枚举类的;是不能少的
public enum color{
	;
}




作业：（提交方式gitee，GitHub的代码片段url地址）
3.模版设计模式：在线购物流程 (天猫，京东)
浏览商品 -> 选择商品 -> 客服服务 -> 快递服务 -> 结算 -> 付款 -> 查看订单
4.字符界面的收银台


接口里面可以放常量和抽象方法

lambda表达式:
0. 接口有且仅有一个抽象方法(!),使用 @FunctionInterface 表示
1. 如果抽象方法的实现中只有一条命令,大括号可以省略
2. 如果抽象方法参数只有一个,参数列表的括号可以省略
3. 如果抽象方法实现中有返回值,并且只有一条命令,那么语句的结果就是返回值
4. (参数列表) -> {(实现内容:)};
注意:在lambda表达式所在的作用域下,防止参数列表名中的参数名和作用域中的其他变量名冲突


方法引用:
1. 面向对象编程:
      类: 静态方法
      对象:成员方法
      y = f(x) = 类:静态方法(x)
2.(1). 引用静态方法：类名称::static 方法名称 ；
  (2). 引用某个对象的方法：实例化对象 :: 普通方法 ；
  (3). 引用某个特定类的方法： 类名称 :: 普通方法 ；
  (4). 引用构造方法： 类名称 :: new 
  结合函数式编程引用
3.功能型函数和供给型函数结合使用
y = f(x)  y -> supplier      x -> String
消费型函数: 可以用于 打印输出
有参数 没有返回值


第十四章
1.文件分隔符: Windows -> \       unix -> / 代码跨平台注意使用: File.separator
2.路径分隔符: Windows -> ;       unix -> : 代码跨平台注意使用: File.pathSeparator
3.文件名大小写 windows不区分 linux和unix区分
Windows: hello.txt  和Hello.txt 是一个文件
linux和unix:是两个文件

创建目录:
parentFile.mkdir();//D:\a  只创建当前目录
parentFile.mkdirs();//D:\a\b  创建当前目录及上级目录(如果不存在就创建)  常用这个!
加s的是类的辅助类(工具类)   path  paths 
用法: Path path = Paths.get(first:"D:", ...more:"teset");
File file = path.toFile();//获取文件对象
File file1 = paths.get().toFile();//获取文件对象

除了java.lang里的包其他的都要导入  alt + enter
异常捕获  try{} catch(e){}         alt + enter

输入流：1. 准备文件
        2. 实例化FileInputStream对象
		3. read()读取数据
		4. 业务处理
		5. 关闭输入流-finally
输出流：1. 准备文件，文件不存在 自动创建，但是目录一定要存在
        2. 实例化FileOutputStream对象
		3. 业务处理数据
		4. write()输出数据
		5. 关闭输出流-finally		
业务处理：
        1. 读取数据，while(){},读到末尾返回-1



如果要对输出的内容进行追加，那就在output后加append：True   ，不加append就相当于覆盖了
out.write(b:'\n')；   换行

AutoCloseable的close能够被自动调用
try-with-resources：finall可以不用
try(实例化对象的代码，实例化对象的类必须要实现AutoCloseable接口才可以用){
	
}catch{
	
}finally{
	
}
捕获和之前不同的是 try后面多了()

字节流和字符流的对比:
字节流读的是字节,字符流读的是字符
字节流是原生流, 字符流是对字节进行编码和解码
处理图片,文字,音乐使用字节流, 处理中文时才使用字符流
outputstreamwriter 字节输出流转化为字符输出流
inputstreamreader  字节输入流转化为字符输入流 
从整个继承机构来说,可以发现所有字符流处理都是经过转换后得到的

print输出的时候:   正数右对齐  负数左对齐 %后面直接加就行
string.format格式化 和 system.out.printf  用法一致

System.out.println具体解释(考试题!)
System:  是个类,在java.lang包下面,自动导入
out:     是个对象object 是system的静态属性java.io.PrintStream
println: 是PrintStream类的成员方法, 是.out对象的方法
System.in.read()也是同理 是InputStream的方法


Scanner构造方法中传入文件, 替代BufferedReader

常用的系封属性:  user.home    user.dir   java.home   path.separator   file.separator
1.java提供的一种序列化:(jdk提供)  
object(In Memory)  -> byte[]  (网络中传输, 保存文件)  序列化 -> 输出
byte[]             -> Object(In Memory)   反序列化 -> 输入
2.object ->JSON(前端开发javascript) Person(name, age) -("name":jack, "age": 22)  
JSON -> Object
3.object ->xml(xm文件)(jdk提供)
xml -> object
4.java的序列化:
  4.1序列化对象的属性信息
  4.2反序列化不会执行你的构造方法 构造块

java语言开发桌面版程序:
java.awt
javas.swing  目前不怎么用
客户端程序: 
        java FX(javase + fx api + xml + css + html4/5 + javascript)
        Andriod (javase +goole andriod api)

以下两个方法不是重载,本质上他俩是一样的
    public static void hello(String[] args){
        
    }
    public static void main(String...args) {
        
    }

foreach  每次循环的时候会将数组中的元素赋值得变量  缺点是无法利用下表取元素 除非外部定义

静态导入: 这个类提供静态方法

java支持静态导入,但是如果方法重名,存在二义性,不建议使用. 
如果代码中同时使用到两个类名相同, 包名不同的, 建议使用类的全限定名.比如 java.long.String com.bittch.string

泛型: 泛型只接受类, 泛型类可以接收多个类型参数
class MyClass<T>{
	T value1;
}
泛型改变了向下转型的需要, 可以明确指定类型
泛型方法和泛型类是相互独立的, 但是可以共存
如果一个泛型类中存在泛型方法, 那就不同的命名.

///