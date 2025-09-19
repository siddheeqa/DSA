package striver;

public class P24_MediumOfTwoSortedArray {
    //Time Complexity:O(N1+N2)
    //Space Complexity is O(1)
    public static double better(int[] arr1,int[] arr2) {
        int n1 = arr1.length, n2 = arr2.length;
        int n = n1 + n2;
        //Required indices for median calculation
        int ind1 = n / 2;
        int ind2 = ind1 - 1;
        int count = 0;
        int ind1el = -1, ind2el = -1;
        //Apply merge step
        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) {
                if (count == ind1)
                    ind1el = arr1[i];
                if (count == ind2)
                    ind2el = arr1[i];
                count++;
                i++;
            } else {
                if (count == ind1)
                    ind1el = arr2[j];
                if (count == ind2)
                    ind2el = arr2[j];
                count++;
                j++;
            }
        }
        //Copy the remaining elements
        while (i < n1) {
                if (count == ind1)
                    ind1el = arr1[i];
                if (count == ind2)
                    ind2el = arr1[i];
                count++;
                i++;
            }
            while (j < n2) {
                if (count == ind1)
                    ind1el = arr2[j];
                if (count == ind2)
                    ind2el = arr2[j];
                count++;
                j++;
            }
        if(n%2==1) return (double) ind1el;
        return (double) ((double)(ind1el+ind2el))/2.0;
    }

        //Time Complexity:O(N1+N2)
        //Space Complexity:O(N1+N2)
        public static double brute(int[] arr1, int[] arr2)
        {
            int n1 = arr1.length;
            int n2 = arr2.length;
            int[] merged = new int[n1 + n2];
            //Apply the merge step
            int i = 0, j = 0, k = 0;
            while (i < n1 && j < n2) {
                if (arr1[i] < arr2[j])
                    merged[k++] = arr1[i++];
                else
                    merged[k++] = arr2[j++];
            }
            //Copy the remaining elements
            while (i < n1) merged[k++] = arr1[i++];
            while (j < n2) merged[k++] = arr2[j++];

            //Find the medium
            int n = n1 + n2;
            if (n % 2 == 1)
                return (double) merged[n / 2];
            double median = ((double) merged[n / 2] + (double) merged[n / 2 - 1]) / 2.0;
            return median;
        }

    public static void main(String[] args) {
        int[] a = {1, 4, 7, 10, 12};
        int[] b = {2, 3, 6, 15};
        System.out.println("The median of two sorted arrays is " + better(a, b));
    }
}
