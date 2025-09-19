package striver;
//Count the number of sub arrays that contain exactly k odd numbers.
public class P11_CountNoOfNiceSubArrays {
    //Time Complexity:O(2*2N)
    //Space Complexity: O(1)
    public static int numberOfOddSubarrays(int[] nums,int k)
    {
        return helper(nums, k) - helper(nums, k - 1);
    }
    public static int helper(int[] nums,int goal)
    {
        int n=nums.length;
        if(goal<0) return 0;
        int left=0,right=0;
        //variable to track the current sum of elements in the window
        int sum=0;
        //variable to count the number of sub arrays
        int count=0;
        while(right<n)
        {
            sum+=nums[right]%2;
            while(sum>goal)
            {
                sum-=nums[left]%2;
                left++;
            }
            //Now here left to right is valid
            // Count all sub arrays ending at r` that satisfy the sum condition
            count+=(right-left+1);
            right++;
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 1, 1};
        int k = 1;
        int ans = numberOfOddSubarrays(nums, k);
        System.out.println("Number of nice sub arrays with \"" + k + "\" odd numbers is: " + ans);
    }
}
