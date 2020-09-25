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

/////////////////8888 PASCAL TRIANGLE////////////////////

   public List<List<Integer>> generate(int numRows)
{
	List<List<Integer>> allrows = new ArrayList<List<Integer>>();
	ArrayList<Integer> row = new ArrayList<Integer>();
	for(int i=0;i<numRows;i++)
	{
		row.add(0, 1);
		for(int j=1;j<row.size()-1;j++)
			row.set(j, row.get(j)+row.get(j+1));
		allrows.add(new ArrayList<Integer>(row));
	}
	return allrows;
	
}

///////////////999 NEXT PERMUTATION     /////////////

   public void nextPermutation(int[] A) {
    if(A == null || A.length <= 1) return;
    int i = A.length - 2;
    while(i >= 0 && A[i] >= A[i + 1]) i--; // Find 1st id i that breaks descending order
    if(i >= 0) {                           // If not entirely descending
        int j = A.length - 1;              // Start from the end
        while(A[j] <= A[i]) j--;           // Find rightmost first larger id j
        swap(A, i, j);                     // Switch i and j
    }
    reverse(A, i + 1, A.length - 1);       // Reverse the descending sequence
}

public void swap(int[] A, int i, int j) {
    int tmp = A[i];
    A[i] = A[j];
    A[j] = tmp;
}

public void reverse(int[] A, int i, int j) {
    while(i < j) swap(A, i++, j--);
}


///////////////10 INVERSION OF ARRAY /////////////////////////////

    private static int mergeAndCount(int[] arr, int l, int m, int r) 
    { 
  
        int[] left = Arrays.copyOfRange(arr, l, m + 1); 
 
        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1); 
  
        int i = 0, j = 0, k = l, swaps = 0; 
  
        while (i < left.length && j < right.length) { 
            if (left[i] <= right[j]) 
                arr[k++] = left[i++]; 
            else { 
                arr[k++] = right[j++]; 
                swaps += (m + 1) - (l + i); 
            } 
        } 

        while (i < left.length) 
            arr[k++] = left[i++]; 

        while (j < right.length) 
            arr[k++] = right[j++]; 
  
        return swaps; 
    } 

    private static int mergeSortAndCount(int[] arr, int l, int r) 
    { 

        int count = 0; 
  
        if (l < r) { 
            int m = (l + r) / 2; 

            count += mergeSortAndCount(arr, l, m); 

            count += mergeSortAndCount(arr, m + 1, r); 

            count += mergeAndCount(arr, l, m, r); 
        } 
  
        return count; 
    }
	
	
	
	
	////  11STOCK BUYY SELL               ///////////////////
	
	// Solution structure 
class Interval { 
    int buy, sell; 
} 
  
class StockBuySell { 
    // This function finds the buy sell schedule for maximum profit 
    void stockBuySell(int price[], int n) 
    { 
        // Prices must be given for at least two days 
        if (n == 1) 
            return; 
  
        int count = 0; 
  
        // solution array 
        ArrayList<Interval> sol = new ArrayList<Interval>(); 
  
        // Traverse through given price array 
        int i = 0; 
        while (i < n - 1) { 
            // Find Local Minima. Note that the limit is (n-2) as we are 
            // comparing present element to the next element. 
            while ((i < n - 1) && (price[i + 1] <= price[i])) 
                i++; 
  
            // If we reached the end, break as no further solution possible 
            if (i == n - 1) 
                break; 
  
            Interval e = new Interval(); 
            e.buy = i++; 
            // Store the index of minima 
  
            // Find Local Maxima.  Note that the limit is (n-1) as we are 
            // comparing to previous element 
            while ((i < n) && (price[i] >= price[i - 1])) 
                i++; 
  
            // Store the index of maxima 
            e.sell = i - 1; 
            sol.add(e); 
  
            // Increment number of buy/sell 
            count++; 
        } 
  
        // print solution 
        if (count == 0) 
            System.out.println("There is no day when buying the stock "
                               + "will make profit"); 
        else
            for (int j = 0; j < count; j++) 
                System.out.println("Buy on day: " + sol.get(j).buy 
                                   + "        "
                                   + "Sell on day : " + sol.get(j).sell); 
  
        return; 
    }
	
	/// 12 rotate Matrix 
	
	   static void rotateMatrix( 
        int N, int mat[][]) 
    { 
        // Consider all squares one by one 
        for (int x = 0; x < N / 2; x++) { 
            // Consider elements in group 
            // of 4 in current square 
            for (int y = x; y < N - x - 1; y++) { 
                // Store current cell in 
                // temp variable 
                int temp = mat[x][y]; 
  
                // Move values from right to top 
                mat[x][y] = mat[y][N - 1 - x]; 
  
                // Move values from bottom to right 
                mat[y][N - 1 - x] 
                    = mat[N - 1 - x][N - 1 - y]; 
  
                // Move values from left to bottom 
                mat[N - 1 - x][N - 1 - y] = mat[N - 1 - y][x]; 
  
                // Assign temp to left 
                mat[N - 1 - y][x] = temp; 
            } 
        } 
    }
	
	
	
	/////13 seacrh 2 D matrxi 
	
		 static final int M = 3; 
	    static final int N = 4; 
	  
	    // Basic binary search to 
	    // find an element in a 1-D array 
	    static boolean binarySearch1D(int arr[], int K) 
	    { 
	        int low = 0; 
	        int high = N - 1; 
	        while (low <= high) { 
	            int mid = low + (high - low) / 2; 
	  
	            // if element found return true 
	            if (arr[mid] == K) { 
	                return true; 
	            } 
	  
	            // if middle less than K then 
	            // skip the left part of the 
	            // array else skip the right part 
	            if (arr[mid] < K) { 
	                low = mid + 1; 
	            } 
	            else { 
	                high = mid - 1; 
	            } 
	        } 
	  
	        // if not found return false 
	        return false; 
	    } 
	  
	    // Function to search an element 
	    // in a matrix based on 
	    // Divide and conquer approach 
	    static boolean searchMatrix(int matrix[][], int K) 
	    { 
	        int low = 0; 
	        int high = M - 1; 
	        while (low <= high) { 
	            int mid = low + (high - low) / 2; 
	  
	            // if the element lies in the range 
	            // of this row then call 
	            // 1-D binary search on this row 
	            if (K >= matrix[mid][0] 
	                && K <= matrix[mid][N - 1]) { 
	                return binarySearch1D(matrix[mid], K); 
	            } 
	  
	            // if the element is less then the 
	            // starting element of that row then 
	            // search in upper rows else search 
	            // in the lower rows 
	            if (K < matrix[mid][0]) { 
	                high = mid - 1; 
	            } 
	            else { 
	                low = mid + 1; 
	            } 
	        } 
	  
	        // if not found 
	        return false; 
	    } 
		
		
		////// 14 power of xn 
		  static float power(float x, int y) 
	    { 
	        float temp; 
	        if( y == 0) 
	            return 1; 
	        temp = power(x, y/2);  
	          
	        if (y%2 == 0) 
	            return temp*temp; 
	        else
	        { 
	            if(y > 0) 
	                return x * temp * temp; 
	            else
	                return (temp * temp) / x; 
	        } 
	    }  