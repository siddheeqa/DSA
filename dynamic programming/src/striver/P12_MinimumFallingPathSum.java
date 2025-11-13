package striver;

import java.util.Arrays;

public class P12_MinimumFallingPathSum {
    public static int optimal(int[][] matrix)
    {
        int n=matrix.length;
        int m=matrix[0].length;

        // Represents previous row's minimum path sums
        int[] prev = new int[m];
        for (int j = 0; j < m; j++) {
            prev[j] = matrix[0][j];
        }
        for(int i=1;i<n;i++) {
            int[] curr = new int[m];
            for (int j = 0; j < m; j++) {
                int up = matrix[i][j] + prev[j];
                int leftDiagonal = matrix[i][j];
                if (j - 1 >= 0)
                    leftDiagonal += prev[j - 1];
                else
                    leftDiagonal = Integer.MAX_VALUE;
                int rightDiagonal = matrix[i][j];
                if (j + 1 < m)
                    rightDiagonal += prev[j + 1];
                else
                    rightDiagonal = Integer.MAX_VALUE;
                curr[j] = Math.min(up, Math.min(leftDiagonal, rightDiagonal));
            }
            prev=curr;
        }
        int mini=Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            mini = Math.min(mini, prev[j]);
        }
        return mini;
    }
    public static int tabulation(int[][] matrix)
    {
        int n=matrix.length;
        int m=matrix[0].length;
        int[][] dp=new int[n][m];
        //Initialize the first row of  dp with values from the matrix
        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j];
        }
        for(int i=1;i<n;i++)
            for(int j=0;j<m;j++)
            {
                int up=matrix[i][j]+dp[i-1][j];
                int leftDiagonal=matrix[i][j];
                if(j-1>=0)
                    leftDiagonal+=dp[i-1][j-1];
                else
                    leftDiagonal=Integer.MAX_VALUE;
                int rightDiagonal=matrix[i][j];
                if(j+1<m)
                    rightDiagonal+=dp[i-1][j+1];
                else
                    rightDiagonal=Integer.MAX_VALUE;
                dp[i][j]=Math.min(up,Math.min(leftDiagonal,rightDiagonal));
            }
        int mini=Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            mini = Math.min(mini, dp[n - 1][j]);
        }
        return mini;
    }
    public static int memoizationRecur(int i, int j, int m, int[][] matrix,int[][] dp)
    {
        if(j<0 || j>=m)
            return (int)1e9;
        if(i==0) return matrix[0][j];
        if(dp[i][j]!=-1) return dp[i][j];
        // Calculate the minimum path sum by  considering three possible directions: up, left diagonal, and right diagonal
        int up=matrix[i][j]+memoizationRecur(i-1,j,m,matrix,dp);
        int leftDiagonal=matrix[i][j]+memoizationRecur(i-1,j-1,m,matrix,dp);
        int rightDiagonal=matrix[i][j]+memoizationRecur(i-1,j+1,m,matrix,dp);
        return dp[i][j]=Math.min(up,Math.min(leftDiagonal,rightDiagonal));
    }
    public static int memoization(int[][] matrix)
    {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int mini = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            int ans = memoizationRecur(n - 1, j, m, matrix, dp);
            mini = Math.min(mini, ans);
        }
        return mini;
    }
    public static int recursionRecur(int i, int j, int m, int[][] matrix)
    {
        if(j<0 || j>=m)
            return (int)1e9;
        if(i==0) return matrix[0][j];
        // Calculate the minimum path sum by  considering three possible directions: up, left diagonal, and right diagonal
        int up=matrix[i][j]+recursionRecur(i-1,j,m,matrix);
        int leftDiagonal=matrix[i][j]+recursionRecur(i-1,j-1,m,matrix);
        int rightDiagonal=matrix[i][j]+recursionRecur(i-1,j+1,m,matrix);
        return Math.min(up,Math.min(leftDiagonal,rightDiagonal));
    }
    public static int recursion(int[][] matrix)
    {
        int n = matrix.length;
        int m = matrix[0].length;
        int mini = Integer.MAX_VALUE;
        //Iterate through each cell in the first row to find minimum path sum starting from each of them
        for(int j=0;j<m;j++)
        {
            int ans=recursionRecur(n-1,j,m,matrix);
            mini=Math.min(mini,ans);
        }
        return mini;
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 10, 4},
                {100, 3, 2, 1},
                {1, 1, 20, 2},
                {1, 2, 2, 1}
        };
        System.out.println(optimal(matrix));
    }
}
