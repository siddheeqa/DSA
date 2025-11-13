package striver;

import java.util.Arrays;

public class P5_HouseRobber1 {
    public static int optimal(int[] nums)
    {
        int n=nums.length;
       int prev2=0;
       int prev=nums[0];
        for(int i=1;i<n;i++)
        {
            int pick=nums[i];
            if(i>1)
                pick+=prev2;
            int nonPick=0+prev;
            int curr=Math.max(pick,nonPick);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
    public static int tabulation(int[] nums)
    {
        int n=nums.length;
        int[] dp=new int[n];
        dp[0]=nums[0];
        for(int i=1;i<n;i++)
        {
            int pick=nums[i];
            if(i>1)
                pick+=dp[i-2];
            int nonPick=dp[i-1];
            dp[i]=Math.max(pick,nonPick);
        }
        return dp[n-1];
    }
    public static int memoizationFunc(int ind,int[] nums,int[] dp)
    {
        if(ind==0)
            return nums[ind];
        if(ind<0) return 0;
        if(dp[ind]!=-1) return dp[ind];
        //choosing the current element
        int pick=nums[ind]+memoizationFunc(ind-2,nums,dp);
        //skipping the current element
        int nonPick=memoizationFunc(ind-1,nums,dp);
        return dp[ind]=Math.max(pick,nonPick);
    }
    public static int memoization(int[] nums)
    {
        int ind=nums.length-1;
        int[] dp=new int[ind+1];
        Arrays.fill(dp,-1);
        return memoizationFunc(ind,nums,dp);
    }
    public static int recursionRecur(int ind,int[] nums)
    {
        //our goal is to maximize it
        if(ind==0)
            return nums[ind];
        if(ind<0) return 0;
        //choosing the current element
        int pick=nums[ind]+recursionRecur(ind-2,nums);
        //skipping the current element
        int nonPick=recursionRecur(ind-1,nums);
        return Math.max(pick,nonPick);
    }
    public static int recursion(int[] nums)
    {
        int ind= nums.length-1;
        return recursionRecur(ind,nums);
    }
    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 9};
        // Call the nonAdjacent function and print the result
        System.out.println(optimal(arr));
    }
}
