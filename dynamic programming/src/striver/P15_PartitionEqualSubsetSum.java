package striver;

public class P15_PartitionEqualSubsetSum {
    //similarly memoization, tabulation and space optimization
    public static boolean recursionRecur(int ind,int[] arr,int target)
    {
        //base case
        if(target==0) return true;
        if(ind==0) return arr[0]==target;
        //Try not to take the current element into subset
        boolean notTake=recursionRecur(ind-1,arr,target);
        boolean take=false;
        if(arr[ind]<=target)
            take=recursionRecur(ind-1,arr,target-arr[ind]);
        return notTake || take;
    }
    public static boolean recursion(int n,int[] arr)
    {
        int totalSum=0;
        for(int i=0;i<n;i++)
            totalSum+=arr[i];
        // If the total sum is odd, it cannot be partitioned into two equal subsets
        if(totalSum%2==1) return false;
        else {
            int k=totalSum/2;
            return recursionRecur(n-1,arr,k);
        }
    }
    public static void main(String[] args) {
        int[] arr = {2, 3, 3, 3, 4, 5};
        int n = arr.length;
        if (recursion(n, arr))
            System.out.println("The Array can be partitioned into two equal subsets");
        else
            System.out.println("The Array cannot be partitioned into two equal subsets");
    }
}
