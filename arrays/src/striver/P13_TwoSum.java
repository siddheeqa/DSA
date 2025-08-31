package striver;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class P13_TwoSum {
    public static int[] optimal(int[] nums,int target)
    {
        int n=nums.length;
        // Array to store indices of two numbers
        int[] ans=new int[2];
        // 2D array to store {element, index} pairs
        int[][] eleIndex=new int[n][2];
        for(int i=0;i<nums.length;i++)
        {
            eleIndex[i][0]=nums[i];
            eleIndex[i][1]=i;
        }
        //each element of eleIndex is an int[]
        Arrays.sort(eleIndex,new Comparator<int[]>()
        {
            public int compare(int[] a,int[] b){
                return Integer.compare(a[0],b[0]);
            }
        });
        //initialize two pointers
        int left=0,right=n-1;
        while(left<right)
        {
            int sum=eleIndex[left][0]+eleIndex[right][0];
            if(sum==target)
            {
                ans[0]=eleIndex[left][1];
                ans[1]=eleIndex[right][1];
                return ans;
            }
            else if(sum<target)
                left++;
            else
                right--;
        }
        return new int[]{-1,-1};
    }
    public static int[] better(int[] nums,int target)
    {
        //storing element and index
        Map<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            int num=nums[i];
            int moreNeeded=target-num;
            if(map.containsKey(moreNeeded))
            return new int[]{map.get(moreNeeded),i};
            map.put(num,i);
        }
        return new int[]{-1,-1};
    }
    public static int[] brute(int[] nums,int target)
    {
        int n = nums.length;
        //create ans array to store ans
        int[] ans = new int[2];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return new int[]{-1,-1};
    }
    public static void main(String[] args)
    {
        int n=5;
        int[] nums = {2, 6, 5, 8, 11};
        int target = 14;
        int[] ans=optimal(nums,target);
        System.out.println("This is the answer: [" + ans[0] + ", " + ans[1] + "]");
    }
}
