package striver;
//Find the maximum sum of any contiguous sub array of size k in the given array
public class P1_ConstantWindow {
    public static int maxSumSubarray(int[] arr,int k)
    {
        int n=arr.length;
        if(n<k)
        {
        System.out.println("Window size is larger than array size");
        return -1;
        }
        //step 1: Compute sum of first window
        int windowSum=0;
        for(int i=0;i<k;i++)
            windowSum+=arr[i];

        int maxSum=0;
        //step 2: Slide the window
        for(int i=k;i<n;i++)
        {
            //add next element, remove first element of window
            windowSum+=arr[i]-arr[i-k];
            maxSum=Math.max(maxSum,windowSum);
        }
        return maxSum;
    }
    public static void main(String[] args)
    {
        int[] arr={2,1,5,1,3,2};
        int k=3;
        int result=maxSumSubarray(arr,k);
        System.out.println("Maximum sum of sub array of size " + k + " = " + result);
    }
}
