package striver;
//Binary search on answer->min(max) or max(min)
//Assign boards of given lengths to k painters (each painter paints contiguous boards) such that the time to paint all boards is minimized.
public class P22_SplitArrayLargestSum {
    public static int countPartitions(int[] a,int maxSum)
    {
        int n=a.length;
        int partitions=1;
        long  subarraySum=0;
        for(int i=0;i<n;i++)
        {
            if(subarraySum+a[i]<=maxSum)
            {
                subarraySum+=a[i];
            }
            else
            {
                partitions++;
                subarraySum=a[i];
            }
        }
        return partitions;
    }
    //Time Complexity: O(N * (log(sum - max) + 1))
    //Space Complexity is O(1)
    public static int largestSubarraySumMinimized(int[] a,int k)
    {
        int low=Integer.MIN_VALUE;
        int high=0;
        //Find search boundaries
        for(int i=0;i<a.length;i++)
        {
            low=Math.max(a[i],low);
            high+=a[i];
        }
        while(low<=high)
        {
            int mid=(low+high)/2;
            int partitions=countPartitions(a,mid);
            if(partitions>k)
            {
                //If partitions exceed k, increase the minimum possible subarray sum
                low=mid+1;
            }
            else {
                // If partitions are within k, try to minimize the subarray sum further
                high=mid-1;
            }
        }

        // After binary search, 'low' will be the largest minimum subarray sum with at most k partitions
        return low;
    }
    public static void main(String[] args) {
        int[] a = {10, 20, 30, 40};
        int k = 2;
        int ans = largestSubarraySumMinimized(a, k);
        System.out.println("The answer is: " + ans);
    }
}
