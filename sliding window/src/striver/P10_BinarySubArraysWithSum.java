package striver;
//count the number of sub arrays whose sum is exactly equal to the given goal
public class P10_BinarySubArraysWithSum {
    //Time Complexity:O(2*2N)
    //Space Complexity: O(1)
    public static int numSubarraysWithSumLessEqualToGoal(int[] nums,int goal)
    {
        int n=nums.length;
        if(goal<0) return 0;
        int left=0,right=0;
        int sum=0;
        //Variable to count number of sub arrays
        int count=0;
        while(right<n)
        {
            sum+=nums[right];
            //check for valid window
            while(sum>goal)
            {
                sum-=nums[left];
                left++;
            }
            // Count all sub arrays ending at r` that satisfy the sum condition
            count+=(right-left+1);
            right++;
        }
        return count;
    }
    public static int numSubarraysWithSum(int[] nums,int goal)
    {
        return numSubarraysWithSumLessEqualToGoal(nums, goal) - numSubarraysWithSumLessEqualToGoal(nums, goal - 1);
    }
    public static void main(String[] args) {
        int[] nums = {1, 0, 0, 1, 1, 0};
        int goal = 2;
        int ans = numSubarraysWithSum(nums, goal);
        System.out.println("Number of substrings with sum \"" + goal + "\" is: " + ans);
    }
}
