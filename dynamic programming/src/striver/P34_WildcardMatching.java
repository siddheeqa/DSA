package striver;

public class P34_WildcardMatching {
    private static boolean isAllStars(String S1, int i) {
        for (int j = 0; j <= i; j++) {
            if (S1.charAt(j) != '*')
                return false;
        }
        return true;
    }
        public static boolean optimal(String str, String pat) {
            int n = str.length();
            int m = pat.length();

            // dp[j] = true if pat[0..i-1] matches str[0..j-1]
            boolean[] dp = new boolean[n + 1];

            // Base Case: empty pattern matches empty string
            dp[0] = true;

            for (int i = 1; i <= m; i++) {
                // Store previous row's values temporarily
                boolean[] temp = new boolean[n + 1];

                // Base Case: pattern vs empty string
                temp[0] = (pat.charAt(i - 1) == '*') && dp[0];

                for (int j = 1; j <= n; j++) {
                    // If characters match or pattern has '?'
                    if (pat.charAt(i - 1) == str.charAt(j - 1) || pat.charAt(i - 1) == '?')
                        temp[j] = dp[j - 1];
                        // If pattern has '*'
                    else if (pat.charAt(i - 1) == '*')
                        temp[j] = dp[j] || temp[j - 1];
                    else
                        temp[j] = false;
                }

                // Move temp to dp for next iteration
                dp = temp;
            }

            // Answer is in dp[n]
            return dp[n];
        }
    public static boolean tabulation(String str, String pat) {
        int n = str.length();
        int m = pat.length();

        // dp[i][j] = true if pat[0..i-1] matches str[0..j-1]
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Base Case: empty pattern matches empty string
        dp[0][0] = true;

        // Base Case: pattern vs empty string
        for(int i=1;i<=m;i++)
            dp[i][0] = (pat.charAt(i-1)=='*') && dp[i-1][0];

        // Fill the dp table
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                // If characters match or pattern has '?'
                if(pat.charAt(i-1)==str.charAt(j-1) || pat.charAt(i-1)=='?')
                    dp[i][j] = dp[i-1][j-1];
                    // If pattern has '*'
                else if(pat.charAt(i-1)=='*')
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                else
                    dp[i][j] = false;
            }
        }

        // Answer is in dp[m][n]
        return dp[m][n];
}
    public static boolean memoizationRecur(String s1, String s2, int i, int j, int[][] dp)
    {
        if(i<0 && j<0) return true;
        if(i<0 && j>=0) return false;
        if(j<0 && i>=0) return isAllStars(s1,i);

        if(dp[i][j]!=-1)
            return dp[i][j]==1;

    /* If the characters at the current
    positions match or S1 has a '?'*/
        if(s1.charAt(i)==s2.charAt(j) || s1.charAt(i)=='?')
            dp[i][j] = memoizationRecur(s1,s2,i-1,j-1,dp)?1:0;
    /* Two options: either '*' represents an
            empty string or it matches a character in S2*/
        else if(s1.charAt(i)=='*')
            dp[i][j] = (memoizationRecur(s1,s2,i-1,j,dp) || memoizationRecur(s1,s2,i,j-1,dp))?1:0;
        else
            dp[i][j] = 0;

        return dp[i][j]==1;
    }
    public static boolean memoization(String str, String pat)
    {
        int n = str.length();
        int m = pat.length();

        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = -1;
            }
        }
        return memoizationRecur(pat, str, m - 1, n - 1, dp);
    }
    public static boolean recursionRecur(String s1, String s2, int i, int j)
    {
        if(i<0 && j<0) return true;
        if(i<0 && j>=0) return false;
        if(j<0 && i>=0) return isAllStars(s1,i);
        /* If the characters at the current
        positions match or S1 has a '?'*/
        if(s1.charAt(i)==s2.charAt(j) || s1.charAt(i)=='?')
            return recursionRecur(s1,s2,i-1,j-1);
        /* Two options: either '*' represents an
                empty string or it matches a character in S2*/
        if(s1.charAt(i)=='*')
            return recursionRecur(s1,s2,i-1,j)|| recursionRecur(s1,s2,i,j-1);
        return false;
    }
    public static boolean recursion(String str, String pat)
    {
        int n = str.length();
        int m = pat.length();

        return recursionRecur(pat, str, m - 1, n - 1);
    }
    public static void main(String[] args) {
        String S1 = "?*?d*j";
        String S2 = "mayfojkazdpj";
        if (optimal(S2, S1)) {
            System.out.print("String S1 and S2 do match");
        } else {
            System.out.print("String S1 and S2 do not match");
        }
    }
}
