package striver;

public class P06_CountOccurrencesOfNumber {
    public static int lowerBound(int[] arr,int x)
    {
        int low=0;
        int high=arr.length-1;
        int ans=arr.length;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(arr[mid]>=x) {
                ans = mid;
                //I want smallest index
                high=mid-1;
            }
            else
                low=mid+1;
        }
        return ans;
    }
    public static int upperBound(int[] arr,int x)
    {
        int low=0;
        int high=arr.length-1;
        int ans=arr.length;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(arr[mid]>x) {
                ans = mid;
                //I want smallest index
                high=mid-1;
            }
            else
                low=mid+1;
        }
        return ans;
    }
    public static int[] firstAndLastPosition(int[] nums,int target)
    {
        int firstOcc=lowerBound(nums,target);
        // Check if the target is present in the array or not
        if(firstOcc== nums.length || nums[firstOcc]!=target) return new int[]{-1,-1};
        int lastOcc=upperBound(nums,target)-1;
        return new int[]{firstOcc,lastOcc};
    }
    //Time Complexity: 2*O(log N)
    //Space Complexity: O(1)
    public static int optimal(int[] nums,int n,int x)
    {
        int[] ans = firstAndLastPosition(nums, x);
        if (ans[0] == -1) return 0;
        return (ans[1] - ans[0] + 1);
    }
    //Time Complexity: O(N)
    //Space Complexity: O(1)
    public static int brute(int[] nums,int n,int x)
    {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == x) cnt++;
        }
        return cnt;
    }
    public static void main(String[] args) {
        int[] arr =  {2, 4, 6, 8, 8, 8, 11, 13};
        int n = 8, x = 8;
        int ans = optimal(arr, n, x);
        System.out.println("The number of occurrences is: " + ans);
    }
}
