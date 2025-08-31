package striver;
import java.util.Arrays;
public class P07_MoveZerosToEnd {
    //Time Complexity: O(N)
    //Space Complexity: O(1)
    public static void optimal(int[] nums)
    {
        //j is the pointer where next non-zero element should be placed
        int j=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]!=0)
            {
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                j++;
            }
        }
    }
    //Time Complexity: O(2*N)
    //Space Complexity: O(N)
    public static void brute(int[] nums)
    {
        int n=nums.length;
        //create a temporary array to store non zero elements
        int[] temp=new int[n];
        int count=0;
        //copy non-zero elements to the temp
        for(int i=0;i<n;i++)
            if(nums[i]!=0)
                temp[count++]=nums[i];
        //copy non-zero elements back to the original array
        for(int i=0;i<count;i++)
            nums[i]=temp[i];
        //Fill the rest position with zeros
        for(int i=count;i<n;i++)
            nums[i]=0;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 2, 3, 2, 0, 0, 4, 5, 1};
        optimal(nums);
        System.out.print("Array after moving zeroes: ");
        System.out.println(Arrays.toString(nums));
    }
}