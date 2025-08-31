package striver;

import java.util.HashMap;
import java.util.Map;

public class P15_MajorityElement1 {
    public static int optimal(int[] nums)
    {
        int n = nums.length;
        int cnt = 0;
        int el = 0;
        // Applying the moore's voting algorithm
        for (int i = 0; i < n; i++) {
            if (cnt == 0) {
                cnt = 1;
                el = nums[i];
            } else if (el == nums[i]) {
                cnt++;
            } else {
                cnt--;
            }
        }
        int cnt1 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == el) {
                cnt1++;
            }
        }
        if (cnt1 > (n / 2)) {
            return el;
        }
        return -1;
    }
    //TC:O(NLOGN)+O(N)
    //SC:O(N)
    public static int better(int[] nums)
    {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums)
            map.put(num,map.getOrDefault(num,0)+1);
        //Iterate through the map to find the majority element
        for(Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            if(entry.getValue()>n/2)
                return entry.getKey();
        }
        return -1;
    }
    //TC:O(N*2)
    public static int brute(int[] nums)
    {
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            int count=0;
            for(int j=0;j<n;j++)
            {
                if(nums[i]==nums[j])
                    count++;
            }
            if(count>(n/2))
                return nums[i];
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        int ans = optimal(arr);
        System.out.println("The majority element is: " + ans);
    }
}
