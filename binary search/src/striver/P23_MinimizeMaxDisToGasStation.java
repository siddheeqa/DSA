package striver;

import java.util.PriorityQueue;

public class P23_MinimizeMaxDisToGasStation {
    private static int numberOfGasStationsRequired(double dist, int[] arr) {
        // Size of the array
        int n = arr.length;
        int cnt = 0;
        for (int i = 1; i < n; i++) {

            /* Calculate number of gas stations
            needed between two points*/
            int numberInBetween = (int) ((arr[i] - arr[i - 1]) / dist);

            // Adjust if exact distance fits perfectly
            if ((arr[i] - arr[i - 1]) == (dist * numberInBetween)) {
                numberInBetween--;
            }

            cnt += numberInBetween;
        }
        return cnt;
    }
    public static double minimiseMaxDistanceOptimal(int[] arr,int k)
    {
        int n=arr.length;
        double low=0;
        double high=0;
        //Find the maximum distance between consecutive gas stations
        for (int i = 0; i < n - 1; i++) {
            high = Math.max(high, arr[i + 1] - arr[i]);
        }
        double diff = 1e-6;
        while (high - low > diff) {
            double mid = (low + high) / 2.0;
            int cnt = numberOfGasStationsRequired(mid, arr);

            /* Adjust the search range based on
            the number of gas stations required*/
            if (cnt > k) {
                low = mid;
            } else {
                high = mid;
            }
        }
        // Return smallest maximum distance found
        return high;
    }
    //Time Complexity:O(NlogN + klogN)
    //Space Complexity:O(N-1)+O(N-1)
    public static double minimiseMaxDistanceBetter(int[] arr,int k)
    {
        int n=arr.length;
        //Arrays to store how many gas stations are placed in each section
        int[] howMany=new int[n-1];
        // Max heap of double[]: [distance, sectionIndex]
        PriorityQueue<double[]> pq=new PriorityQueue<>((a,b)->Double.compare(b[0],a[0]));
        for(int i=0;i<n-1;i++)
        {
            double dist=arr[i+1]-arr[i];
            pq.offer(new double[]{dist,i});
        }
        for(int gasStations=1;gasStations<=k;gasStations++)
        {
            double[] top=pq.poll();
            int secInd=(int)top[1];
            howMany[secInd]++;
            double sectionLength=arr[secInd+1]-arr[secInd];
            double newSectionLength=sectionLength/(howMany[secInd]+1);
            pq.offer(new double[]{newSectionLength,secInd});
        }
        return pq.peek()[0];
    }
    //Time Complexity:O(k*N) + O(N)
    //Space Complexity: O(N-1)
    public static double minimiseMaxDistanceBrute(int[] arr,int k)
    {
        int n=arr.length;
        //Arrays to store how many gas stations are placed in each section
        int[] howMany=new int[n-1];
        //Pick and place gas station
        for(int gasStation=1;gasStation<=k;gasStation++)
        {
            double maxSection=-1;
            int maxInd=-1;
            //Find max section and insert the gas station
            for(int i=0;i<n-1;i++)
            {
                double diff=arr[i+1]-arr[i];
                double sectionLength=diff/(double)(howMany[i]+1);
                if(sectionLength>maxSection)
                {
                    maxSection=sectionLength;
                    maxInd=i;
                }
            }
            howMany[maxInd]++;
        }
        //Find the maximum difference between them in answer
        double maxAns=-1;
        for(int i=0;i<n-1;i++)
        {
            double diff=arr[i+1]-arr[i];
            double sectionLength=diff/(double)(howMany[i]+1);
            maxAns=Math.max(maxAns,sectionLength);
        }
        return maxAns;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;
        double ans = minimiseMaxDistanceOptimal(arr, k);
        System.out.println("The answer is: " + ans);
    }
}
