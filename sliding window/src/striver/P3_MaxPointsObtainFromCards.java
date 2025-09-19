package striver;
//Pick exactly k cards from either the start or the end of the array to maximize the total score.
public class P3_MaxPointsObtainFromCards {
    //Time Complexity:O(2*k)
    public static int maxScore(int[] nums,int k)
    {
        int lsum=0,rsum=0,maxSum=0;
        for(int i=0;i<k;i++)
            lsum+=nums[i];
        maxSum=lsum;
        int rightIndex=nums.length-1;
        for(int i=k-1;i>=0;i--)
        {
            lsum=lsum-nums[i];
            rsum=rsum+nums[rightIndex];
            rightIndex--;
            maxSum=Math.max(maxSum,lsum+rsum);
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int k=3;
        int result = maxScore(nums, k);
        System.out.println("The maximum score is:");
        System.out.println(result);
    }
}
