package day1;

public class mergeTwoSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr1[] = new int[]{1,3,5,0,0,0};
		int arr2[] = new int[]{2,4,6};
		int mergedArray[] = new int[6];
		mergedArray=mergeArray(arr1,3,arr2,3);
        System.out.println("merged array :");
        for(int i =0;i<6;i++)
        	System.out.print(mergedArray[i] + " ");
	} 
    public static int[] mergeArray(int [] num1,int m ,int num2[] ,int n) {
    	int tail1 = m-1 ,tail2=n-1,finish=m+n-1;
    	while(tail1>=0 && tail2>=0) {
    		num1[finish--]=(num1[tail1]>=num2[tail2]?num1[tail1--]:num2[tail2--]);
    	}
    	while(tail2>=0) {
    		num1[finish--]=num2[tail2--];
    	}
    	return num1;
    }
}
