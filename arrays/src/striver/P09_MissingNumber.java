package striver;

public class P09_MissingNumber {
    //Time Complexity: O(N)
    //Space Complexity: O(1)
    public static int optimal2(int[] nums)
    {
        int xor1=0,xor2=0;
        for(int i=0;i<nums.length;i++)
        {
            xor1=xor1^(i+1);
            xor2=xor2^nums[i];
        }
        return xor1^xor2;
    }
    //Time Complexity: O(N)
    //Space Complexity: O(1)
    public static int optimal1(int[] nums)
    {
        int n=nums.length;
        int sum1=(n*(n+1))/2;
        int sum2=0;
        for(int i=0;i<n;i++)
            sum2+=nums[i];
        int missingNum=sum1-sum2;
        return missingNum;
    }
    //Time Complexity: O(N) + O(N)
    //Space Complexity: O(N)
    public static int better(int[] nums)
    {
        int n=nums.length;
        int[] freq=new int[n+1];
        for(int num:nums)
            freq[num]++;
        for(int i=0;i<n;i++)
            if(freq[i]==0) return i;
        //this line never execute
        return -1;
    }
    //Time Complexity: O(N^2)
    //Space Complexity: O(1)
    public static int brute(int[] nums)
    {
        int n=nums.length;
        for(int i=0;i<=n;i++)
        {
            int flag=0;
            for(int j=0;j<n;j++)
            {
                if(nums[j]==i)
                {
                    flag=1;
                    break;
                }
            }
            if(flag==0) return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {0,1, 2, 4};
        int ans = optimal2(nums);
        System.out.println("The missing number is: " + ans);
    }
}
