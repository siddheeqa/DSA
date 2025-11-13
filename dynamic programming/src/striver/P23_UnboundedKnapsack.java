package striver;

public class P23_UnboundedKnapsack {
    public static int optimal(int[] wt,int[] val,int n,int w)
    {
        int[] prev=new int[w+1];
        for(int i=wt[0];i<=w;i++)
        {
            prev[i]=(i/wt[0])*val[0];
        }
        for(int ind=1;ind<n;ind++)
        {
            int[] cur=new int[w+1];
            for(int cap=0;cap<=w;cap++)
            {
                int notTake=prev[cap];
                int take=Integer.MIN_VALUE;
                if(wt[ind]<=cap)
                    take=val[ind]+cur[cap-wt[ind]];
                cur[cap]=Math.max(notTake,take);
            }
            prev=cur;
        }
        return prev[w];
    }
    public static int tabulation(int[] wt, int[] val, int n, int w)
    {
        int[][] dp=new int[n][w+1];
        for(int i=wt[0];i<=w;i++)
        {
            dp[0][i]=(i/wt[0])*val[0];
        }
        for(int ind=1;ind<n;ind++)
        {
            for(int cap=0;cap<=w;cap++)
            {
                int notTake=dp[ind-1][cap];
                int take=Integer.MIN_VALUE;
                if(wt[ind]<=cap)
                    take=val[ind]+dp[ind][cap-wt[ind]];
                dp[ind][cap]=Math.max(notTake,take);
            }
        }
        return dp[n-1][w];
    }
    public static int memoizationRecur(int[] wt, int[] val, int ind, int w, int[][] dp)
    {
        if(ind==0)
        {
            return (w/wt[0]*val[0]);
        }
        if(dp[ind][w]!=-1) return dp[ind][w];

        int notTake=memoizationRecur(wt,val,ind-1,w,dp);
        int take=Integer.MIN_VALUE;
        if(wt[ind]<=w)
            take=val[ind]+memoizationRecur(wt,val,ind,w-wt[ind],dp);
        return dp[ind][w]=Math.max(notTake,take);
    }

    public static int memoization(int[] wt, int[] val, int n, int w)
    {
        int[][] dp=new int[n][w+1];
        for(int i=0;i<n;i++)
            for(int j=0;j<=w;j++)
                dp[i][j]=-1;
        return memoizationRecur(wt,val,n-1,w,dp);
    }
    public static int recursionRecur(int[] wt, int[] val, int ind, int w)
    {
        if(ind==0)
        {
            return (w/wt[0]*val[0]);
        }
        int notTake=recursionRecur(wt,val,ind-1,w);
        int take=Integer.MIN_VALUE;
        if(wt[ind]<=w)
            take=val[ind]+recursionRecur(wt,val,ind,w-wt[ind]);
        return Math.max(notTake,take);
    }
    public static int recursion(int[] wt, int[] val, int n, int w)
    {
        return recursionRecur(wt,val,n-1,w);
    }
    public static void main(String[] args) {
        int[] wt = {2, 4, 6};
        int[] val = {5, 11, 13};
        int W = 10;
        int n = wt.length;
        System.out.println("The Maximum value of items the thief can steal is " +optimal(wt, val, n, W));
    }
}
