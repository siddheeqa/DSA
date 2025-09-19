package striver;

import java.util.Arrays;
//Binary search on answer->min(max) or max(min)
//Function to find the maximum possible minimum distance 'k' cows can have between them in nums
public class P20_AggressiveCows {
    public static boolean canWePlace(int[] nums,int dist,int cows)
    {
        int n=nums.length;
        //Number of cows placed
        int countCows=1;
        //Position of last placed cow
        int last=nums[0];
        for(int i=1;i<n;i++)
        {
            if(nums[i]-last>=dist)
            {
                countCows++;
                last=nums[i];
            }
            if(countCows>=cows)return true;
        }
        return false;
    }
    //Time Complexity:O(NlogN) + O(N *log(max-min))
    //Space Complexity is O(1)
    public static int aggressiveCowsOptimal(int[] nums,int k){
        // Size of array
        int n = nums.length;
        // Sort the nums
        Arrays.sort(nums);

        int low = 1, high = nums[n - 1] - nums[0];

        //Apply binary search:
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canWePlace(nums, mid, k) == true) {
                low = mid + 1;
            }
            else high = mid - 1;
        }
        return high;
    }
    //Time Complexity:O(NlogN) + O(N *(max-min))
    //Space Complexity is O(1)
    public static int aggressiveCowsBrute(int[] nums,int k)
    {
        int n=nums.length;
        Arrays.sort(nums);
        int limit=nums[n-1]-nums[0];
        for(int i=1;i<=limit;i++)
        {
            //Return the previous limit which we able to place all cows
            if(!canWePlace(nums,i,k))
            {
                return (i-1);
            }
        }
        return limit;
    }
    public static void main(String[] args) {
        int[] nums = {0, 3, 4, 7, 10, 9};
        int k = 4;
        int ans = aggressiveCowsOptimal(nums, k);
        System.out.println("The maximum possible minimum distance is: " + ans);
    }
}
