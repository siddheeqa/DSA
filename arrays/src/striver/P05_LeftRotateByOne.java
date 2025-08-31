package striver;

public class P05_LeftRotateByOne {
    public static void rotateArrayByOne(int[] nums)
    {
        //store first element in temp variable
        int temp=nums[0];
        for(int i=1;i<nums.length;i++)
            nums[i-1]=nums[i];
        //place first element at the end
        nums[nums.length-1]=temp;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        rotateArrayByOne(nums);
        for (int num : nums)
            System.out.print(num + " ");
    }
}
