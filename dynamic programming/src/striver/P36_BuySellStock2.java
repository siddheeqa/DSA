package striver;

public class P36_BuySellStock2 {
    public static int optimal(int[] arr, int n)
    {
        /* Declare two arrays to store the profits ahead of
        current position (0 for not holding, 1 for holding)*/
        int[] ahead = new int[2];
        int[] cur = new int[2];

        // Base condition
        ahead[0] = ahead[1] = 0;

        int profit = 0;

        // Loop through the array in reverse order
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                // We can buy the stock
                if (buy == 0) {
                    profit = Math.max(0 + ahead[0], (-1)*arr[ind] + ahead[1]);
                }
                // We can sell the stock
                if (buy == 1) {
                    profit = Math.max(0 + ahead[1], arr[ind] + ahead[0]);
                }
                cur[buy] = profit;
            }
            // Update the "ahead" array with the current values
            ahead = cur;
        }

        // Maximum profit is stored in cur[0]
        return cur[0];
    }
    public static int tabulation(int[] arr, int n)
    {
        // Create a DP table to memoize results
        int[][] dp = new int[n + 1][2];

        // Base condition
        dp[n][0] = dp[n][1] = 0;

        int profit = 0;

        // Loop through the array in reverse order
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                // We can buy the stock
                if (buy == 0) {
                    profit = Math.max(dp[ind + 1][0], (-1)*arr[ind] + dp[ind + 1][1]);
                }

                // We can sell the stock
                if (buy == 1) {
                    profit = Math.max(dp[ind + 1][1], arr[ind] + dp[ind + 1][0]);
                }

                dp[ind][buy] = profit;
            }
        }

        /* The maximum profit is stored in
        dp[0][0] after all calculations*/
        return dp[0][0];
    }
    public static int memoizationRecur(int ind, int buy, int n, int[] arr, int[][] dp)
    {
        if(ind==n) return 0;

        if(dp[ind][buy]!=-1) return dp[ind][buy];

        int profit=0;

        // we can buy the stock
        if(buy==0)
            profit = Math.max(memoizationRecur(ind+1,0,n,arr,dp),
                    -arr[ind]+memoizationRecur(ind+1,1,n,arr,dp));

        // we can sell the stock
        if(buy==1)
            profit = Math.max(memoizationRecur(ind+1,1,n,arr,dp),
                    arr[ind]+memoizationRecur(ind+1,0,n,arr,dp));

        return dp[ind][buy] = profit;
    }

    public static int memoization(int[] arr, int n)
    {
        if(n==0) return 0;

        int[][] dp = new int[n][2];
        for(int i=0;i<n;i++){
            dp[i][0] = -1;
            dp[i][1] = -1;
        }

        int ans = memoizationRecur(0,0,n,arr,dp);
        return ans;
    }

    public static int recursionRecur(int ind,int buy,int n,int[] arr)
    {
        if(ind==n) return 0;
        int profit=0;
        //we can buy the stock
        if(buy==0)
            profit=Math.max(recursionRecur(ind+1,0,n,arr),-arr[ind]+recursionRecur(ind+1,1,n,arr));
        if(buy==1)
            profit=Math.max(recursionRecur(ind+1,1,n,arr),arr[ind]+recursionRecur(ind+1,0,n,arr));
        return profit;
    }
    public static int recursion(int[]arr, int n)
    {
        if (n == 0)
            return 0;
        int ans = recursionRecur(0, 0, n, arr);
        return ans;
    }
    public static void main(String[] args) {
        int n = 6;
        int[] arr = {7, 1, 5, 3, 6, 4};
        System.out.println("The maximum profit that can be generated is " + recursion(arr, n));
    }
}
