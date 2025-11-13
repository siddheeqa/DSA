package striver;

import java.util.Arrays;

public class P8_UniquePath1 {
    public static int optimal(int m,int n)
    {
        int[] prev=new int[n];
        for(int i=0;i<m;i++) {
            int[] temp=new int[n];
            for (int j = 0; j < n; j++) {
             if(i==0 && j==0) {
                 temp[j]=1;
                 continue;
             }
             int up=(i>0)?prev[j]:0;
             int left=(j>0)?temp[j-1]:0;
             temp[j]=up+left;
            }
            prev=temp;
        }
        return prev[n-1];
    }
    public static int tabulationLinear(int m,int n,int[][] dp)
    {
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
            {
                if(i==0 && j==0)
                {
                    dp[i][j]=1;
                    continue;
                }
                int up=0;
                int left=0;
                // If we are not at first row (i > 0), update 'up' with the value from the cell above
                if(i>0) up=dp[i-1][j];
                //If we are not at the first column (j > 0), update 'left' with value from the cell to left
                if(j>0) left=dp[i][j-1];
                dp[i][j]=up+left;
            }
        return dp[m-1][n-1];
    }
    public static int tabulation(int m,int n)
    {
        int[][] dp=new int[m][n];
        return tabulationLinear(m,n,dp);
    }
    public static int memoizationRecur(int i,int j,int[][] dp)
    {
        if(i==0 && j==0) return 1;
        //If we go out of bounds, there is no way
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int up=memoizationRecur(i-1,j,dp);
        int down=memoizationRecur(i,j-1,dp);
        return dp[i][j]=up+down;
    }
    public static int memoization(int m,int n)
    {
        int dp[][] =new int[m][n];
        for(int[] row:dp)
            Arrays.fill(row,-1);
        return memoizationRecur(m-1,n-1,dp);
    }
    public static int recursionRecur(int i,int j)
    {
        if(i==0 && j==0) return 1;
        //If we go out of bounds, there is no way
        if(i<0 || j<0) return 0;
        int up=recursionRecur(i-1,j);
        int down=recursionRecur(i,j-1);
        return up+down;
    }
    public static int recursion(int m,int n)
    {
        return recursionRecur(m-1,n-1);
    }
    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        System.out.println("Number of ways: " + optimal(m, n));
    }
}
