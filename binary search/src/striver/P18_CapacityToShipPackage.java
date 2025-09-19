package striver;
//Find the minimum ship capacity required to deliver all packages within D days while maintaining their given order.
public class P18_CapacityToShipPackage {
    public static int findDays(int[] weights,int capacity)
    {
        int days=1;
        int load=0;
        int n=weights.length;
        for(int i=0;i<n;i++)
        {
            if(load+weights[i]>capacity)
            {
                days+=1;
                load=weights[i];
            }
            else {
                load+=weights[i];
            }
        }
        return days;
    }
    //Time Complexity: O(N * log(sum(weights[]) - max(weights[]) + 1))
    //Space Complexity: O(1)
    public static int optimal(int[] weights,int d)
    {
        //Find the maximum and the summation-This is the limit for capacity
        int low = Integer.MIN_VALUE, high = 0;
        for (int i = 0; i < weights.length; i++) {
            high += weights[i];
            low = Math.max(low, weights[i]);
        }
        while (low <= high) {
            int mid = (low + high) / 2;
            int numberOfDays = findDays(weights, mid);
            if (numberOfDays <= d) {
                //eliminate right half
                high = mid - 1;
            } else {
                //eliminate left half
                low = mid + 1;
            }
        }
        return low;
    }
    //Time Complexity: O(N * (sum(weights[]) - max(weights[]) + 1))
    //Space Complexity: O(1)
    public static int brute(int[] weights,int d)
    {
        //Find the maximum and the summation-This is the limit for capacity
        int maxi = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
            maxi = Math.max(maxi, weights[i]);
        }
        for(int i=maxi;i<=sum;i++)
        {
            //Find how many days to ship all packages with the given capacity
            if(findDays(weights,i)<=d)
            {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] weights = {5, 4, 5, 2, 3, 4, 5, 6};
        int d = 5;
        int ans = optimal(weights, d);
        System.out.println("The minimum capacity should be: " + ans);
    }
}
