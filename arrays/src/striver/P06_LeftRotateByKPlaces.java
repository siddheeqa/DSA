package striver;

public class P06_LeftRotateByKPlaces {
    public static void printArray(int[] nums)
    {
        for(int val:nums)
            System.out.print(val+" ");
        System.out.println();
    }
    public static void reverseArray(int[] nums,int left,int right)
    {
        while(left<right)
        {
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
    }
    public static void optimal(int[] nums, int k)
    {
        int n=nums.length;
        //to avoid unnecessary rotations
        k=k%n;
        //Reverse the first k elements
        reverseArray(nums,0,k-1);
        //Reverse the last n-k elements
        reverseArray(nums,k,n-1);
        //Reverse the entire Array
        reverseArray(nums,0,n-1);
    }
    public static void brute(int[] nums,int k)
    {
        int n=nums.length;
        //To avoid unnecessary rotations(if nums size is 5 and k is 5 no need any rotation)
        k=k%n;
        int[] temp=new int[k];
        //store first k elements in the temporary array
        for(int i=0;i<k;i++)
            temp[i]=nums[i];
        //shift n-k elements to the front of the original array
        for(int i=k;i<n;i++)
            nums[i-k]=nums[i];
        //copy back the k elements at the end
        for(int i=0;i<k;i++)
            nums[n-k+i]=temp[i];
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int k = 2;
        System.out.println("Initial array: ");
        printArray(nums);
        optimal(nums, k);
        System.out.println("Array after rotating elements by " + k + " places: ");
        printArray(nums);
    }
}
