//String类扩展功能实现
public class Strings{

    
     /**
     * 重复某个字符
     * 
     * 例如： 
     * 'a' 5   => "aaaaa"  
     * 'a' -1  => ""
     * 
     * @param c     被重复的字符
     * @param count 重复的数目，如果小于等于0则返回""
     * @return 重复字符字符串
     */
    public static String repeat(char c, int count) {
       if(count<=0){
		   return "";
	   }else{
		   char[] array = new char[count];
		   for(int i=0; i<count; i++){
			   array[i]=c;
		   }
	   String sq = new String(array);
	   return sq;
	   }
    }
    
    
     /**
     * 将已有字符串填充为规定长度，如果已有字符串超过这个长度则返回这个字符串
     * 字符填充于字符串前
     *
     * 例如： 
     * "abc" 'A' 5  => "AAabc"
     * "abc" 'A' 3  => "abc"
     *
     * @param str        被填充的字符串
     * @param filledChar 填充的字符
     * @param len        填充长度
     * @return 填充后的字符串
     */
    public static String fillBefore(String str, char filledChar, int len) {
	   int length=str.length();
       if(length>len){
		   return str;
	   }else{
		   int h=len-length;
		   char[] array = new char[h];
		   for(int i=0;i<h;i++){
			   array[i]=filledChar;
		   }
	   String sq=new String(array);
	   str=sq+str;
	   return str;
    }
	}
    
    /**
     * 将已有字符串填充为规定长度，如果已有字符串超过这个长度则返回这个字符串<br>
     * 字符填充于字符串后
     * 例如： 
     * "abc" 'A' 5  => "abcAA"
     * "abc" 'A' 3  => "abc"
     *
     * @param str        被填充的字符串
     * @param filledChar 填充的字符
     * @param len        填充长度
     * @return 填充后的字符串
     */
    public static String fillAfter(String str, char filledChar, int len) {
        int length=str.length();
       if(length>len){
		   return str;
	   }else{
		   int h=len-length;
		   char[] array = new char[h];
		   for(int i=0;i<h;i++){
			   array[i]=filledChar;
		   }
	   String sq=new String(array);
	   str=str+sq;
	   return str;
        
    }
	}

    /**
     * 移除字符串中所有给定字符串
     * 例：removeAll("aa-bb-cc-dd", "-") => aabbccdd
     *
     * @param str         字符串
     * @param strToRemove 被移除的字符串
     * @return 移除后的字符串
     */
    public static String removeAll(CharSequence str, CharSequence strToRemove) {
        if(str==null){
        return null;
		}else{
			 String s = new String(str.toString());//获取字符串
			while(s.contains(strToRemove)){  //判断字符串是否存在
				s=s.replace(strToRemove,"");//替换
			}
			return s;
		}
    }
    
    /**
     * 反转字符串
     * 例如：abcd => dcba
     *
     * @param str 被反转的字符串
     * @return 反转后的字符串
     */
    public static String reverse(String str) {
        if(str==null){
        return null;
		}
		int left=0;
		int right=str.length()-1;
		char swap;
		char[] data = str.toCharArray() ;
		while(left<=right){
			swap=data[left];
			data[left]=data[right];
			data[right]=swap;
			left++;
			right--;
		}
		String s=new String(data);
		return s;
		
		
    }
	public static void test1(){
		System.out.println("重复某个字符"+"    "+repeat('a',5));
		System.out.println("重复某个字符"+"    "+repeat('a',0));
	    System.out.println("重复某个字符"+"    "+repeat('a',-1));
	}
	public static void test2(){
		String str="abc";
		System.out.println("填充字符前");
		
		System.out.println(fillBefore(str,'A',5));
		System.out.println(fillBefore(str,'A',2));
	}
	public static void test3(){
		String str="abc";
		System.out.println("填充字符后");
		System.out.println(fillAfter(str,'A',5));
		System.out.println(fillAfter(str,'A',2));
	}
	public static void test4(){
		System.out.println("移除给定的字符");
		String str="a-bcde-f";
		System.out.println(removeAll(str,"-"));
		System.out.println(removeAll(str,"-"));
	}
	public static void test5(){
		System.out.println("反转字符");
		String str="abcdef";
		System.out.println(reverse(str));
	}
	public static void main(String[] args){
		test1();
		System.out.println("**************");
		test2();
		System.out.println("**************");
		test3();
		System.out.println("**************");
		test4();
		System.out.println("**************");
		test5();
		System.out.println("**************");
	}
}