package striver;

//floor-largest number in array <=x
//ceil- smallest number in array >=x
public class P04_FloorCeil {
    public static int findFloor(int[] arr,int x)
    {
        int low=0;
        int high=arr.length-1;
        int ans=-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(arr[mid]<=x) {
                ans = arr[mid];
                low=mid+1;
            }
            else
                high=mid-1;
        }
        return ans;
    }
    public static int findCeil(int[] arr,int x)
    {
        int low=0;
        int high=arr.length-1;
        int ans=-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(arr[mid]>=x) {
                ans = arr[mid];
                //I want smallest index
                high=mid-1;
            }
            else
                low=mid+1;
        }
        return ans;
    }
    public static int[] optimal(int[] nums,int x)
    {
        int n = nums.length;
        int floor = findFloor(nums, x);
        int ceil = findCeil(nums, x);
        return new int[] {floor,ceil};
    }
    //Time Complexity: O(N)
    //Space Complexity: O(1)
    public static int[] brute(int[] nums,int x)
    {
        int floor=-1,ceil=-1;
        for(int num:nums)
        {
            if(num<=x && num>floor) floor=num;
            if(num>=x && (ceil==-1 || num<ceil)) ceil=num;
        }
        return new int[]{floor,ceil};
    }
    public static void main(String[] args) {
        int[] nums = {3, 4, 4, 7, 8, 10};
        int x = 5;
        int[] res = optimal(nums, x);
        System.out.println(res[0] + " " + res[1]);
    }
}
