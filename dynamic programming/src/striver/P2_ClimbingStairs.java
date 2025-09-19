package striver;

import java.util.Arrays;

public class P2_ClimbingStairs {
    //Time Complexity: O(N)
    //Space Complexity:O(1)
    public static int optimal(int n)
    {
        if(n<=1)
            return 1;
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
    //Space Complexity:O(N)
    public static int tabulation(int n)
    {
        int[] dp=new int[n+1];
        //base cases
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++)
            dp[i]=dp[i-1]+dp[i-2];
        return dp[n];
    }
    public static int memoizationRecur(int n,int[] dp)
    {
        if(n<=1) return 1;
        //Check if the sub problem is already solved
        if(dp[n]!=-1)
            return dp[n];
        return dp[n]=memoizationRecur(n-1,dp)+memoizationRecur(n-2,dp);
    }
    //Time Complexity: O(N)
    //Space Complexity:O(N)+O(N)
    public static int memoization(int n)
    {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return dp[n]=memoizationRecur(n,dp);
    }
    //Time Complexity: O(2N)
    //Space Complexity: O(n)
    public static int recursion(int n)
    {
        //Base case
        if(n<=1) return 1;
        //Taking one step at a time
        int oneStep=recursion(n-1);
        //Taking 2 steps at a time
        int twoStep=recursion(n-2);
        //Return total ways
        return oneStep+twoStep;
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println("The total number of ways: "+tabulation(n));
    }
}
