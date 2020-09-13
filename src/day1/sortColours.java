package day1;

public class sortColours {
	
	
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
}
