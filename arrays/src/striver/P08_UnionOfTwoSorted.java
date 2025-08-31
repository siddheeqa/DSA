package striver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class P08_UnionOfTwoSorted {
    //Time Complexity: O(M+N)
    //Space Complexity: O(M+N)
    public static int[] optimal(int[] nums1,int[] nums2) {
        List<Integer> union = new ArrayList<>();
        int i = 0, j = 0;
        int n = nums1.length;
        int m = nums2.length;
        while (i < n && j < m) {
            if (nums1[i] <= nums2[j]) {
                if (union.isEmpty() || union.get(union.size() - 1) != nums1[i])
                    union.add(nums1[i]);
                i++;
            } else {
                if (union.isEmpty() || union.get(union.size() - 1) != nums2[j])
                    union.add(nums2[j]);
                j++;
            }
        }
        //Add remaining elements of nums1, if any
        while(i<n)
        {
            if (union.isEmpty() || union.get(union.size() - 1) != nums1[i])
                union.add(nums1[i]);
            i++;
        }
        //Add remaining elements of nums2, if any
        while(j<m)
        {
            if (union.isEmpty() || union.get(union.size() - 1) != nums2[j])
                union.add(nums2[j]);
            j++;
        }
        int[] unionArr = new int[union.size()];
        for (int k = 0; k < union.size(); k++) {
            unionArr[k] = union.get(k);
        }

        return unionArr;
    }
    //Time Complexity: O( (M+N)log(M+N) )
    //Space Complexity: O(M+N)
    public static int[] brute(int[] nums1,int[] nums2)
    {
        Set<Integer> set=new TreeSet<>();
        for(int num:nums1)
            set.add(num);
        for(int num:nums2)
            set.add(num);
        //create union array
        int[] union=new int[set.size()];
        int i=0;
        for(int num:set)
            union[i++]=num;
        return union;
    }
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] nums2 = {2, 3, 4, 4, 5, 11, 12};
        int[] union =optimal(nums1, nums2);

        System.out.println("Union of nums1 and nums2 is:");
        for (int val : union) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
