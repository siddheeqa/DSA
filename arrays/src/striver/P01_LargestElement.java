package striver;

import java.util.Arrays;

public class P01_LargestElement {
    //TC:O(N)
    public static int optimal(int[] nums)
    {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }
    //TC:O(NLOGN)
    public static int brute(int[]  nums) {
        // Sort array
        Arrays.sort(nums);
        int largest = nums[nums.length - 1];
        return largest;
    }
    public static void main(String[] args) {
        int[] nums={3,2,1,5,2};
        int largest=optimal(nums);
        System.out.println(largest);
    }
}
