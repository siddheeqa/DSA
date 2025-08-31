public class LongSubarraySumLessEqualsK {
    public static void main(String[] args)
    {
        int[] arr={2,5,1,7,10};
        int k=14;
        int sum=0,maxLen=0;
        int left=0,right=0;
        int n=arr.length;
        while(right<n)
        {
         sum+=arr[right];
         while(sum>k)
         {
             sum-=arr[left];
             left++;
         }
         if(sum<=k)
             maxLen=Math.max(maxLen,right-left+1);
         right++;
        }
        System.out.println(maxLen);
    }
}
