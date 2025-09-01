package striver;

//find smallest index where arr[i]>=x
public class P02_LowerBound {
    //Time Complexity: O(log N)
    //Space Complexity: O(1)
    public static int optimal(int[] arr,int x)
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
    //Time Complexity: O(N)
    //Space Complexity: O(1)
    public static int brute(int[] arr,int x)
    {
        int n=arr.length;
        for(int i=0;i<n;i++)
            if(arr[i]>=x)
                return i;
        //if lower bound not found return size of array
        return n;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3};
        int x = 2;
        int ind = optimal(arr, x);

        System.out.println("The lower bound is the index: " + ind);
    }
}
