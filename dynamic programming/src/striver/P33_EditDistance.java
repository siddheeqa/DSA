package striver;

public class P33_EditDistance {
    public int optimal(String start, String target) {
        int n = start.length();  // Length of start string
        int m = target.length(); // Length of target string

        // prev[] will represent the previous row
        // cur[] will represent the current row
        int[] prev=new int[m+1];
        int[] cur=new int[m+1];

        // Base case: transforming "" into target[0..j]
        for(int j=0;j<=m;j++)
            prev[j]=j;

        // Build the dp row by row
        for(int i=1;i<=n;i++)
        {
            // Base case: transforming start[0..i] into ""
            cur[0]=i;

            for(int j=1;j<=m;j++)
            {
                // If characters match, take diagonal value (no extra cost)
                if(start.charAt(i-1)==target.charAt(j-1))
                    cur[j]=prev[j-1];
                    // Else take 1 + minimum of replace, delete, insert
                else
                    cur[j]=1+Math.min(prev[j-1],
                            Math.min(prev[j],cur[j-1]));
            }

            // Copy current row into previous for next iteration
            for(int j=0;j<=m;j++)
                prev[j]=cur[j];
        }

        // Answer is in prev[m]
        return prev[m];
    }
    public static int tabulation(String start, String target)
    {
        int n=start.length();
        int m=target.length();
        //dp[i][j] will store the minimum operations
        //to convert start[0..i-1] to target[0..j-1]
        int[][] dp=new int[n+1][m+1];

        //if target is empty, we need i deletions
        for(int i=0;i<=n;i++)
            dp[i][0]=i;
        //if start is empty, we need j insertions
        for(int j=0;j<=m;j++)
            dp[0][j]=j;

        //fill the dp table
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                //if characters match, no extra operation
                if(start.charAt(i-1)==target.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1];
                    //else take minimum of replace, delete, insert
                else
                    dp[i][j]=1+Math.min(dp[i-1][j-1],
                            Math.min(dp[i-1][j],dp[i][j-1]));
            }
        }
        //answer is in dp[n][m]
        return dp[n][m];
    }

    public static int memoizationRecur(String s1, String s2, int i, int j, int[][] dp)
    {
        //insertions
        if(i<0)
            return j+1;
        //deletions
        if(j<0)
            return i+1;
        //already computed
        if(dp[i][j]!=-1)
            return dp[i][j];
        /* If the characters at the current
        positions match, no operation is needed*/
        if(s1.charAt(i)==s2.charAt(j))
            return dp[i][j]=memoizationRecur(s1,s2,i-1,j-1,dp);
        else
            return dp[i][j]=1+Math.min(memoizationRecur(s1,s2,i-1,j-1,dp),
                    Math.min(memoizationRecur(s1,s2,i-1,j,dp),
                            memoizationRecur(s1,s2,i,j-1,dp)));
    }

    public static int memoization(String start, String target)
    {
        int n=start.length();
        int m=target.length();
        int[][] dp=new int[n][m];
        for(int a=0;a<n;a++)
        {
            for(int b=0;b<m;b++)
            {
                dp[a][b]=-1;
            }
        }
        return memoizationRecur(start,target,n-1,m-1,dp);
    }
    public static int recursionRecur(String s1, String s2, int i, int j)
    {
        //insertions
        if(i<0)
            return j+1;
        //deletions
        if(j<0)
            return i+1;
        /* If the characters at the current
        positions match, no operation is needed*/
        if(s1.charAt(i)==s2.charAt(j)) return recursionRecur(s1,s2,i-1,j-1);
        else return 1+Math.min(recursionRecur(s1,s2,i-1,j-1),Math.min(recursionRecur(s1,s2,i-1,j),recursionRecur(s1,s2,i,j-1)));
    }
    public static int recursion(String start, String target)
    {
        int n=start.length();
        int m=target.length();
        return recursionRecur(start,target,n-1,m-1);
    }
    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";
        System.out.println("The minimum number of operations required is: " + memoization(s1, s2));
    }
}
