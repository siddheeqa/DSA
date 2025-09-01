package striver;

public class P09_MinInSortedArray {
    //Time Complexity:O(log(N))
    //Space Complexity:O(1)
    public static int optimal(int[] arr)
    {
        int low=0;
        int high=arr.length-1;
        int ans=Integer.MAX_VALUE;
        while(low<=high)
        {
            int mid=(low+high)/2;
            //check if left part is sorted
            if(arr[low]<=arr[mid])
            {
                ans=Math.min(ans,arr[low]);
                low=mid+1;
            }
            else
            {
                ans=Math.min(ans,arr[mid]);
                high=mid-1;
            }
        }
        return ans;
    }
    //Time Complexity:O(N)
    //Space Complexity:O(1)
    public static int brute(int[] arr)
    {
        int mini = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            mini = Math.min(mini,arr[i]);
        }
        return mini;
    }
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2, 3};
        int ans = optimal(arr);
        System.out.println("The minimum element is: " + ans);
    }
}
