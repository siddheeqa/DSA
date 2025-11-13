package striver;

import java.util.Arrays;

public class P10_MinimumPathSum {
    public static int optimal(int m,int n,int[][] matrix)
    {
        int[] prev=new int[n];
        for(int i=0;i<m;i++) {
            int[] temp=new int[n];
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    temp[j]=matrix[i][j];
                else
                {
                    int up = matrix[i][j];
                    if (i > 0)
                        up += prev[j];
                    else
                        up += (int) Math.pow(10, 9);//Add a large value if out of bounds in the up direction
                    int left = matrix[i][j];
                    if (j > 0) left += temp[j-1];
                    else left += (int) Math.pow(10, 9);
                    temp[j] = Math.min(up, left);
                }
            }
            prev=temp;
        }
        return prev[n-1];
    }
    public static int tabulation(int m,int n,int[][] matrix)
    {
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
            {
                if(i==0 && j==0)
                    dp[i][j]=matrix[i][j];
                else
                {
                    int up=matrix[i][j];
                    if(i>0)
                        up+=dp[i-1][j];
                    else
                        up+=(int)Math.pow(10,9);//Add a large value if out of bounds in the up direction
                    int left=matrix[i][j];
                    if(j>0) left+=dp[i][j-1];
                    else left+=(int)Math.pow(10,9);
                    dp[i][j]=Math.min(up,left);
                }
            }
        return dp[m-1][n-1];
    }
    public static int memorizationRecur(int i,int j,int[][] matrix,int[][] dp)
    {
        if(i==0 && j==0) return matrix[0][0];

        //Out of bounds → return large number so it won't be chosen
        if(i<0 || j<0) return (int)1e9;
        if(dp[i][j]!=-1) return dp[i][j];
        int up=matrix[i][j]+memorizationRecur(i-1,j,matrix,dp);
        int left=matrix[i][j]+memorizationRecur(i,j-1,matrix,dp);
        return dp[i][j]=Math.min(up,left);
    }
    public static int memorization(int m,int n,int[][] matrix) {
        int[][] dp = new int[m][n];
        for(int[] row:dp)
        {
            Arrays.fill(row,-1);
        }
        return memorizationRecur(m-1,n-1,matrix,dp);
    }
    public static int recursionRecur(int i,int j,int[][] matrix)
    {
        if(i==0 && j==0) return matrix[0][0];

        //Out of bounds → return large number so it won't be chosen
        if(i<0 || j<0) return (int)1e9;
        int up=matrix[i][j]+recursion(i-1,j,matrix);
        int left=matrix[i][j]+recursion(i,j-1,matrix);
        return Math.min(up,left);
    }
    public static int recursion(int m,int n,int[][] matrix)
    {
        return recursionRecur(m-1,n-1,matrix);
    }
    public static void main(String[] args) {
        int matrix[][] = {
                {5, 9, 6},
                {11, 5, 2}
        };
        int m = matrix.length;
        int n = matrix[0].length;
        System.out.println(optimal(m, n, matrix));
    }
}
