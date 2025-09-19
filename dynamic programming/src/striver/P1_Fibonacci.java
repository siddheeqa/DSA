package striver;

import java.util.Arrays;

public class P1_Fibonacci {
    //Time Complexity O(N)
    //SpaceComplexity O(1)
    public static int optimal(int n)
    {
        if(n<=1)
            return n;
        int prev2=0;
        int prev=1;
        for(int i=2;i<=n;i++)
        {
            int cur=prev2+prev;
            prev2=prev;
            prev=cur;
        }
        return prev;
    }
    //Time Complexity: O(N)
    //SpaceComplexity O(N)
    public static int tabulation(int n,int[] dp)
    {
        // Base case for Fibonacci sequence
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++)
        {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    //Time Complexity: O(N)
    //Space Complexity: O(N) Using recursion stack space and an array, the total space complexity is O(N) + O(N) ≈ O(N).
    public static int memoization(int n,int[] dp)
    {
        if(n<=1) return n;
        //check if the sub problem is already solved
        if(dp[n]!=-1) return dp[n];
        //calculate the value and store it in dp array
        dp[n]=memoization(n-1,dp)+memoization(n-2,dp);
        return dp[n];
    }
    public static void main(String[] args) {
        int n = 5;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(memoization(n, dp));
    }
}
