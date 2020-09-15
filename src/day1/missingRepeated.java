package day1;
import java.util.*; 
public class missingRepeated {
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
  
    // Driver Code 
    public static void main(String[] args)  
    { 
        int[] v = { 4, 3, 6, 2, 1, 6, 7 }; 
        Vector<Integer> res = repeatedNumber(v); 
        for (int x : res)  
        { 
            System.out.print(x + " "); 
        } 
    } 
}
