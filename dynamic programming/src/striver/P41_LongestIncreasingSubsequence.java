package striver;

public class P41_LongestIncreasingSubsequence {
    public static int memoizationRecur(int ind, int prevInd, int[] arr, int[][] dp)
    {
        if(ind == arr.length) return 0; // base case

        if(dp[ind][prevInd+1] != -1) return dp[ind][prevInd+1];

        // Not take case
        int notTake = memoizationRecur(ind+1, prevInd, arr, dp);

        int take = 0;
        // Take case: if no element chosen yet or current element is larger than previous
        if(prevInd == -1 || arr[ind] > arr[prevInd])
            take = 1 + memoizationRecur(ind+1, ind, arr, dp);

        return dp[ind][prevInd+1] = Math.max(take, notTake);
    }

    public static int memoization(int[] nums)
    {
        int n = nums.length;
        // dp[ind][prevInd+1] to handle prevInd = -1
        int[][] dp = new int[n][n+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=n;j++){
                dp[i][j] = -1;
            }
        }

        return memoizationRecur(0, -1, nums, dp);
    }

    public static int recursionRecur(int ind,int prevInd,int[] arr)
    {
        if(ind==arr.length-1)
        {
            if(prevInd==-1|| arr[prevInd]<arr[ind]) return 1;
            return 0;
        }
        //Not take case
        int notTake=recursionRecur(ind+1,prevInd,arr);
        int take=0;
        // If no element is chosen till now
        if(prevInd==-1)
            take=1+recursionRecur(ind+1,ind,arr);
        else if(arr[ind]>arr[prevInd])
            take=1+recursionRecur(ind+1,ind,arr);
        return Math.max(take,notTake);
    }
    public static int recursion(int[] nums)
    {
        return recursionRecur(0, -1, nums);
    }
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int lengthOfLIS = recursion(nums);
        System.out.println("The length of the LIS for the given array is: " + lengthOfLIS);
    }
}
