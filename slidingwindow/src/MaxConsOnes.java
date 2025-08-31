/*
public class MaxConsOnes {
    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0} ;
        int k=2;
        int left=0,right=0,maxLen=0;
        int n=nums.length;
        int zeros=0;
        while(right<n)
        {
            if(nums[right]==0)
                zeros++;
            while(zeros>k)
            {
                if(nums[left]==0)
                    zeros--;
                left++;
            }
            if(zeros<=k)
                maxLen=Math.max(maxLen,right-left+1);
            right++;
        }
        System.out.println(maxLen);
    }
}
*/
public class MaxConsOnes
{
    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0} ;
        int k=2;
        int n=nums.length;
        int maxLen=0;
        for(int i=0;i<n;i++) {
            int zeros=0;
            for (int j = i; j < n; j++) {
                if (nums[j]==0)
                    zeros++;
                if(zeros<=k)
                    maxLen=Math.max(maxLen,j-i+1);
                else
                    break;
            }
        }
        System.out.println(maxLen);
    }
}
