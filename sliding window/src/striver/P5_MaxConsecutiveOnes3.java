package striver;
//Find the maximum length of a subarray containing only 1’s after flipping at most k zeros.
public class P5_MaxConsecutiveOnes3 {
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public static int optimal(int[] nums,int k)
    {
        int n=nums.length;
        int left=0;
        int right=0;
        int zeros=0;
        int maxLen=0;
        while(right<n)
        {
            if(nums[right]==0)
                zeros++;
            if(zeros>k)
            {
                if(nums[left]==0)
                {
                    zeros--;
                }
                left++;
            }
            maxLen=Math.max(maxLen,right-left+1);
            right++;
        }
        return maxLen;
    }
    //Time Complexity: O(2n)
    //Space Complexity: O(1)
    public static int better(int[] nums,int k)
    {
       int n=nums.length;
       int left=0;
       int right=0;
       int zeros=0;
       int maxLen=0;
       while(right<n)
       {
           if(nums[right]==0)
               zeros++;
           while(zeros>k)
           {
               if(nums[left]==0)
               {
                   zeros--;
               }
               left++;
           }
           maxLen=Math.max(maxLen,right-left+1);
           right++;
       }
       return maxLen;
    }
    //Time Complexity: O(n²)
    //Space Complexity: O(1)
    public static int brute(int[] nums,int k)
    {
        int n=nums.length;
        int maxLen=0;
        int zeros=0;
        //Iterate through all possible starting points of the substring
        for(int i=0;i<n;i++)
        {
            zeros=0;
            for(int j=i;j<n;j++)
            {
                if(nums[j]==0)
                    zeros++;
                if(zeros<=k)
                    maxLen=Math.max(j-i+1,maxLen);
                else
                    break;
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int[] input = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        int length = optimal(input, k);
        System.out.println("Length of longest substring with at most " + k + " zeros: " + length);
    }
}
