package striver;
//Find the length of the longest sub array with sum ≤ k. only for non negatives array
public class P2_LongSubArraySumLessThanEqualsK {
    //Total = O(n)
    //Space = O(1)
    public static int optimal(int[] arr,int k)
    {
        int n=arr.length;
        int left=0;
        int right=0;
        int sum=0;
        int maxLen=0;
        while (right<n)
        {
            sum+=arr[right];
            if(sum>k && left<=right)
            {
                sum-=arr[left];
                left++;
            }
            //valid sub array
            maxLen=Math.max(maxLen,right-left+1);
            right++;
        }
        return maxLen;
    }
    //So, 2n steps max → O(n).
    //Space = O(1).
    public static int better(int[] arr,int k)
    {
        int n=arr.length;
        int left=0;
        int right=0;
        int sum=0;
        int maxLen=0;
        while (right<n)
        {
          sum+=arr[right];
          while(sum>k && left<=right)
          {
              sum-=arr[left];
              left++;
          }
          //valid sub array
            maxLen=Math.max(maxLen,right-left+1);
          right++;
        }
        return maxLen;
    }
    //Total = O(n²)
    //Space = O(1)
    public static int brute(int[] arr,int k)
    {
        int n=arr.length;
        int maxLen=0;
        for(int i=0;i<n;i++)
        {
            int sum=0;
            for(int j=i;j<n;j++)
            {
                sum+=arr[j];
                if(sum<=k)
                    maxLen=Math.max(maxLen,j-i+1);
                else if(sum>k)
                    // Since array has only non-negatives, no point extending further
                    break;
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 2, 4};
        int k = 7;

        System.out.println("Maximum Length: " + optimal(arr, k));
    }
}
