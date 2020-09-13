package day1;

public class findDuplicate {

	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,4,5,6,7,8,9,8};
		System.out.println("Duplicate Number is " + findDuplicateOptimal(arr));

	}
	
	public static int findDuplicateNumber(int[] n) {
		  for (int i =0;i<n.length;i++) {
			  int x = Math.abs(n[i]);
			  if(n[x-1]<0) 
				  return x;
			  else 
				  n[x-1]*=-1;
		  }
          return -1;
	}
	public static int findDuplicateOptimal(int[] nums) {
	    int n = nums.length;
	    int slow = n;
	    int fast = n;
	    do{
	        slow = nums[slow-1];
	        fast = nums[nums[fast-1]-1];
	    }while(slow != fast);
	    slow = n;
	    while(slow != fast){
	        slow = nums[slow-1];
	        fast = nums[fast-1];
	    }
	    return slow;
	}

}
