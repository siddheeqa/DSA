package striver;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
//Find the length of the longest sub array that contains at most two distinct integers (fruits).
public class P6_FruitIntoBaskets {
    //Time Complexity:O(N)
    //Space Complexity: O(3)
    public static int optimal(int[] fruits)
    {
        int n=fruits.length;
        int maxLen=0;
        //Map to track the count of each fruit type in the current window
        HashMap<Integer,Integer> map=new HashMap<>();
        int left=0,right=0;
        while(right<n)
        {
            map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);
            //If number of different fruits exceeds 2 shrink the window from the left
            if(map.size()>2)
            {
                    map.put(fruits[left],map.get(fruits[left])-1);
                    if(map.get(fruits[left])==0)
                        map.remove(fruits[left]);
                    left++;

            }
            if(map.size()<=2)
                maxLen=Math.max(maxLen,right-left+1);
            right++;
        }
        return maxLen;
    }
    //Time Complexity:O(2N)
    //Space Complexity: O(3)
    public static int better(int[] fruits)
    {
        int n=fruits.length;
        int maxLen=0;
        //Map to track the count of each fruit type in the current window
        HashMap<Integer,Integer> map=new HashMap<>();
        int left=0,right=0;
        while(right<n)
        {
            map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);
            //If number of different fruits exceeds 2 shrink the window from the left
            if(map.size()>2)
            {
                while(map.size()>2)
                {
                    map.put(fruits[left],map.get(fruits[left])-1);
                    if(map.get(fruits[left])==0)
                        map.remove(fruits[left]);
                    left++;
                }
            }
            if(map.size()<=2)
                maxLen=Math.max(maxLen,right-left+1);
            right++;
        }
        return maxLen;
    }
    //Time Complexity:O(N2)
    //Space Complexity: O(3)
    public static int brute(int[] fruits)
    {
        int n= fruits.length;
        int maxLen=0;
        //Iterate through all possible starting points of the substring
        for(int i=0;i<n;i++)
        {
            Set<Integer> set=new HashSet<>();
            for(int j=i;j<n;j++)
            {
                set.add(fruits[j]);
                if(set.size()<=2)
                {
                    maxLen=Math.max(maxLen,j-i+1);
                }
                else
                    break;
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int[] input = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        int length = optimal(input);
        System.out.println("Maximum fruits in the basket is: " + length);
    }
}
