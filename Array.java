import java.util.Arrays;
public class Array{
	public static int fang(int[] data){
	int[] intData = new int[]{1, 65, 34, 82,100};
	    char[] charData = new char[]{'a', 'c', 'b', 'A'};
	    java.util.Arrays.sort(intData);
	    java.util.Arrays.sort(charData);
	    printArray(intData);
	    printArray(charData);
    }
    public static void printArray(int[] temp2){
		for(int i = 0; i < temp2.length; i++){
			System.out.println(temp2[i]);
		}
		System.out.println();
	}
	//重载
	public static void printArray(char[] temp1){
		for(int i = 0; i < temp1.length; i++){
			System.out.println(temp1[i]);
		}
		System.out.println();
	
	}
	
    public static void gg(int[] ok){
		int[] dataA = new int[]{1, 2, 3, 4, 5, 6};
		int[] dataB = new int[]{11, 22, 33, 44, 55, 66};
		System.arraycopy(dataB, 3, dataA, 1, 3);
		printArray(dataA);
	}
	public static void printArray(int[]temp){
		for(int i = 0; i < temp.length; i++){
			System.out.println(temp[i]);
		}
		System.out.println();
	}
	
	//数组拷贝 java.util.Arrays.copyof(原数组名称,新数组长度)
	public static void main(String[] args){
		int[] original = new int[]{1, 2, 3, 4, 5, 6, 8};
		int[] result = Arrays.copyof(original,10);
		for(int temp : result){
			System.out.println(temp);
		}
	}
	
	public static void processData(int[] temp){
		processData(new int[]{1, 23, 43, 56,98});
	}
	public static void processData(int[]temp){
		double[] result = new double[4];
		result[0] = temp[0];
		result[1] = temp[0];
		result[2] = temp[0];
		result[3] = temp[0];
		for(int i = 0; i <temp.length; i++){
			result[2] += temp[1];
			if(temp[i] > result[0]){
				result[0] = temp[i];
			}
			if(temp[i] < result[0]){
			    result[0] = result[i];
			}
		}
		reuslt[3] = result[2]temp.length;
		System.out.println("最大值是:"+result[0]);
		System.out.println("最小值是:"+result[1]);
		System.out.println("总和是:"+result[2]);
		System.out.println("平均值是:"+result[3]);
	}
		
	
}
		