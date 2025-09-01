package striver;
//Binary search on answers
public class P13_SquareRoot {
    //Time Complexity:O(logN)
    //Space Complexity:O(1)
    public static long optimal(long n)
    {
        long low=1;
        long high=n;
        while(low<=high)
        {
            long mid=(long)(low+high)/2;
            long val=mid*mid;
            //move to the right part
            if(val<=n)
                low=mid+1;
            //move to the left part
            else
                high=mid-1;
        }
        // Return the floor of square root
        return high;
    }
    //Time Complexity:O(N1/2)
    //Space Complexity:O(1)
    public static long brute(long n)
    {
        long ans=0;
        for(int i=1;i<=n;i++)
        {
            long val=i*i;
            if(val<=n)
            {
                ans=(long)i;
            }
            else
                break;
        }
        return ans;
    }
    public static void main(String[] args) {
        long n = 28;
        long ans = brute(n);
        System.out.println("The floor of square root of " + n
                + " is: " + ans);
    }
}
