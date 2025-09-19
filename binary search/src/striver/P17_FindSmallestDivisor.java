package striver;
//Binary search on answer
//Find the smallest positive divisor such that the sum of all numbers in nums divided by it (rounded up) is less than or equal to threshold
public class P17_FindSmallestDivisor {
    //Time Complexity:O(log(max)*N)
    //Space Complexity is O(1)
    public static int optimal(int[] nums,int limit)
    {
        int n= nums.length;
        if (n > limit) return -1;
        // Find the maximum element in nums
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, nums[i]);
        }
        int low=1,high=maxi;
        while(low<=high)
        {
            int mid=(low+high)/2;
            int sum=0;
            for(int i=0;i<n;i++)
                sum+=Math.ceil((double) nums[i]/(double) mid);
            if(sum<=limit)
                high=mid-1;
            else
                low=mid+1;
        }
        return low;
    }
    //Time Complexity:O(max*N)
    //Space Complexity is O(1)
    public static int brute(int[] nums,int limit)
    {
        int n= nums.length;
        if (n > limit) return -1;
        // Find the maximum element in nums
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, nums[i]);
        }
        for(int d=1;d<=maxi;d++)
        {
            int sum=0;
            for(int i=0;i<n;i++)
                sum+=Math.ceil((double)nums[i]/(double) d);
            if(sum<=limit)
                return d;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int limit = 8;
        int ans = optimal(nums, limit);
        System.out.println("The minimum divisor is: " + ans);
    }
}
