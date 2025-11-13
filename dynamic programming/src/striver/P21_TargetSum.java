package striver;

public class P21_TargetSum {
    public static int optimal(int n, int target, int[] nums)
    {
        int totSum = 0;
        for (int i = 0; i < n; i++) totSum += nums[i];

        // Not possible to achieve the target sum
        if (totSum - target < 0) return 0;
        // Difference must be even
        if ((totSum - target) % 2 == 1) return 0;

        int s2 = (totSum - target) / 2;

        int[] dp = new int[s2 + 1];

        // Base case for the first element
        if (nums[0] == 0) dp[0] = 2; // include or exclude 0
        else dp[0] = 1;

        if (nums[0] != 0 && nums[0] <= s2) dp[nums[0]] = 1;

        // Fill the DP array
        for (int ind = 1; ind < n; ind++) {
            // iterate targetSum in reverse to avoid reuse of same element
            for (int targetSum = s2; targetSum >= 0; targetSum--) {
                int take = 0;
                if (nums[ind] <= targetSum) take = dp[targetSum - nums[ind]];
                dp[targetSum] = (dp[targetSum] + take) % MOD;
            }
        }

        return dp[s2];
    }
    public static int tabulation(int n, int target, int[] nums)
    {
        int totSum = 0;
        for (int i = 0; i < n; i++) totSum += nums[i];

        // Not possible to achieve the target sum
        if (totSum - target < 0) return 0;
        // Difference must be even
        if ((totSum - target) % 2 == 1) return 0;

        int s2 = (totSum - target) / 2;

        // dp[i][j] = number of ways to make sum j using first i elements
        int[][] dp = new int[n][s2 + 1];

        // Base case for the first element
        if (nums[0] == 0) dp[0][0] = 2; // include or exclude 0
        else dp[0][0] = 1;               // sum 0 is possible by excluding

        if (nums[0] != 0 && nums[0] <= s2) dp[0][nums[0]] = 1;

        // Fill the DP table
        for (int ind = 1; ind < n; ind++) {
            for (int targetSum = 0; targetSum <= s2; targetSum++) {
                // not take current element
                int notTake = dp[ind - 1][targetSum];
                // take current element
                int take = 0;
                if (nums[ind] <= targetSum) take = dp[ind - 1][targetSum - nums[ind]];

                dp[ind][targetSum] = (notTake + take) % MOD;
            }
        }

        return dp[n - 1][s2];
    }
    public static int memoization(int n, int target, int[] nums) {
        int totSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totSum += nums[i];
        }
        // Not possible to achieve the target sum
        if (totSum - target < 0)
            return 0;
        /* The difference between the total
        sum and target sum must be even */
        if ((totSum - target) % 2 == 1)
            return 0;

        // Calculate the required sum for each subset
        int s2 = (totSum - target) / 2;

        // Initialize DP array with -1
        int[][] dp = new int[n][s2 + 1];
        for (int i = 0; i < n; i++)
            for (int j = 0; j <= s2; j++)
                dp[i][j] = -1;

        // Return the memoized result
        return memoizationRecur(n - 1, s2, nums, dp);
    }

    public static int memoizationRecur(int ind, int target, int[] arr, int[][] dp) {
        if(ind == 0) {
            if(target == 0 && arr[0] == 0) return 2; // include or exclude 0
            if(target == 0 || arr[0] == target) return 1;
            return 0;
        }

        // If already computed, return the stored value
        if (dp[ind][target] != -1) return dp[ind][target];

        // not take current element
        int notTake = memoizationRecur(ind - 1, target, arr, dp);
        // take current element
        int take = 0;
        if (arr[ind] <= target) take = memoizationRecur(ind - 1, target - arr[ind], arr, dp);

        // Store and return the result
        return dp[ind][target] = (notTake + take) % MOD;
    }

    private static final int MOD = 1000000007;
    public static int recursionRecur(int ind,  int target,int[] arr)
    {

        if(ind == 0) {
            if(target == 0 && arr[0] == 0) return 2; // include or exclude 0
            if(target == 0 || arr[0] == target) return 1;
            return 0;
        }

        // not take current element
        int notTake = recursionRecur(ind-1, target,arr);
        // take current element
        int take = 0;
        if(arr[ind]<=target) take = recursionRecur(ind-1, target-arr[ind],arr);
        return (notTake + take) % MOD;
    }
    public static int recursion(int n, int target, int[] nums)
    {
        int totSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totSum += nums[i];
        }
        // Not possible to achieve the target sum
        if (totSum - target < 0)
            return 0;
        /* The difference between the total
        sum and target sum must be even */
        if ((totSum - target) % 2 == 1)
            return 0;

        // Calculate the required sum for each subset
        int s2 = (totSum - target) / 2;

        // Return the result
        return recursionRecur(n - 1, s2, nums);
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int target = 3;
        int n = nums.length;
        System.out.println("The total number of ways is " + optimal(n, target, nums));
    }
}
