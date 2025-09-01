package striver;

//In this part array contain duplicates
public class P08_SearchRotatedSortedArray2 {
    //Time Complexity: O(logN) for the best and average case. O(N/2)
    //Space Complexity: O(1)
    public static boolean optimal(int[] arr,int k)
    {
        int low=0;
        int high=arr.length-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(arr[mid]==k) return true;
            //Edge case
            //Not guarantee which half is sorted
            if(arr[low]==arr[mid] && arr[mid]==arr[high])
            {
                low++;
                high--;
                continue;
            }
            //if left part is sorted
            if(arr[low]<=arr[mid])
            {
                if(arr[low]<=k && arr[mid]>=k)
                    high=mid-1;
                else
                    low=mid+1;
            }
            else
            {
                if(arr[mid]<=k && k<=arr[high])
                    low=mid+1;
                else
                    high=mid-1;
            }
        }
        return false;
    }
    //Time Complexity: O(N)
    //Space Complexity: O(1)
    public static boolean brute(int[] arr,int k)
    {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == k) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {7, 8, 1, 2, 3, 3, 3, 4, 5, 6};
        int k = 3;
        boolean ans = optimal(arr, k);
        if (ans == false)
            System.out.println("Target is not present.");
        else
            System.out.println("Target is present in the array.");
    }
}
