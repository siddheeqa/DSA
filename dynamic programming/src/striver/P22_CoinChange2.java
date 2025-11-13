package striver;

public class P22_CoinChange2 {
    private static int MOD = (int)1e9 + 7;
    public static int optimal(int[] coins,int n,int amount)
    {
        long[] dp=new long[amount+1];
        for(int i=0;i<=amount;i++)
        {
            if(i%coins[0]==0)
                dp[i]=1;
        }
        for(int ind=1;ind<n;ind++)
            for(int target=coins[ind];target<=amount;target++)
            {
                dp[target]=(dp[target]+dp[target-coins[ind]])%MOD;
            }
        return (int)dp[amount];
    }
    public static int tabulation(int[] coins,int n,int amount)
    {
        long[][] dp=new long[n][amount+1];
        for(int i=0;i<=amount;i++)
        {
            if(i%coins[0]==0)
                dp[0][i]=1;
        }
        for(int ind=1;ind<n;ind++)
            for(int target=0;target<=amount;target++)
            {
                int notTake=(int)dp[ind-1][target];
                int taken=0;
                if (coins[ind] <= target)
                    taken = (int)dp[ind][target - coins[ind]];

                dp[ind][target] = (notTake + taken) % MOD;
            }
        return (int)dp[n-1][amount];
    }
    public static int memoizationRecur(int[] coins,int ind,int target,int[][] dp)
    {
        if(ind==0)
        {
            return target%coins[0]==0?1:0;
        }

        if(dp[ind][target]!=-1) return dp[ind][target];

        int notTake=memoizationRecur(coins,ind-1,target,dp);
        int take=0;
        if(coins[ind]<=target)
            take=memoizationRecur(coins,ind,target-coins[ind],dp);

        return dp[ind][target]=(notTake+take)%MOD;
    }

    public static int memoization(int[] coins,int n,int amount)
    {
        int[][] dp=new int[n][amount+1];
        for(int i=0;i<n;i++)
            for(int j=0;j<=amount;j++)
                dp[i][j]=-1;

        return memoizationRecur(coins,n-1,amount,dp);
    }

    public static int recursionRecur(int[] coins,int ind,int target)
    {
        if(ind==0)
        {
            return target%coins[0]==0?1:0;
        }
        int notTake=recursionRecur(coins,ind-1,target);
        int take=0;
        if(coins[ind]<=target)
            take=recursionRecur(coins,ind,target-coins[ind]);
        return (notTake+take)%MOD;
    }
    public static int recursion(int[] coins,int n,int amount)
    {
        return recursionRecur(coins,n-1,amount);
    }
    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int amount = 4;
        int N = coins.length;
        System.out.println("The total number of ways is " + optimal(coins, N, amount));
    }
}
