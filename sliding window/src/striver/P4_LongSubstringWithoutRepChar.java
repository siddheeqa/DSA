package striver;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
//Find the length of the longest substring without repeating characters
public class P4_LongSubstringWithoutRepChar {
    //Time Complexity: O(n)
    //Space Complexity: O(min(n, charset_size))
    public static int optimal(String s)
    {
        HashMap<Character,Integer> map=new HashMap<>();
        int n=s.length(),left=0,right=0,maxLen=0;
        while(right<n)
        {
            char current=s.charAt(right);
            if(map.containsKey(current) && map.get(current)>=left) {
                left = map.get(current) + 1;
            }
            map.put(current,right);
            maxLen=Math.max(right-left+1,maxLen);
            right++;
        }
        return maxLen;
    }
    //Worst-case Time Complexity = O(n²)
    //Space Complexity = O(min(n, charset_size))
    public static int brute(String s)
    {
        int n=s.length();
        int maxLen=0;
        //Iterate through all possible starting points of the substring
        for(int i=0;i<n;i++)
        {
            Set<Character> seen=new HashSet<>();
            for(int j=i;j<n;j++)
            {
                char ch=s.charAt(j);
                if(seen.contains(ch))
                {
                    break;
                }
                seen.add(ch);
                maxLen=Math.max(maxLen,j-i+1);
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        String input = "cadbzabcd";
        int length = optimal(input);
        System.out.println("Length of longest substring without repeating characters: " + length);
    }
}
