package striver;

public class P01_BinarySearch {
    public static int recursive(int[] arr,int low,int high,int target)
    {
        if(low>high) return -1;
        //to store the index of target
        int ans;
        int mid=(low+high)/2;
        if(arr[mid]==target) ans= mid;
        //search in left space
        else if(arr[mid]>target)
            ans=recursive(arr,low,mid-1,target);
        //search in right space
        else
            ans=recursive(arr,mid+1,high,target);
        return ans;
    }
    public static int iterative(int[] arr,int target) {
        int n=arr.length;
        //Pointers to define the search space
        int low=0;
        int high=n-1;
        //until the search space is not empty
        while(low<=high) {
            int mid = (low + high) / 2;
            if(arr[mid]==target)
                return mid;
            else if(arr[mid]>target)
                high=mid-1;
            else
                low=mid+1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] a = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        int ind = recursive(a, 0,a.length-1,target);

        if (ind == -1)
            System.out.println("The target is not present.");
        else
            System.out.println("The target is at index: " + ind);
    }
    }
