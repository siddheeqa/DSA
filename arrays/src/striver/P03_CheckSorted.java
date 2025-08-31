package striver;

import java.util.ArrayList;
import java.util.List;

public class P03_CheckSorted {
    public static boolean isSorted(ArrayList<Integer> nums)
    {
        if(nums.size()<=1) return true;
        return sort(nums,0,1);
    }
    public static boolean sort(ArrayList<Integer> nums,int left,int right)
    {
        if(right>=nums.size()) return true;
        if(nums.get(left)>nums.get(right))
            return false;
        //move to the next pair of elements
        return sort(nums,left+1,right+1);
    }
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(List.of(1, 2, 9, 4, 5));
        boolean result = isSorted(nums);
        System.out.println(result ? "Array is sorted" : "Array is not sorted");
    }
}
