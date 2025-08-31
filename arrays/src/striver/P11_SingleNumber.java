package striver;

import java.util.HashMap;

public class P11_SingleNumber {
    //Time Complexity: O(N)
    //Space Complexity: O(1)
    public static int optimal(int[] nums)
    {
        int xor=0;
        for(int i=0;i<nums.length;i++)
            xor=xor^nums[i];
        return xor;
    }
    //Time Complexity: O(N)
    //Space Complexity: O(N)
    public static int brute(int[] nums) {
        //store elements with its frequency
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num,map.getOrDefault(num,0)+1);
        for(int key:map.keySet())
            if(map.get(key)==1)
                return key;
        //return -1 if there is no single element
        return -1;
    }
    public static void main(String[] args)
    {
        int[] nums = {1, 2, 2, 4, 3, 1, 4};
        int ans = optimal(nums);
        System.out.println("The single number in given array is: " + ans);
    }
}
