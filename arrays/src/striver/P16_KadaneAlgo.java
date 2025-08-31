package striver;

public class P16_KadaneAlgo {
    //Time Complexity: O(N)
    //Space Complexity: O(1)
    public static int followUp(int[] nums)
    {
        long maxi=Long.MIN_VALUE;
        long sum=0;
        int start=0;
        int ansStart=-1,ansEnd=-1;
        for(int i=0;i<nums.length;i++)
        {
            if(sum==0)
                start=i;
            sum+=nums[i];
            if(sum>maxi)
            {
                ansStart=start;
                ansEnd=i;
                maxi=sum;
            }
            if(sum<0)
                sum=0;
        }
        // Printing the subarray
        System.out.print("The subarray is: [");
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("]");
        return (int)maxi;
    }
    //Time Complexity: O(N)
    //Space Complexity: O(1)
    public static int optimal(int[] nums)
    {
        long maxi=Long.MIN_VALUE;
        long sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            if(sum>maxi)
            {
                maxi=sum;
            }
            //Reset sum to 0 if it becomes negative
            if(sum<0) sum=0;
        }
        return (int)maxi;
    }
    //Time Complexity: O(N2)
    //Space Complexity: O(1)
    public static int better(int[] nums)
    {
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            int sum=0;
            for(int j=i;j<nums.length;j++)
            {
                sum+=nums[j];
                maxi=Math.max(maxi,sum);
            }
        }
        return maxi;
    }
    //Time Complexity: O(N3)
    //Space Complexity: O(1)
    public static int brute(int[] nums)
    {
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i;j<nums.length;j++)
            {
                int sum=0;
                for(int k=i;k<=j;k++)
                    sum+=nums[k];
                maxi=Math.max(maxi,sum);
            }
        }
        return maxi;
    }
    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSum = followUp(arr);
        System.out.println("The maximum subarray sum is: " + maxSum);
    }
}
