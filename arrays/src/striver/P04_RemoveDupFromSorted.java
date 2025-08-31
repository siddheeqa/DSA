package striver;

import java.util.Set;
import java.util.TreeSet;

public class P04_RemoveDupFromSorted {
    public static void printArray(int[] nums,int n)
    {
        for(int i=0;i<n;i++)
            System.out.print(nums[i]+" ");
        System.out.println();
    }
    public static int optimal(int[] nums)
    {
        //initialize pointer for storing unique elements
        int i=0;
        for(int j=1;j<nums.length;j++)
        {
            if(nums[i]!=nums[j])
            {
                i++;
                nums[i]=nums[j];
            }
        }
        //number of unique elements
        return i+1;
    }
    //Time Complexity: O(N * log N) + O(N)
    public static int brute(int[] nums)
    {
        //TreeSet class to store only unique elements which maintains sorted order
        Set<Integer> set=new TreeSet<>();
        for(int val:nums)
            set.add(val);
        //get number of unique elements
        int k=set.size();
        int j=0;
        for(int val:set)
            nums[j++]=val;
        return k;
    }
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3, 3};
        System.out.print("Original Array: ");
        printArray(nums, nums.length);
        int k = optimal(nums);
        System.out.print("Array after removing the duplicates: ");
        printArray(nums, k);
    }
}
