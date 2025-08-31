public class P05_FirstAndLastOccurrence {
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
    //Time Complexity: 2*O(log N)
    //Space Complexity: O(1)
    public static int[] optimal(int[] nums,int target)
    {
        int firstOcc=lowerBound(nums,target);
        // Check if the target is present in the array or not
        if(firstOcc== nums.length || nums[firstOcc]!=target) return new int[]{-1,-1};
        int lastOcc=upperBound(nums,target)-1;
        return new int[]{firstOcc,lastOcc};
    }
    //Time Complexity: O(N)
    //Space Complexity: O(1)
    public static int[] brute(int[] nums,int target) {
        // Initialize variables to store first and last occurrences
        int first = -1, last = -1;
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (first == -1)   first = i;
                last = i;
            }
        }
        ans[0] = first;
        ans[1] = last;
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] result = optimal(nums, target);

        System.out.println("The first and last occurrences are at indices: "
                + result[0] + " and " + result[1]);
    }
    }

