package striver;

import java.util.Arrays;

public class P24_RodCutting {
    public static int memoizationRecur(int ind, int n, int[] price, int[][] dp)
    {
        if(ind==0) return price[0]*n;
        if(dp[ind][n]!=-1) return dp[ind][n];
        int notTake=memoizationRecur(ind-1,n,price,dp);
        int rodLength=ind+1;
        int take=Integer.MIN_VALUE;
        if(rodLength<=n)
            take=price[ind]+memoizationRecur(ind,n-rodLength,price,dp);
        return dp[ind][n]=Math.max(notTake,take);
    }
    public static int memoization(int[] price, int n)
    {
        int[][] dp=new int[n][n+1];
        for(int[] row:dp) Arrays.fill(row,-1);
        return memoizationRecur(n-1,n,price,dp);
    }

    public static int recursionRecur(int ind, int n, int[] price)
    {
        if(ind==0) return price[0]*n;
        int notTake=recursionRecur(ind-1,n,price);
        int rodLength=ind+1;
        int take=Integer.MIN_VALUE;
        // Initialize the value for taking the current rod piece as very small
        if(rodLength<=n)
            take=price[ind]+recursionRecur(ind,n-rodLength,price);
        return Math.max(notTake,take);
    }
    public static int recursion(int[] price, int n)
    {
        return recursionRecur(n - 1, n, price);
    }
    public static void main(String[] args) {
        int[] price = {2, 4, 6, 8};
        int n = price.length;
        System.out.println("The Maximum value is " + memoization(price, n));
    }
}
