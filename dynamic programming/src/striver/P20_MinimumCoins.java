package striver;

public class P20_MinimumCoins {
    public static int optimal(int[] coins,int amount)
    {
        int n=coins.length;
        int[] dp=new int[amount+1];

        // Base case: fill for index 0
        for(int i=0;i<=amount;i++)
        {
            if(i%coins[0]==0)
                dp[i]=i/coins[0];
            else
                dp[i]=(int)1e9;
        }

        // Iterate over remaining coins
        for(int ind=1;ind<n;ind++)
        {
            int[] cur=new int[amount+1];
            for(int target=0;target<=amount;target++)
            {
                int notTake=dp[target];
                int take=(int)1e9;
                if(coins[ind]<=target)
                {
                    take=1+cur[target-coins[ind]];
                }
                cur[target]=Math.min(notTake,take);
            }
            dp=cur;
        }

        // The answer is in dp[amount]
        int ans=dp[amount];
        if(ans>=(int)1e9) return -1;
        return ans;
    }
    public static int tabulation(int[] coins,int amount)
    {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for(int i=0;i<=amount;i++)
        {
            if(i%coins[0]==0)
                dp[0][i]=i/coins[0];
            else
                dp[0][i]=(int)1e9;
        }
        for(int ind=1;ind<n;ind++)
        {
            for(int target=0;target<=amount;target++)
            {
                int notTake=dp[ind-1][target];
                int take=(int)1e9;
                if(coins[ind]<=target)
                {
                    take=1+dp[ind][target-coins[ind]];
                }
                dp[ind][target]=Math.min(notTake,take);
            }
        }
        //The answer is in the bottom-right cell
        int ans=dp[n-1][amount];
        if(ans>=(int)1e9) return -1;
        return ans;
    }
    public static int memoizationRecur(int[] coins,int ind,int target,int[][] dp)
    {
        // Base case: If we're at the first element
        if(ind==0)
        {
            // Check if the target sum is divisible by the first element
            if(target%coins[0]==0)
                return target/coins[0];
                // Otherwise, return a very large value to indicate it's not possible
            else
                return (int)1e9;
        }

        // If already computed, return the stored value
        if(dp[ind][target]!=-1) return dp[ind][target];

        // Calculate the minimum elements needed without taking the current element
        int notTake=memoizationRecur(coins,ind-1,target,dp);

        // Calculate the minimum elements needed by taking the current element
        int take=(int)1e9;
        if(coins[ind]<=target)
        {
            take=1+memoizationRecur(coins,ind,target-coins[ind],dp);
        }

        // Store and return the result
        return dp[ind][target]=Math.min(notTake,take);
    }

    public static int memoization(int[] coins,int amount)
    {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for(int i=0;i<n;i++)
            for(int j=0;j<=amount;j++)
                dp[i][j]=-1;
        int ans=memoizationRecur(coins,n-1,amount,dp);

        // If 'ans' is still very large, it means it's not possible to form the target sum
        if(ans>=(int)1e9)
            return -1;

        return ans;
    }

    public static int recursionRecur(int[] coins,int ind,int target)
    {
        // Base case: If we're at the first element
        if(ind==0)
        {
            //Check if the target sum is divisible by the first element
            if(target%coins[0]==0)
                return target/coins[0];

                //Otherwise, return a very large value to indicate it's not possible
            else
                return (int)1e9;
        }
        // Calculate the minimum elements needed without taking the current element
        int notTake=recursionRecur(coins,ind-1,target);
        int take=(int)1e9;
        if(coins[ind]<=target)
        {
            take=1+recursionRecur(coins,ind,target-coins[ind]);
        }
        return Math.min(notTake,take);
    }
    public static int recursion(int[] coins, int amount)
    {
        int n= coins.length;
        int ans=recursionRecur(coins,n-1,amount);
        //If 'ans' is still very large, it means  it's not possible to form the target sum
        if(ans>=(int)1e9)
            return -1;
        return ans;
    }
    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int amount = 7;
        System.out.println("The total number of ways is " + tabulation(coins, amount));
    }
}
