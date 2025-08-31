public class P07_SearchRotatedSortedArray1 {
    //Time Complexity: O(logN)
    //Space Complexity: O(1)
    public static int optimal(int[] nums,int target)
    {
        int low=0;
        int high=nums.length-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(nums[mid]==target) return mid;
            //check if left part is sorted
            if(nums[low]<=nums[mid])
            {
                //check if target is between the range
                if(nums[low]<=target && nums[mid]>=target)
                    high=mid-1;
                else
                    low=mid+1;
            }
            else
            {
                if(nums[mid]<=target && nums[high]>=target)
                    low=mid+1;
                else
                    high=mid-1;
            }
        }
        return -1;
    }
    //Time Complexity: O(N)
    //Space Complexity: O(1)
    public static int brute(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == target)
                return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int result = brute(nums, target);

        if (result == -1)
            System.out.println("Target is not present.");
        else
            System.out.println("The index is: " + result);
    }
}
