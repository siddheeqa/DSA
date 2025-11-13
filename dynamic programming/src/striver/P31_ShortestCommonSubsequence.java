package striver;

public class P31_ShortestCommonSubsequence {
    public static String tabulation(String str1, String str2)
    {
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= m; i++)
            dp[0][i] = 0;
        for (int ind1 = 1; ind1 <= n; ind1++)
            for (int ind2 = 1; ind2 <= m; ind2++) {
                if (str1.charAt(ind1 - 1) == str2.charAt(ind2 - 1))
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                else
                    dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
            }
        // Reconstruct the shortest super sequence from DP table
        int len=dp[n][m];
        StringBuilder ans=new StringBuilder();
        int i=n,j=m;
        while (i>0 && j>0)
        {
            if(str1.charAt(i-1)==str2.charAt(j-1))
            {
                ans.append(str1.charAt(i-1));
                i--;
                j--;
                len--;
            }
            else if(dp[i-1][j]>dp[i][j-1]) {
                ans.append(str1.charAt(i - 1));
                i--;
            }
            else {
                ans.append(str2.charAt(j - 1));
                j--;
            }
        }
        // Add remaining characters from str1 or str2
        while (i > 0) {
            ans.append(str1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            ans.append(str2.charAt(j - 1));
            j--;
        }
        ans.reverse();
        return ans.toString();
    }
    public static void main(String[] args) {
        String s1 = "brute";
        String s2 = "groot";
        System.out.println("The Longest Common Super sequence is " + tabulation(s1, s2));
    }
}
