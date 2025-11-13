package striver;

import java.util.Arrays;

public class P6_HouseRobber2 {
    public static int tabulationLinear(int start,int[] nums,int end)
    {
        int len=end-start+1;
        if(len==1) return nums[start];
        int[] dp=new int[len];
        dp[0]=nums[start];
        //picking start index or start+1 index
        dp[1]=Math.max(nums[start],nums[start+1]);
        for(int i=2;i<len;i++)
        {
            int pick=nums[start+i]+dp[i-2];
            int nonPick=dp[i-1];
            dp[i]=Math.max(pick,nonPick);
        }
        return dp[len-1];
    }
    public static int tabulation(int[] nums)
    {
        int n=nums.length;
        if(n==1) return nums[0];
        //case 1: exclude the last house
        int case1=tabulationLinear(0,nums,n-2);
        //case 2: exclude the first house
        int case2=tabulationLinear(1,nums,n-1);
        return Math.max(case1,case2);
    }
    public static int memoizationRecur(int ind,int[] nums,int start,int[] dp)
    {
        //went out of range
        if(ind<start) return 0;
        if(ind==start) return nums[start];
        if(dp[ind]!=-1) return dp[ind];
        int pick=nums[ind]+memoizationRecur(ind-2,nums,start,dp);
        int nonPick=memoizationRecur(ind-1,nums,start,dp);
        return dp[ind]=Math.max(pick,nonPick);
    }
    public static int memoization(int[] nums)
    {
        int n=nums.length;
        if(n==1) return nums[0];
        int[] dp1=new int[n];
        Arrays.fill(dp1,-1);
        //case 1:exclude the last house
        int case1=memoizationRecur(n-2,nums,0,dp1);
        // Case 2: exclude first house
        int[] dp2=new int[n];
        Arrays.fill(dp2,-1);
        int case2=memoizationRecur(n-1,nums,1,dp2);
        return Math.max(case1,case2);
    }
    public static int recursionRecur(int ind,int[] nums,int start)
    {
        //went out of range
        if(ind<start) return 0;
        if(ind==start) return nums[start];
        int pick=nums[ind]+recursionRecur(ind-2,nums,start);
        int nonPick=recursionRecur(ind-1,nums,start);
        return Math.max(pick,nonPick);
    }
    public static int recursion(int[] nums)
    {
        int n=nums.length;
        if(n==1) return nums[0];
        //case 1:exclude the last house
        int case1=recursionRecur(n-2,nums,0);
        // Case 2: exclude first house
        int case2=recursionRecur(n-1,nums,1);
        return Math.max(case1,case2);
    }
    public static void main(String[] args) {
        int[] arr = {1, 5, 1, 2, 6};
        System.out.println(recursion(arr));
    }
}
