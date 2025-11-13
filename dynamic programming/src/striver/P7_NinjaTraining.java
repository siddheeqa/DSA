package striver;

import java.util.Arrays;

public class P7_NinjaTraining {
    public static int optimal(int[][] points)
    {
        int n=points.length;
        int[] prev=new int[4];
        // Initialize the DP table for the first day (day 0)
        prev[0] = Math.max(points[0][1], points[0][2]);
        prev[1] = Math.max(points[0][0], points[0][2]);
        prev[2] = Math.max(points[0][0], points[0][1]);
        prev[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));
        for(int day=1;day<n;day++)
        {
            int[] temp=new int[4];
            for(int last=0;last<4;last++)
            {
                for(int task=0;task<=2;task++)
                {
                    if(task!=last)
                    {
                        //keep updating it to max points
                        temp[last]=Math.max(temp[last],points[day][task]+prev[task]);
                    }
                }
            }
            prev=temp;
        }
        return prev[3];
    }
    public static int tabulation(int[][] points)
    {
        int n=points.length;
        int[][] dp=new int[n][4];
        // Initialize the DP table for the first day (day 0)
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));
        for(int day=1;day<n;day++)
        {
            for(int last=0;last<4;last++)
            {
                dp[day][last]=0;
                for(int task=0;task<=2;task++)
                {
                    if(task!=last)
                    {
                        int activityPoints=points[day][task] +dp[day-1][task];
                        dp[day][last]=Math.max(activityPoints,dp[day][last]);
                    }
                }
            }
        }
        return dp[n-1][3];
    }
    public static int memoizationRecur(int day,int last,int[][] points,int[][] dp)
    {
        if(day==0)
        {
            int maxi=0;
            for(int i=0;i<3;i++)
            {
                if(i!=last)
                    maxi=Math.max(maxi,points[0][i]);
            }
            return maxi;
        }
        if(dp[day][last]!=-1) return dp[day][last];
        int maxi=0;
        for(int i=0;i<3;i++)
        {
            if(i!=last)
            {
                int activityPoints=points[day][i]+memoizationRecur(day-1,i,points,dp);
                maxi=Math.max(maxi,activityPoints);
            }
        }
        //dp[day][last] = maximum points we can get from day 0 to 'day' if the activity done on the previous day was last.
        return dp[day][last]=maxi;
    }
    public static int memoization(int[][] points)
    {
        int days= points.length;;
        int[][] dp=new int[days][4];
        for(int[] row:dp)
            Arrays.fill(row,-1);
        return memoizationRecur(days-1,3,points,dp);
    }
    public static int recursionRecur(int day,int last,int[][] points)
    {
        if(day==0)
        {
            int maxi=0;
            for(int i=0;i<3;i++)
            {
                if(i!=last)
                    maxi=Math.max(maxi,points[0][i]);
            }
            return maxi;
        }
        int maxi=0;
        // Iterate through activities for the current day
        for(int i=0;i<3;i++)
        {
            if(i!=last)
            {
                int activityPoints=points[day][i]+recursionRecur(day-1,i,points);
                maxi=Math.max(maxi,activityPoints);
            }
        }
        return maxi;
    }
    public static int recursion(int[][] points)
    {
        int days=points.length;
        return recursionRecur(days-1,3,points);
    }
    public static void main(String[] args) {
        int[][] points = {
                {10, 40, 70},
                {20, 50, 80},
                {30, 60, 90}
        };
        System.out.println(optimal(points));
    }
}
