package striver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P19_NextPermutation {

    /*
    // Function to get the next permutation of given array
    public static void brute(int[] nums)
    {
        //Get all permutation
        List<List<Integer>> ans=getAllPermutations(nums);
        //generate all permutations
        helperFunc(0,nums,ans);
        //sort the permutations list
        Collections.sort(ans,(a,b)->{
            for(int i=0;i<a.size();i++)
            {
                if(!a.get(i).equals(b.get(i)))
                    return a.get(i)-b.get(i);
            }
            return 0;
        });
        return ans;
    }
    public static void helperFunc(int index,int[] nums, List<List<Integer>> ans)
    {
        //Base case
        if(index==nums.length)
        {
            //Add permutation to the answer
            List<Integer> temp=new ArrayList<>();
            for(int num:nums) temp.add(num);
            ans.add(temp);
            return;
        }
        for(int i=index;i<nums.length;i++)
        {
            //swap in
            swap(nums,index,i);
            helperFunc(index+1,nums,ans);
            //swap out
            swap(nums,index,i);
        }
        return;
    }
    public static void swap(int[] nums,int i,int j)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public static List<List<Integer>> getAllPermutations(int[] nums)
    {
        //To store Permutation
        List<List<Integer>> ans = new ArrayList<>();

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.print("Given array: ");
        for(int x : nums) System.out.print(x + " ");
        //
        optimal(nums);
        System.out.print("\nNext Permutation: ");
        for(int x : nums) System.out.print(x + " ");
    }

*/
}
