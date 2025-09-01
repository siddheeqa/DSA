package striver;

//Find min value element index in the array - That is the solution
public class P10_HowManyTimesArrayRotated {
    //Time Complexity:O(log(N))
    //Space Complexity:O(1)
    public static int optimal(int[] arr)
    {
        int low=0;
        int high=arr.length-1;
        int ans=Integer.MAX_VALUE;
        int index=-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            /* Search space is already sorted
               then nums.get(low) will always be
               the minimum in that search space */
            if(arr[low]<=arr[high]){
                if(arr[low]<ans)
                {
                    ans=arr[low];
                    index=low;
                }
                break;
            }
            if(arr[low]<=arr[mid])
            {
                if(arr[low]<ans)
                {
                    index=low;
                    ans=arr[low];
                }
                low=mid+1;
            }
            else
            {
                if(arr[mid]<ans)
                {
                    index=mid;
                    ans=arr[mid];
                }
                high=mid-1;
            }
        }
        return index;
    }
    //Time Complexity:O(N)
    //Space Complexity:O(1)
    public static int brute(int[] nums)
    {
        int ans=Integer.MAX_VALUE;
        int index=-1;
        for(int i=0;i<nums.length;i++)
            if(nums[i]<ans)
            {
                ans=nums[i];
                index=i;
            }
        return index;
    }
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2, 3};
        int ans = optimal(nums);
        System.out.println("The array is rotated " + ans + " times.");
    }
}
