package striver;

public class P26_PrintLCS {
    public static String func(String str1, String str2) {
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
        int len=dp[n][m];
        char[] lcs=new char[len];
        int i=n,j=m;
        while (i>0 && j>0)
        {
            if(str1.charAt(i-1)==str2.charAt(j-1))
            {
                lcs[len-1]=str1.charAt(i-1);
                i--;
                j--;
                len--;
            }
            else if(dp[i-1][j]>dp[i][j-1])
                i--;
            else
                j--;
        }
        return new String(lcs);
    }
    public static void main(String[] args) {
        System.out.println(func("abcde","ace"));  // Output: "ace"
    }
}
