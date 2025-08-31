package striver;

import java.util.Arrays;

public class P14_SortZeroOneTwo {
    public static void optimal(int[] nums)
    {
        //initialize 3 pointers low,mid,high
        int low=0,mid=0,high= nums.length-1;
        while(mid<=high)
        {
            if(nums[mid]==0)
            {
                int temp=nums[low];
                nums[low]=nums[mid];
                nums[mid]=temp;
                low++;
                mid++;
            }
            else if(nums[mid]==1)
                mid++;
            else {
                int temp=nums[mid];
                nums[mid]=nums[high];
                nums[high]=temp;
                high--;
            }
        }
    }
    //TC:O(2N)
    public static void better(int[] nums)
    {
        int count0=0,count1=0,count2=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0) count0++;
            else if(nums[i]==1) count1++;
            else count2++;
        }
        //Placing the elements in the original array based on counts
        for(int i=0;i<count0;i++)
            nums[i]=0;
        for(int i=count0;i<count0+count1;i++)
            nums[i]=1;
        for(int i=count0+count1;i<nums.length;i++)
            nums[i]=2;
    }
    //TC: O(NLOGN)
    public static void brute(int[] nums)
    {
        Arrays.sort(nums);
    }
    public static void main(String[] args) {
        int[] nums = {2, 0, 1, 1, 0, 2};

        optimal(nums);

        for (int num : nums)
            System.out.print(num + " ");
    }
}
