package striver;

public class P25_LongestCommonSubsequences {
    public static int optimal(String str1, String str2)
    {
        int n=str1.length();
        int m=str2.length();
        int[] prev=new int[m+1];
        for(int ind1=1;ind1<=n;ind1++)
        {
            int[] curr=new int[m+1];
            for(int ind2=1;ind2<=m;ind2++)
            {
                if(str1.charAt(ind1-1)==str2.charAt(ind2-1))
                    curr[ind2]=1+prev[ind2-1];
                else
                    curr[ind2]=Math.max(prev[ind2],curr[ind2-1]);
            }
            prev=curr;
        }
        return prev[m];
    }

    public static int tabulation(String str1, String str2)
    {
        int n=str1.length();
        int m=str2.length();
        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++)
        {
            dp[i][0]=0;
        }
        for(int i=0;i<=m;i++)
            dp[0][i]=0;
        for(int ind1=1;ind1<=n;ind1++)
            for(int ind2=1;ind2<=m;ind2++)
            {
                if(str1.charAt(ind1-1)==str2.charAt(ind2-1))
                    dp[ind1][ind2]=1+dp[ind1-1][ind2-1];
                else
                    dp[ind1][ind2]=Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
            }
        return dp[n][m];
    }
    public static int memoizationRecur(String s1,String s2,int ind1,int ind2,int[][] dp)
    {
        if(ind1<0 || ind2<0) return 0;
        if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];
        /* If the characters at the current
        indices match, increment the LCS length*/
        if(s1.charAt(ind1)==s2.charAt(ind2))
            return dp[ind1][ind2]=1+memoizationRecur(s1,s2,ind1-1,ind2-1,dp);
        else
            return dp[ind1][ind2]=Math.max(memoizationRecur(s1,s2,ind1-1,ind2,dp),
                    memoizationRecur(s1,s2,ind1,ind2-1,dp));
    }
    public static int memoization(String str1, String str2)
    {
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                dp[i][j]=-1;
        return memoizationRecur(str1,str2,n-1,m-1,dp);
    }

    public static int recursionRecur(String s1,String s2,int ind1,int ind2)
    {
        if(ind1<0 || ind2<0) return 0;
        /* If the characters at the current
        indices match, increment the LCS length*/
        if(s1.charAt(ind1)==s2.charAt(ind2))
            return 1+recursionRecur(s1,s2,ind1-1,ind2-1);
        else
            return Math.max(recursionRecur(s1,s2,ind1-1,ind2),recursionRecur(s1,s2,ind1,ind2-1));
    }
    public static int recursion(String str1, String str2)
    {
        int n = str1.length();
        int m = str2.length();
        return recursionRecur(str1,str2,n-1,m-1);
    }
    public static void main(String[] args) {
        String s1 = "acd";
        String s2 = "ced";
        System.out.println("The Length of Longest Common Subsequence is " + optimal(s1, s2));
    }
}
