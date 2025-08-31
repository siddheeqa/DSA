package striver;

public class P17_BestTimeBuyStock {
    //Time Complexity:O(N)
    //Space Complexity:O(1)
    public static int stockBuySell(int[] arr,int n)
    {
        int maxProfit=0;
        int mini=arr[0];
        for(int i=1;i<n;i++)
        {
            int currentProfit=arr[i]-mini;
            maxProfit=Math.max(maxProfit,currentProfit);
            //update mini to minimum value encountered so far
            mini=Math.min(mini,arr[i]);
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        int n = 6;
        System.out.println("The maximum profit by selling the stock is " + stockBuySell(arr, n));
    }
}
