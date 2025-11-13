package striver;

import java.util.Arrays;

public class P11_MinimumPathSumTriangle {
    public static int optimal(int[][] triangle)
    {
        int n = triangle.length;
        // Represents the previous row
        int[] front = new int[n];
        // Initialize the front array with values
        for(int j=0;j<n;j++) {
            front[j]= triangle[n - 1][j];
        }
        //Iterate through the triangle rows in reverse order
        for(int i=n-2;i>=0;i--) {
            // Represents the current row
            int[] curr=new int[n];
            for (int j = i; j >= 0; j--) {
                int down = triangle[i][j] + front[j];
                int diagonal = triangle[i][j] + front[j + 1];
                curr[j] = Math.min(down, diagonal);
            }
            front=curr;
        }
        return front[0];
    }
    public static int tabulation(int[][] triangle)
    {
        int n = triangle.length;
        int[][] dp = new int[n][n];
        for(int j=0;j<n;j++) {
            dp[n - 1][j] = triangle[n - 1][j];
        }
        //Iterate through the triangle rows in reverse order
        for(int i=n-2;i>=0;i--)
            for(int j=i;j>=0;j--)
            {
                int down=triangle[i][j]+dp[i+1][j];
                int diagonal=triangle[i][j]+dp[i+1][j+1];
                dp[i][j]=Math.min(down,diagonal);
            }
        return dp[0][0];
    }
    public static int memoizationRecur(int i, int j, int[][] triangle, int n, int[][] dp){
        if(dp[i][j]!=-1)
            return dp[i][j];
        if(i==n-1)
            return triangle[i][j];
        int down=triangle[i][j]+memoizationRecur(i+1,j,triangle,n,dp);
        int diagonal=triangle[i][j]+memoizationRecur(i+1,j+1,triangle,n,dp);
        return dp[i][j]=Math.min(down,diagonal);
    }
    public static int memoization(int[][] triangle)
    {
        int n = triangle.length;
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return memoizationRecur(0, 0, triangle, n, dp);
    }
    public static int recursionRecur(int i, int j, int[][] triangle, int n)
    {
        //if we are at bottom row, return value of current cell
        if(i==n-1)
            return triangle[i][j];
        // Calculate the sum of two possible paths
        int down=triangle[i][j]+recursionRecur(i+1,j,triangle,n);
        int diagonal=triangle[i][j]+recursionRecur(i+1,j+1,triangle,n);
        return Math.min(down,diagonal);
    }
    public static int recursion(int[][] triangle)
    {
        int n=triangle.length;
            //single starting point variable ending point, so we start recursion from (0,0)
            return recursionRecur(0,0,triangle,n);
    }

    public static void main(String[] args) {
        int[][] triangle = {{1},
                {2, 3},
                {3, 6, 7},
                {8, 9, 6, 10}};
        System.out.println("Minimum path sum in triangle: " + optimal(triangle));
    }
}
