package striver;

public class P30_MinInsertDeleteToConvertStr {
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
    public static int minOperations(String str1, String str2)
    {
        int n = str1.length();
        int m = str2.length();

        /* Calculate the length of the longest
        common subsequence between str1 and str2*/
        int k = tabulation(str1, str2);

        /* Calculate the minimum operations
        required to convert str1 to str2*/
        return (n - k) + (m - k);
    }
    public static void main(String[] args) {
        String str1 = "abcd";
        String str2 = "anc";

        System.out.println("The Minimum operations required to convert str1 to str2: " + minOperations(str1, str2));
    }
}
