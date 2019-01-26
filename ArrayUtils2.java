public class ArrayUtils2{
	//1.计算数组中的最大值
	public static int arrayMaxElement(int[] data){
		if(data == null){
			throw new IllgalArgumentException("data must be not null!");
		}
		int max = Integer.MIN.VALUE;
		for(int i = 1; i < data.length; i++){
			if(data[i]>max){
				max = data[i];
			}
		}
		return max;
	}
	
	//2.计算数组中的最小值
	public static int arrayMinElement(int[] data){
        if(data == null){
            throw new IllegalArgumentException("data must be not null.");
		}			
	    int min = Integer.MAX.VALUE;
	    for(int i = 1; i < data.length; i++){
            if(data[i] < min){
		        min = data[i];
		    }			
	    }
	    return min;
	}
	//3.计算数组值之和
	public static int arrayElementSum(int[] data){
	    if(data == null){
            throw new IllegalArgumentException("data must be not null.");
		}	
		int sum = 0;
		for(int i = 1; i < data.length; i++){
		   sum = sum + data;
		}
		return sum;
	
	}
	
	//4.数组拼接
	public static int arrayJoin(int[] a,int[] b){
		if(a ==null){
            throw new IllegalArgumentException("a must be not null.");
        }
        if(b == null){
            throw new IllegalArgumentException("b must be not null.");
        }
		
		int length = a.length + b.length;
		int [] c = new int [length];
	    for(int i = 0; i < a.length; i++){
			c[i] = a[i];
		}
		for(int i = a.length; i < c.length; i++){
			c[i] = b[i - a.length];
		}
		return c;
	}
	
	//5.数据截取[start][end]
	public static int [] arraySub(int[] a, int start, int end){
		int count = end - start;
		int[] b = new int[count];
		for(i = start ; i < end; i++){
			b[i - start] = a[i];
		}
		return b;
	}
	public static void printArray(int[] temp){
		for(int i = 0; i < a.length; i++){
			System.out.println(a[i]+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		int[] a = new int[]{11, 23, 43, 58, 39};
		int max = arrayMaxElement(a);
		System.out.println(max);//58
		System.out.println(min);//11
	    int[] Sub = arraySub(a, 0, 5);
		printArray(sub);
	}
		
	
	
	
}