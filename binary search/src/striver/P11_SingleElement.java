package striver;

public class P11_SingleElement {
    //Time Complexity:O(logN)
    //Space Complexity:O(1)
    public static int optimal(int[] nums)
    {
        int n=nums.length;
        //Edge cases
        if(n==1) return nums[0];
        if(nums[0]!=nums[1]) return nums[0];
        if(nums[n-1]!=nums[n-2]) return nums[n-1];
        int low=1;
        int high=n-2;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(nums[mid]!=nums[mid+1] && nums[mid]!=nums[mid]-1)
                return nums[mid];
            //we are in left part
            if((mid%2==1) && nums[mid]==nums[mid-1] ||
                    (mid%2==0 && nums[mid]==nums[mid+1]))
                low=mid+1;
            //we are in right part
            else
                high=mid-1;
        }
        return -1;
    }
    //Time Complexity:O(N)
    //Space Complexity:O(1)
    public static int brute2(int[] nums)
    {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans ^= nums[i];
        }
        return ans;
    }
    //Time Complexity:O(N)
    //Space Complexity:O(1)
    public static int brute1(int[] nums)
    {
        int n=nums.length;
        for (int i = 0; i < n; i++) {
            // Check for the first index.
            if (i == 0) {
                if (nums[i] != nums[i + 1])
                    return nums[i];
            }
            // Check for the last index.
            else if (i == n - 1) {
                if (nums[i] != nums[i - 1])
                    return nums[i];
            }
            // Check for any other index.
            else {
                if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1])
                    return nums[i];
            }
        }
        /* Dummy return statement,
           should never reach here.*/
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 3, 4};
        int ans = optimal(nums);
        System.out.println("The single element is: " + ans);
    }
}
