package striver;

import java.util.Arrays;

public class P16_PartitionEqualSubsetMinAbsDiff {
    public static int optimal(int[] arr, int n) {
        int totalSum = 0;
        for (int num : arr) totalSum += num;
        boolean[] prev = new boolean[totalSum + 1];
        // Base case: sum = 0 is always possible
        prev[0] = true;
        // Base case: with first element
        if (arr[0] <= totalSum) prev[arr[0]] = true;

        // Fill DP table using only one array
        for (int ind = 1; ind < n; ind++) {
            boolean[] curr = new boolean[totalSum + 1];
            curr[0] = true; // sum = 0 is always possible

            for (int target = 1; target <= totalSum; target++) {
                boolean notTake = prev[target];
                boolean take = false;
                if (arr[ind] <= target) {
                    take = prev[target - arr[ind]];
                }
                curr[target] = notTake || take;
            }
            prev = curr; // move current row to previous for next iteration
        }
        int mini = Integer.MAX_VALUE;
        for (int i = 0; i <= totalSum / 2; i++) {
            if (prev[i]) {
                int diff = Math.abs(i - (totalSum - i));
                mini = Math.min(mini, diff);
            }
        }
        return mini;
    }
    public static int tabulation(int[] arr,int n)
    {
        int totalSum=0;
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
        }
        boolean[][] dp=new boolean[n][totalSum+1];
        // Base case: sum = 0 is always possible
        for(int i=0;i<n;i++) {
            dp[i][0]=true;
        }
        // Base case: with first element
        if(arr[0]<=totalSum) {
            dp[0][arr[0]]=true;
        }
        // Fill the table
        for(int ind=1;ind<n;ind++) {
            for(int target=1;target<=totalSum;target++) {
                boolean notTake=dp[ind-1][target];
                boolean take=false;
                if(arr[ind]<=target) {
                    take=dp[ind-1][target-arr[ind]];
                }
                dp[ind][target]=notTake||take;
            }
        }
        int mini=Integer.MAX_VALUE;
        for(int i=0;i<=totalSum/2;i++) {
            if(dp[n-1][i]) {
                int diff=Math.abs(i-(totalSum-i));
                mini=Math.min(mini,diff);
            }
        }
        return mini;
    }
    public static boolean memoizationRecur(int ind,int[] arr,int target,int[][] dp)
    {
        if(target==0) return true;
        if(ind==0) return arr[0]==target;

        if(dp[ind][target]!=-1) return dp[ind][target]==1;

        boolean notTake=memoizationRecur(ind-1,arr,target,dp);
        boolean take=false;
        if(arr[ind]<=target) {
            take=memoizationRecur(ind-1,arr,target-arr[ind],dp);
        }

        dp[ind][target]= (notTake || take) ? 1 : 0;
        return notTake || take;
    }
    public static int memoization(int[] arr,int n)
    {
        int totalSum=0;
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
        }

        int[][] dp=new int[n][totalSum+1];
        for(int[] row:dp) {
            Arrays.fill(row,-1);
        }

        int mini=Integer.MAX_VALUE;
        for(int i=0;i<=totalSum/2;i++) {
            if(memoizationRecur(n-1,arr,i,dp)) {
                int diff=Math.abs(i-(totalSum-i));
                mini=Math.min(mini,diff);
            }
        }
        return mini;
    }
    public static boolean recursionRecur(int ind,int[] arr,int target)
    {
        //base case
        if(target==0) return true;
        if(ind==0) return arr[0]==target;
        //Try not to take the current element into subset
        boolean notTake=recursionRecur(ind-1,arr,target);
        boolean take=false;
        if(arr[ind]<=target)
            take=recursionRecur(ind-1,arr,target-arr[ind]);
        return notTake || take;
    }
    public static int recursion(int[] arr,int n)
    {
        int totalSum=0;
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
        }
        int mini=Integer.MAX_VALUE;
        for(int i=0;i<=totalSum/2;i++)
        {
            if(recursionRecur(n-1,arr,i))
            {
                //Subset S1 with sum = i
                //Subset S2 with sum = totSum - i
                int diff=Math.abs(i-(totalSum-i));
                mini=Math.min(mini,diff);
            }
        }
        return mini;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int n = arr.length;
        System.out.println("The minimum absolute difference is: " + optimal(arr, n));
    }
}
