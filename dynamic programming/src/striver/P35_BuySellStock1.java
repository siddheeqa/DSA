package striver;

public class P35_BuySellStock1 {
    public static int func(int[] arr, int n)
    {
        int maxProfit=0;
        int mini=arr[0];
        for(int i=1;i<n;i++)
        {
            int curProfit=arr[i]-mini;
            maxProfit=Math.max(maxProfit,curProfit);
            mini=Math.min(mini,arr[i]);
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int[] Arr = {7, 1, 5, 3, 6, 4};
        int n = 6;
        System.out.println("The maximum profit by selling the stock is " + func(Arr, n));
    }
}
