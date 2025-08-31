package striver;

import java.util.ArrayList;
import java.util.List;

public class P18_RearrangePosNegAlternate {
    //Time Complexity: O(N)
    //Space Complexity: O(N)
    public static int[] optimal(int[] nums)
    {
        int n=nums.length;
        int[] ans=new int[n];
        int posIndex=0;
        int negIndex=1;
        for(int i=0;i<n;i++)
        {
            if(nums[i]<0)
            {
                ans[negIndex]=nums[i];
                negIndex+=2;
            }
            else
            {
                ans[posIndex]=nums[i];
                posIndex+=2;
            }
        }
        return ans;
    }
    //Time Complexity: O(N+N/2)
    //Space Complexity: O(N/2 + N/2)
    public static int[] brute(int[] nums)
    {
        int n=nums.length;
        List<Integer> pos=new ArrayList<>();
        List<Integer> neg=new ArrayList<>();
        //segregation
        for(int i=0;i<n;i++) {
            if (nums[i] > 0) pos.add(nums[i]);
            else neg.add(nums[i]);
        }
        for(int i=0;i<n/2;i++)
        {
            nums[2*i]=pos.get(i);
            nums[2*i+1]=neg.get(i);
        }
        return nums;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, -4, -5};
        int[] ans = brute(arr);
        for (int num : ans) {
            System.out.print(num + " ");
        }
    }
}
