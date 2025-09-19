package striver;
//Binary search on answer
//Return the min integer k such that koko can eat all bananas within h hours
public class P15_KokoEatingBananas {
    public static long calculateTotalHours(int[] nums,int hourly)
    {
        long totalHour=0;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            totalHour+=Math.ceil((double)nums[i]/(double)hourly);
        }
        return totalHour;
    }
    public static int findMax(int[] nums)
    {
        int maxi=Integer.MIN_VALUE;
        int n=nums.length;
        for(int i=0;i<n;i++)
            maxi=Math.max(maxi,nums[i]);
        return maxi;
    }
    //Time Complexity:O(N * log(max))
    //Space Complexity:O(1)
    public static int optimal(int[] nums,int h)
    {
        int low=1,high=findMax(nums);
        while(low<=high)
        {
            int mid=(low+high)/2;
            long totalHour=calculateTotalHours(nums,mid);
            if(totalHour<=h)
                high=mid-1;
            else
                low=mid+1;
        }
        //At first low at not possible position and high at possible position. In the end it always opposite polarity
        return low;
    }
    //Time Complexity:O(max * N)
    //Space Complexity is O(1)
    public static int brute(int[] nums,int h){
        int maxi=findMax(nums);
        //Find the min integer k such that koko can eat all bananas within h hours
        for(int i=1;i<=maxi;i++)
        {
            long reqTime=calculateTotalHours(nums,i);
            if(reqTime<=(long)h)
                return i;
        }
        return maxi;
    }
    public static void main(String[] args) {
        int[] v = {7, 15, 6, 3};
        int h = 8;
        int ans = optimal(v, h);
        System.out.println("Koko should eat at least " + ans + " bananas/hr.");
    }
}
