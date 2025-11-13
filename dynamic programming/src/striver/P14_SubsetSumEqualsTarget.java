package striver;

import java.util.Arrays;

public class P14_SubsetSumEqualsTarget {
    public static boolean optimal(int[] arr,int target)
    {
        int n=arr.length;
        boolean[] prev = new boolean[target + 1];
        prev[0]=true;
        if(arr[0]<=target)
            prev[arr[0]]=true;
        for(int ind=1;ind<n;ind++)
        {
            boolean[] curr = new boolean[target + 1];
            //If the target sum is 0, we
            curr[0] = true;
            for(int i=1;i<=target;i++)
            {
                boolean notTake=prev[i];
                //If we take the current element, subtract its value from the target and check the previous row
                boolean take=false;
                if(arr[ind]<=i)
                {
                    take=prev[i-arr[ind]];
                }
                curr[i]=notTake||take;
            }
            prev=curr;
        }
        return prev[target];
    }
    public static boolean tabulation(int[] arr,int target)
    {
        int n=arr.length;
        //dp[i][t] means: “Can we make sum t using elements from index 0 to i?
        //The DP table has columns from 0 to target.
        boolean[][] dp = new boolean[n][target + 1];
        //dp[i][t] = notTake || take;
        //So dp[i][0] = true always, thanks to the notTake option
        // Base case (when target = 0)
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        //If arr[0] is larger than target, there is no column arr[0] in the table → would cause array index out of bounds.
        //can we make target using that 1st element yes!
        if(arr[0]<=target)
            dp[0][arr[0]]=true;
        for(int ind=1;ind<n;ind++)
            for(int i=1;i<=target;i++)
            {
                boolean notTake=dp[ind-1][i];
                boolean take=false;
                if(arr[ind]<=i)
                    take=dp[ind-1][i-arr[ind]];
                dp[ind][i]=notTake|| take;
            }
        return dp[n-1][target];
    }
    public static boolean memoizationRecur(int ind,int target,int[] arr, int[][] dp)
    {
        if(target==0) return true;
        if(ind==0)
            return arr[0]==target;
        if (dp[ind][target] != -1)
            return dp[ind][target] == 1;
        boolean notTake=memoizationRecur(ind-1,target,arr,dp);
        boolean take = false;
        if(arr[ind]<=target)
            take=memoizationRecur(ind-1,target-arr[ind],arr,dp);
        dp[ind][target]=notTake||take?1:0;
        return notTake || take;
    }
    public static boolean memoization(int[] arr,int target)
    {
        int n = arr.length;
        int[][] dp = new int[n][target + 1];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        return memoizationRecur(n-1,target,arr,dp);
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

    public static boolean recursion(int[] arr,int target)
    {
        int n=arr.length-1;
        return recursionRecur(n,arr,target);
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int target = 4;
        if (optimal(arr, target))
            System.out.println("Subset with the given target found");
        else
            System.out.println("Subset with the given target not found");
    }
}
