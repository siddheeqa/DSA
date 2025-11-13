package striver;

import java.util.Arrays;

public class P17_CountSubsetsWithSumK {
    private static final int MOD = 1000000007;
        public static int optimal(int[] arr, int K)
        {
            int n = arr.length;
            int[] prev = new int[K+1];
            prev[0] = 1;
            if(arr[0] <= K) prev[arr[0]] = 1;
            for(int ind=1; ind<n; ind++)
            {
                int[] curr = new int[K+1];
                curr[0] = 1;
                for(int target=1; target<=K; target++)
                {
                    int notTake = prev[target];
                    int take = 0;
                    if(arr[ind] <= target) take = prev[target-arr[ind]];
                    curr[target] = (notTake + take) % MOD;
                }
                prev = curr;
            }
            return prev[K];
        }
    public static int tabulation(int[] arr, int K)
    {
        int n = arr.length;
        int[][] dp = new int[n][K+1];
        // base case: sum = 0 is always 1
        for(int i=0;i<n;i++) dp[i][0] = 1;
        // base case: first element
        if(arr[0] <= K) dp[0][arr[0]] = 1;
        for(int ind=1; ind<n; ind++)
        {
            for(int target=0; target<=K; target++)
            {
                int notTake = dp[ind-1][target];
                int take = 0;
                if(arr[ind] <= target) take = dp[ind-1][target-arr[ind]];
                dp[ind][target] = (notTake + take) % MOD;
            }
        }
        return dp[n-1][K];
    }
    public static int memoizationRecur(int ind, int[] arr, int target, int[][] dp)
    {
        // base cases
        if(target==0) return 1;
        if(ind==0) return (arr[0]==target) ? 1 : 0;
        // check if already computed
        if(dp[ind][target] != -1) return dp[ind][target];
        // not take current element
        int notTake = memoizationRecur(ind-1, arr, target, dp);
        // take current element
        int take = 0;
        if(arr[ind]<=target) take = memoizationRecur(ind-1, arr, target-arr[ind], dp);
        return dp[ind][target] = (notTake + take) % MOD;
    }
    public static int memoization(int[] arr, int K)
    {
        int n = arr.length;
        int[][] dp = new int[n][K+1];
        for(int i=0;i<n;i++) Arrays.fill(dp[i], -1);

        return memoizationRecur(n-1, arr, K, dp);
    }
    public static int recursionRecur(int ind, int[] arr, int target)
    {
        if(target==0) return 1;
        if(ind==0) return (arr[0]==target) ? 1 : 0;
        // not take current element
        int notTake = recursionRecur(ind-1, arr, target);
        // take current element
        int take = 0;
        if(arr[ind]<=target) take = recursionRecur(ind-1, arr, target-arr[ind]);
        return (notTake + take) % MOD;
    }
    public static int recursion(int[] arr, int K)
    {
        int n = arr.length;
        return recursionRecur(n-1, arr, K);
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3};
        int k = 3;
        System.out.println("The number of subsets found are " + optimal(arr, k));
    }
}
