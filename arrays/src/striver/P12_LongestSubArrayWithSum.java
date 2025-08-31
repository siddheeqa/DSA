package striver;

import java.util.HashMap;
import java.util.Map;

public class P12_LongestSubArrayWithSum {
    //This solution optimal for array containing only positive
    public static int optimal2(int[] nums,int k)
    {
        int n=nums.length;
        int maxLen=0;
        int left=0,right=0;
        int sum=0;
        while(right<n)
        {
            sum+=nums[right];
            //if the exceeds k, shrink the window
            while(left<=right && sum>k)
            {
                sum-=nums[left];
                left++;
            }
            if(sum==k) maxLen=Math.max(maxLen,right-left+1);
            right++;
        }
        return maxLen;
    }
    //This is the optimal for array containing both positives and negatives
    public static int optimal1(int[] nums,int k)
    {
        int n=nums.length;
        Map<Integer,Integer> prefixSumMap=new HashMap<>();
        int sum=0;
        int maxLen=0;
        for(int i=0;i<n;i++) {
            sum += nums[i];
            if (sum == k) maxLen = Math.max(maxLen, i + 1);
            //calculate remaining part sum if exist sum with k
            int rem = sum - k;
            //calculate length and update maxLen
            if (prefixSumMap.containsKey(rem)) {
                int len = i - prefixSumMap.get(rem);
                maxLen=Math.max(maxLen,len);
            }
            if(!prefixSumMap.containsKey(sum))
                prefixSumMap.put(sum,i);
        }
        return maxLen;
    }
    //Time Complexity: O(N3)
    //Space Complexity: O(1)
    public static int brute(int[] nums,int k)
    {
        int n=nums.length;
        int maxLength=0;
        for(int startIndex=0;startIndex<n;startIndex++)
        {
            for(int endIndex=startIndex;endIndex<n;endIndex++)
            {
                int sum=0;
                for(int i=startIndex;i<=endIndex;i++) {
                    sum += nums[i];
                    //this optimization only works when the array only contain positive number
                    /*
                    if (sum > k)
                        break;
                     */
                }
                if(sum==k)
                    maxLength=Math.max(maxLength,endIndex-startIndex+1);
            }
        }
        return maxLength;
    }
    public static void main(String[] args) {
        int[] nums = { -1, 1, 1 };
        int k = 1;
        int len = optimal1(nums, k);

        System.out.println("The length of the longest subarray is: " + len);
    }
}
