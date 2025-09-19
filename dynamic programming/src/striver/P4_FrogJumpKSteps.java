package striver;
import java.util.Arrays;

public class P4_FrogJumpKSteps {
    //Time Complexity: O(N*k)
    //Space Complexity:O(K)
    public static int optimal(int[] heights,int k)
    {
        int n=heights.length;
        //Use a rolling array of size k to store only last k dp values
        int[] dp=new int[k];
        for(int i=1;i<n;i++)
        {
            int mmSteps=Integer.MAX_VALUE;
            // Loop to try all possible jumps from '1' to 'k'
            for(int j=1;j<=k;j++)
            {
                if(i-j>=0)
                {
                    int prevIndex=(i-j)%k;
                    int jump=dp[prevIndex] + Math.abs(heights[i] - heights[i - j]);
                    mmSteps=Math.min(mmSteps,jump);
                }
            }
            //Store the current result in rolling array
            dp[i%k]=mmSteps;
        }
        return dp[(n-1)%k];
    }
    //Time Complexity: O(N*k)
    //Space Complexity:O(N)
    public static int tabulation(int[] heights,int k)
    {
        int ind=heights.length-1;
        int[] dp=new int[ind+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        for(int i=1;i<=ind;i++)
        {
            int mmSteps=Integer.MAX_VALUE;
            for(int j=1;j<=k;j++)
            {
                if(i-j>=0)
                {
                    int jump=dp[i-j]+Math.abs(heights[i]-heights[i-j]);
                    mmSteps=Math.min(jump,mmSteps);
                }
            }
            dp[i]=mmSteps;
        }
        return dp[ind];
    }
    //Time Complexity: O(k*N)
    //Space Complexity:O(N)+O(N)
    public static int memoizationRecur(int[] heights,int k,int ind,int[] dp)
    {
        if(ind==0) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int mmStep=Integer.MAX_VALUE;
        for(int j=1;j<=k;j++)
        {
            if(ind-j>=0) {
                int jump = memoizationRecur(heights, k, ind - j, dp) + Math.abs(heights[ind] - heights[ind - j]);
                //update the minimum energy
                mmStep = Math.min(jump, mmStep);
            }
        }
        dp[ind]=mmStep;
        return dp[ind];
    }
    public static int memoization(int[] heights,int k)
    {
        int ind=heights.length-1;
        int[] dp=new int[ind+1];
        Arrays.fill(dp,-1);
        return memoizationRecur(heights,k,ind,dp);
    }
    public static int recursionRecur(int[] heights,int ind,int k)
    {
        if(ind==0) return 0;
        int mmStep=Integer.MAX_VALUE;
        //Try all possible steps
        for(int j=1;j<=k;j++)
        {
            //check if ind-j is non negative
            if(ind-j>=0) {
                int jump = recursionRecur(heights, ind - j, k) + Math.abs(heights[ind] - heights[ind - j]);
                //update the minimum energy
                mmStep = Math.min(jump, mmStep);
            }
        }
        return mmStep;
    }
    //Time Complexity: O(kN)
    //Space Complexity: O(N)
    public static int recursion(int[] heights,int k)
    {
        int ind=heights.length-1;
        return recursionRecur(heights,ind,k);
    }
    public static void main(String[] args) {
        int[] heights = {15, 4, 1, 14, 15};
        int k = 3;
        System.out.println("Minimum energy: " + optimal(heights, k));
    }
}
