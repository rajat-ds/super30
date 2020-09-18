public int findDuplicate(int[] nums) {
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



//	Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
//
//	Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
//
//	Follow up:
//
//	Could you solve this problem without using the library's sort function?
//	Could you come up with a one-pass algorithm using only O(1) constant space?
	   public void sortColors(int[] nums) {
		    // 1-pass
		    int p1 = 0, p2 = nums.length - 1, index = 0;
		    while (index <= p2) {
		        if (nums[index] == 0) {
		            nums[index] = nums[p1];
		            nums[p1] = 0;
		            p1++;
		        }
		        if (nums[index] == 2) {
		            nums[index] = nums[p2];
		            nums[p2] = 2;
		            p2--;
		            index--;
		        }
		        index++;
		    }
		}
		
//333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333//////
		
//	Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

//Note:

//The number of elements initialized in nums1 and nums2 are m and n respectively.
//You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.

    public void merge(int[] nums1, int m, int[] nums2, int n) {
          int tail1 = m - 1, tail2 = n - 1, finished = m + n - 1;
    while (tail1 >= 0 && tail2 >= 0) {
        nums1[finished--] = (nums1[tail1] > nums2[tail2]) ? 
                             nums1[tail1--] : nums2[tail2--];
    }

    while (tail2 >= 0) { //only need to combine with remaining nums2
        nums1[finished--] = nums2[tail2--];
    }
    }
	
	
	
	//44444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444///
	
	///Repeated and missing number
	
	//Let x be the missing and y be the repeating element.
//Let N is the size of array.
//Get the sum of all numbers using formula S = N(N+1)/2
//Get product of all numbers using formula Sum_Sq = N(N+1)(2N+1)/6
//Iterate through a loop from i=1….N
//S -= A[i]
//Sum_Sq -= (A[i]*A[i])
//It will give two equations
//x-y = S – (1)
//x^2 – y^2 = Sum_sq
//x+ y = (Sum_sq/S) – (2)
	static Vector<Integer> repeatedNumber(int[] A)  
    { 
        int len = A.length; 
        int Sum_N = (len * (len + 1)) / 2; 
        int Sum_NSq = (len * (len + 1) *  
                         (2 * len + 1)) / 6; 
        int missingNumber = 0, repeating = 0; 
  
        for (int i = 0; i < A.length; i++)  
        { 
            Sum_N -= A[i]; 
            Sum_NSq -= A[i] * A[i]; 
        } 
  
        missingNumber = (Sum_N + Sum_NSq /  
                                 Sum_N) / 2; 
        repeating = missingNumber - Sum_N; 
        Vector<Integer> ans = new Vector<>(); 
        ans.add(repeating); 
        ans.add(missingNumber); 
        return ans; 
    } 
	
	
	///5555555555555555555555555555555555555555555555555555555555555555555555///
	//max sub array///////////////

static void maxSubArraySum(int a[], int size) 
    { 
        int max_so_far = Integer.MIN_VALUE, 
        max_ending_here = 0,start = 0, 
        end = 0, s = 0; 
  
        for (int i = 0; i < size; i++)  
        { 
            max_ending_here += a[i]; 
  
            if (max_so_far < max_ending_here)  
            { 
                max_so_far = max_ending_here; 
                start = s; 
                end = i; 
            } 
  
            if (max_ending_here < 0)  
            { 
                max_ending_here = 0; 
                s = i + 1; 
            } 
        } 
        System.out.println("Maximum contiguous sum is " 
                           + max_so_far); 
        System.out.println("Starting index " + start); 
        System.out.println("Ending index " + end); 
    } 	
	
	////Merge Intervals 6 6666666666666666666666666666666666/////
	  // The main function that takes a set of intervals, merges  
    // overlapping intervals and prints the result  
    public static void mergeIntervals(Interval arr[])  
    {  
        if (arr.length <= 0)  
            return;  
    
        Stack<Interval> stack=new Stack<>(); 
         Arrays.sort(arr,new Comparator<Interval>(){ 
            public int compare(Interval i1,Interval i2) 
            { 
                return i1.start-i2.start; 
            } 
        }); 
          stack.push(arr[0]);  
           for (int i = 1 ; i < arr.length; i++)  
        {  
              Interval top = stack.peek();  
    
            if (top.end < arr[i].start)  
                stack.push(arr[i]);  
      
            else if (top.end < arr[i].end)  
            {  
                top.end = arr[i].end;  
                stack.pop();  
                stack.push(top);  
            }  
        }  
    
        // Print contents of stack  
        System.out.print("The Merged Intervals are: "); 
        while (!stack.isEmpty())  
        {  
            Interval t = stack.pop();  
            System.out.print("["+t.start+","+t.end+"] "); 
        }   
    }
	
	/////set 77777777777 SET MATRXI ZERO/////////
	
	 public void setZeroes(int[][] matrix) {
    boolean fr = false,fc = false;
    for(int i = 0; i < matrix.length; i++) {
        for(int j = 0; j < matrix[0].length; j++) {
            if(matrix[i][j] == 0) {
                if(i == 0) fr = true;
                if(j == 0) fc = true;
                matrix[0][j] = 0;
                matrix[i][0] = 0;
            }
        }
    }
    for(int i = 1; i < matrix.length; i++) {
        for(int j = 1; j < matrix[0].length; j++) {
            if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                matrix[i][j] = 0;
            }
        }
    }
    if(fr) {
        for(int j = 0; j < matrix[0].length; j++) {
            matrix[0][j] = 0;
        }
    }
    if(fc) {
        for(int i = 0; i < matrix.length; i++) {
            matrix[i][0] = 0;
        }
    }
    
}