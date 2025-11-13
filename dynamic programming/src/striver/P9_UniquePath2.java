package striver;
import java.util.Arrays;

public class P9_UniquePath2 {
    public static int memoizationRecur(int i,int j,int[][] matrix,int[][] dp)
    {
        if(i>=0 && j>=0 && matrix[i][j]==1) return 0;
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int up=memoizationRecur(i-1,j,matrix,dp);
        int left=memoizationRecur(i,j-1,matrix,dp);
        return dp[i][j]=up+left;
    }
    public static int memoization(int m,int n,int[][] matrix)
    {
        int[][] dp=new int[m+1][n+1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return memoizationRecur(m,n,matrix,dp);
    }
    public static int recursion(int i,int j,int[][] matrix)
    {
        if(i>=0 && j>=0 && matrix[i][j]==1) return 0;
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;
        int up=recursion(i-1,j,matrix);
        int left=recursion(i,j-1,matrix);
        return up+left;
    }
    public static void main(String[] args) {
        int[][] maze = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        int m= maze.length;
        int n= maze[0].length;
        System.out.println("Number of paths with obstacles: " + memoization(m-1,n-1,maze));
    }
}
