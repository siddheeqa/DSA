package striver;

public class P12_PeakElement {
    //Time Complexity:O(logN)
    //Space Complexity:O(1)
    public static int optimal(int[] arr)
    {
        int n=arr.length;
        //Edge Cases
        if(n==1) return 0;
        if(arr[0]>arr[1]) return 0;
        if(arr[n-1]>arr[n-2]) return n-1;
        int low=1;
        int high=n-2;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1])
                return mid;
            //we are in left part increasing curve
            if(arr[mid]>arr[mid-1])
                low=mid+1;
            else
                high=mid-1;
        }
        return -1;
    }
    //Time Complexity:O(N)
    //Space Complexity:O(1)
    public static int brute(int[] arr)
    {
        int n=arr.length;
        for(int i=0;i<n;i++)
            if((i==0||arr[i-1]<arr[i]) && (i==n-1 || arr[i]>arr[i+1]))
                return i;
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 5, 1};
        int ans = brute(arr);
        System.out.println("The peak is at index: " + ans);
    }
}
