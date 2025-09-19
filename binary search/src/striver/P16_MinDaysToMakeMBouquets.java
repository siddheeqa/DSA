package striver;
//Binary search on answer
//Find the minimum day on which at least m bouquets can be made using k adjacent flowers that bloom on given days, or return -1 if impossible.
public class P16_MinDaysToMakeMBouquets {
    public static boolean possible(int[] nums,int day,int m,int k)
    {
        int n= nums.length;
        //count number of flowers bloomed
        int count=0;
        //count number of bouquets
        int bouquets=0;
        for(int i=0;i<n;i++)
        {
            if(nums[i]<=day)
            {
                count++;
            }
            else {
                bouquets+=(count/k);
                count=0;
            }
        }
        //Add remaining flowers as bouquets
        bouquets+=(count/k);
        return bouquets>=m;
    }
    //Time Complexity:O(log(max-min+1) * N)
    //Space Complexity is O(1)
    public static int roseGardenOptimal(int n,int[] arr,int k,int m)
    {
        //Calculate the minimum number of flowers required
        long val=(long)m*k;
        //Not enough to make m bouquets
        if(val>n) return -1;
        //Find maximum and minimum bloom day for linear search
        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            mini = Math.min(mini, arr[i]);
            maxi = Math.max(maxi, arr[i]);
        }
        //Binary search to find earliest day to make m bouquets
        int left=mini,right=maxi,ans=-1;
        while(left<=right)
        {
            int mid=(left+right)/2;
            if(possible(arr,mid,m,k))
            {
                ans=mid;
                right=mid-1;
            }
            else
                left=mid+1;
        }
        //Return the earliest day or -1 if no such day exists
        return left;
    }
    //Time Complexity:O((max-min+1) * N)
    //Space Complexity is O(1)
    public static int roseGardenBrute(int n,int[] arr,int k,int m)
    {
        //Calculate the minimum number of flowers required
        long val=(long)m*k;
        //Not enough to make m bouquets
        if(val>n) return -1;
        //Find maximum and minimum bloom day for linear search
        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            mini = Math.min(mini, arr[i]);
            maxi = Math.max(maxi, arr[i]);
        }
        //Linear search to find earliest day to make m bouquets
        for(int i=mini;i<=maxi;i++)
            if(possible(arr,i,m,k))
                return i;
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {7, 7, 7, 7, 13, 11, 12, 7};
        int n = arr.length;
        // Number of adjacent flowers per bouquet
        int k = 3;
        // Number of bouquets needed
        int m = 2;
        int ans = roseGardenOptimal(n, arr, k, m);

        if (ans == -1) {
            System.out.println("We cannot make m bouquets.");
        } else {
            System.out.println("We can make bouquets on day " + ans);
        }
    }
}
