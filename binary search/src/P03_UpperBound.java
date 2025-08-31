//Smallest index such that arr[i]>x
public class P03_UpperBound {
    //Time Complexity: O(logN)
    //Space Complexity: O(1)
    public static int optimal(int[] arr,int x)
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
    //Time Complexity: O(N)
    //Space Complexity: O(1)
    public static int brute(int[] arr,int x)
    {
        int n=arr.length;
        for(int i=0;i<n;i++)
            if(arr[i]>x)
                return i;
        return n;
    }
    public static void main(String[] args) {
        int[] nums = {3, 5, 8, 9, 15, 19};
        int x = 9;
        int ind = optimal(nums, x);
        System.out.println("The upper bound is the index: " + ind);
    }
    }
