package striver;

public class P14_NthRoot {
    //Time Complexity: O(logM * logN)
    //Space Complexity: O(1)
    public static int optimal(int n,int m)
    {
        int low=1;
        int high=m;
        while(low<=high)
        {
            int mid=(low+high)/2;
            int val=(int)Math.pow(mid,n);
            if(val==m) return mid;
            else if(val>m)
                high=mid-1;
            else
                low=mid+1;
        }
        return -1;
    }
    //Time Complexity: O(N*logN)
    //Space Complexity: O(1)
    public static int brute(int n,int m)
    {
        //Linear search on the answer space
        for(int i=1;i<=m;i++)
        {
            long val=(long)Math.pow(i,n);
            if(val==m)
                return i;
            else if(val>m)
                break;
        }
        return -1;
    }
    public static void main(String[] args) {
        int n = 3, m = 27;
        int ans = optimal(n, m);
        System.out.println("The answer is: " + ans);
    }
}
