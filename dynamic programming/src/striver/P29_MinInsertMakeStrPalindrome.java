package striver;

public class P29_MinInsertMakeStrPalindrome {
    public static int tabulationLinear(String str1,String str2)
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
    public static int tabulation(String s) {
        // Store a reversed copy of the string
        String t = new StringBuilder(s).reverse().toString();

        /* Call the LCS function to find the
        length of the Longest Common Subsequence */
        return tabulationLinear(s, t);
    }
    public static int minInsertion(String s)
    {
        int n = s.length();
        int k = tabulation(s);
        /* The minimum insertions required is the
        difference between the string length and
        its longest palindromic subsequence length*/
        return n - k;
    }
    public static void main(String[] args) {
        String s = "abcaa";
        System.out.println("The Minimum insertions required to make string palindrome: " + minInsertion(s));
    }
}
