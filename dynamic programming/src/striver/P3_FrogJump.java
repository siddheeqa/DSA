package striver;

import java.lang.reflect.Array;
import java.util.Arrays;
//The Frog Jump problem is about finding the minimum energy cost for a frog to reach the last stone, where from each stone it can jump either one step or two steps ahead.
public class P3_FrogJump {
    //Time Complexity O(N)
    //SpaceComplexity O(1)
    public static int optimal(int[] heights,int ind)
    {
        int prev=0,prev2=0;
        for(int i=1;i<=ind;i++)
        {
            int oneJump=prev+Math.abs(heights[i]-heights[i-1]);
            int twoJump=Integer.MAX_VALUE;
            if(i>1)
                twoJump=prev2+Math.abs(heights[i]-heights[i-2]);
            int curr=Math.min(oneJump,twoJump);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
    //Time Complexity O(N)
    //SpaceComplexity O(N)
    public static int tabulation(int[] heights,int ind)
    {
        int[] dp=new int[ind+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        for(int i=1;i<=ind;i++)
        {
            int oneJump=dp[i-1]+Math.abs(heights[i]-heights[i-1]);
            int twoJump=Integer.MAX_VALUE;
            if(i>1)
                twoJump=dp[i-2]+Math.abs(heights[i]-heights[i-2]);
            dp[i]=Math.min(oneJump,twoJump);
        }
        return dp[ind];
    }
    public static int memoizationRecur(int[] heights,int ind,int[] dp)
    {
        if(ind==0) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int oneJump=memoizationRecur(heights,ind-1,dp)+Math.abs(heights[ind]-heights[ind-1]);
        int twoJump=Integer.MAX_VALUE;
        if(ind>1)
            twoJump=memoizationRecur(heights,ind-2,dp)+Math.abs(heights[ind]-heights[ind-2]);
        return dp[ind]=Math.min(oneJump,twoJump);
    }
    //Time Complexity O(N)
    //SpaceComplexity O(N)
    public static int memoization(int[] heights,int ind)
    {
        int n=heights.length;
        int[] dp=new int[n];
        Arrays.fill(dp, -1);
        return memoizationRecur(heights,n-1,dp);
    }
    //Time Complexity: O(2N)
    //Space Complexity: O(N)
    public static int recursion(int[] heights,int ind)
    {
        if(ind==0) return 0;
        // Recursively calculate the energy required to jump to the current step from the previous step
        int oneJump=recursion(heights,ind-1)+Math.abs(heights[ind]-heights[ind-1]);
        int twoJump=Integer.MAX_VALUE;
        if(ind>1)
            twoJump=recursion(heights,ind-2)+Math.abs(heights[ind]-heights[ind-2]);
        return Math.min(oneJump,twoJump);
    }
    public static void main(String[] args) {
        int[] heights = {2, 1, 3, 5, 4};
        int result = optimal(heights,heights.length-1);
        System.out.println("Minimum energy required: " + result);
    }
}
