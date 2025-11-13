package striver;

public class P18_CountPartitionsWithGivenDiff {
    static int mod = (int)1e9 + 7;
    public static int optimal(int[] arr,int target)
    {
        int n=arr.length;
        int[] prev=new int[target+1];
        //If the first element is 0, we have 2 ways to achieve sum 0: by either including or excluding the element.
        if(arr[0]==0) prev[0]=2;
        else prev[0]=1;
        //If the first element is not 0 and is less than or equal to target, we have 1 way to achieve the sum equal to that element.
        if(arr[0]!=0 && arr[0]<=target) prev[arr[0]]=1;
        //Fill the DP table for the rest of the elements.
        for(int ind=1;ind<n;ind++) {
            int[] cur = new int[target + 1];
            for (int tar = 0; tar <= target; tar++) {
                //Number of ways to achieve target sum without using the current element.
                int notTake = prev[tar];
                int take = 0;
                if (arr[ind] <= tar)
                    take = prev[tar - arr[ind]];
                cur[tar] = (notTake + take) % mod;
            }
            prev=cur;
        }
        return prev[target];
    }
    public static int tabulationLinear( int[] arr,int target)
    {
        int n=arr.length;
        int[][] dp=new int[n][target+1];
        //If the first element is 0, we have 2 ways to achieve sum 0: by either including or excluding the element.
        if(arr[0]==0) dp[0][0]=2;
        else dp[0][0]=1;
        //If the first element is not 0 and is less than or equal to target, we have 1 way to achieve the sum equal to that element.
        if(arr[0]!=0 && arr[0]<=target) dp[0][arr[0]]=1;
        //Fill the DP table for the rest of the elements.
        for(int ind=1;ind<n;ind++)
            for(int tar=0;tar<=target;tar++)
            {
                //Number of ways to achieve target sum without using the current element.
                int notTake=dp[ind-1][tar];
                int take=0;
                if(arr[ind]<=tar)
                    take=dp[ind-1][tar-arr[ind]];
                dp[ind][tar]=(notTake+take)%mod;
            }
        return dp[n-1][target];
    }
    public static int tabulation(int n, int diff, int[] arr)
    {
        int totSum = 0;
        for (int i = 0; i < arr.length; i++) {
            totSum += arr[i];
        }
        // If the total sum minus the difference is negative, or if it is not even, it's not possible to divide  the array into two subsets with the given difference.
        if (totSum - diff < 0) return 0;
        if ((totSum - diff) % 2 == 1) return 0;
        // Calculate the target sum for one of the subsets.
        int target = (totSum - diff) / 2;
        return optimal(arr,target);
    }
    public static int memoizationRecur(int ind, int target, int[] arr,int[][] dp)
    {
        if(ind==0)
        {
            if(target==0 && arr[0]==0)
                return 2;
            if(target==0 || target==arr[0])
                return 1;
            return 0;
        }
        if(dp[ind][target]!=-1) return dp[ind][target];
        // Calculate number of ways not including current element.
        int notTake=memoizationRecur(ind-1,target,arr,dp);
        int take=0;
        if(arr[ind]<=target)
            take=memoizationRecur(ind-1,target-arr[ind],arr,dp);
        return dp[ind][target]=(notTake+take)%mod;
    }
    public static int memoization(int n, int diff, int[] arr)
    {
        int totSum = 0;
        for (int i = 0; i < arr.length; i++) {
            totSum += arr[i];
        }
        // If the total sum minus the difference is negative, or if it is not even, it's not possible to divide  the array into two subsets with the given difference.
        if (totSum - diff < 0) return 0;
        if ((totSum - diff) % 2 == 1) return 0;
        // Calculate the target sum for one of the subsets.
        int target = (totSum - diff) / 2;
        int[][] dp = new int[n][target + 1];
        for(int i=0;i<n;i++)
            for(int j=0;j<=target;j++)
                dp[i][j]=-1;
        return memoizationRecur(n-1,target,arr,dp);
    }
    public static int recursionRecur(int ind, int target, int[] arr)
    {
        if(ind==0)
        {
            if(target==0 && arr[0]==0)
                return 2;
            if(target==0 || target==arr[0])
                return 1;
            return 0;
        }
        // Calculate number of ways not including current element.
        int notTake=recursionRecur(ind-1,target,arr);
        int take=0;
        if(arr[ind]<=target)
            take=recursionRecur(ind-1,target-arr[ind],arr);
        return (notTake+take)%mod;
    }
    public static int recursion(int n, int diff, int[] arr)
    {
        int totSum = 0;
        for (int i = 0; i < arr.length; i++) {
            totSum += arr[i];
        }
        // If the total sum minus the difference is negative, or if it is not even, it's not possible to divide  the array into two subsets with the given difference.
        if (totSum - diff < 0) return 0;
        if ((totSum - diff) % 2 == 1) return 0;
        // Calculate the target sum for one of the subsets.
        int target = (totSum - diff) / 2;
        return recursionRecur(n-1,target,arr);
    }
    public static void main(String[] args) {
        int[] arr = {5, 2, 6, 4};
        int n = arr.length;
        int diff = 3;
        // Print the number of subsets found
        System.out.println("The number of subsets found are " + tabulation(n, diff, arr));
    }
}
