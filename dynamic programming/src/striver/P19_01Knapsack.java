package striver;

public class P19_01Knapsack {
    public static int optimal(int w,int wt[],int val[],int n)
    {
        int[] prev=new int[w+1];
        // Base case: fill for index 0
        for(int j=wt[0];j<=w;j++)
            prev[j]=val[0];
        // Iterate over items
        for(int ind=1;ind<n;ind++)
        {
            int[] cur=new int[w+1];
            for(int cap=0;cap<=w;cap++)
            {
                // Option 1: Do not take the item
                int notTake=prev[cap];
                // Option 2: Take the item (if possible)
                int take=Integer.MIN_VALUE;
                if(wt[ind]<=cap)
                    take=val[ind]+prev[cap-wt[ind]];
                cur[cap]=Math.max(take,notTake);
            }
            prev=cur;
        }
        return prev[w];
    }

    public static int tabulation(int w,int wt[],int val[],int n)
    {
        int[][] dp=new int[n][w+1];
        // Base case: fill for index 0
        for(int j=wt[0];j<=w;j++)
            dp[0][j]=val[0];
        // Fill the DP table for rest of the items
        for(int ind=1;ind<n;ind++)
        {
            for(int cap=0;cap<=w;cap++)
            {
                // Option 1: Do not take the item
                int notTake=dp[ind-1][cap];
                // Option 2: Take the item (if possible)
                int take=Integer.MIN_VALUE;
                if(wt[ind]<=cap)
                    take=val[ind]+dp[ind-1][cap-wt[ind]];
                dp[ind][cap]=Math.max(take,notTake);
            }
        }
        return dp[n-1][w];
    }

    public static int memoization(int w,int wt[],int val[],int n)
    {
        int[][] dp=new int[n][w+1];
        for(int i=0;i<n;i++)
            for(int j=0;j<=w;j++)
                dp[i][j]=-1;
        return memoizationRecur(n-1,w,wt,val,dp);
    }
    public static int memoizationRecur(int ind,int w,int[] wt,int[] val,int[][] dp)
    {
        // Base case: if we are at index 0
        if(ind==0)
        {
            if(wt[0]<=w) return val[0];
            else return 0;
        }
        if(dp[ind][w]!=-1) return dp[ind][w];
        // Option 1: Do not take the item
        int notTake=memoizationRecur(ind-1,w,wt,val,dp);
        // Option 2: Take the item (if possible)
        int take=Integer.MIN_VALUE;
        if(wt[ind]<=w)
            take=val[ind]+memoizationRecur(ind-1,w-wt[ind],wt,val,dp);
        return dp[ind][w]=Math.max(take,notTake);
    }

    public static int recursionRecur(int ind,int w,int[] wt,int[] val)
    {
        // Base case: if we are at index 0
        if(ind==0)
        {
            if(wt[0]<=w) return val[0];
            else return 0;
        }
        //Option 1: Do not take the item
        int notTake=recursionRecur(ind-1,w,wt,val);
        // Option 2: Take the item (if possible)
        int take=Integer.MIN_VALUE;
        if(wt[ind]<=w)
            take=val[ind]+recursionRecur(ind-1,w-wt[ind],wt,val);
        return Math.max(take,notTake);
    }
    public static int recursion(int w, int wt[], int val[], int n)
    {
        return recursionRecur(n-1,w,wt,val);
    }
    public static void main(String[] args) {
        int val[] = {60, 100, 120};
        int wt[] = {10, 20, 30};
        int W = 50;
        int n = val.length;

        System.out.println("Maximum value: " + optimal(W, wt, val, n));
    }
}
