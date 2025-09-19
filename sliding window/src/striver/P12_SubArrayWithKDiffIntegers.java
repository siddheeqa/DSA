package striver;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//Count the number of sub arrays that contain exactly k distinct integers.
public class P12_SubArrayWithKDiffIntegers {
    public static int atMostK(int[] nums,int k)
    {
        int n=nums.length;
        int left=0,right=0;
        int count=0;
        Map<Integer,Integer> map=new HashMap<>();
        while(right<n)
        {
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            while(map.size()>k)
            {
                map.put(nums[left],map.get(nums[left])-1);
                if(map.get(nums[left])==0)
                    map.remove(nums[left]);
                left++;
            }
            // Count all sub arrays ending at r` that satisfy the sum condition
            count+=(right-left+1);
            right++;
        }
        return count;
    }
    //O(2n) time, O(k) space.
    public static int optimal(int[] nums,int k)
    {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }
    //Time: O(n²)
    //Space: O(n)
    public static int brute(int[] nums,int k)
    {
        int n= nums.length;
        int count=0;
        for(int i=0;i<n;i++)
        {
            Set<Integer> set=new HashSet<>();
            for(int j=i;j<n;j++)
            {
                set.add(nums[j]);
                if(set.size()==k) count++;
                else if(set.size()>k) break;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 3};
        int k = 2;
        System.out.println(optimal(nums, k));
    }
}
