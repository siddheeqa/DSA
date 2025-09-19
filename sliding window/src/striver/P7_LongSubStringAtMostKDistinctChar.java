package striver;

import java.util.HashMap;

//Find the length of the longest substring that contains at most k distinct characters.
public class P7_LongSubStringAtMostKDistinctChar {
    //Time Complexity:O(N)
    //Space Complexity: O(k)
    public static int optimal(String s,int k)
    {
        int n=s.length();
        int left=0,right=0,maxLen=0;
        //Hashmap to store character frequencies
        HashMap<Character,Integer> map=new HashMap<>();
        while(right<n)
        {
            char currentChar=s.charAt(right);
            map.put(currentChar,map.getOrDefault(currentChar,0)+1);
            //If the number of distinct characters exceeds k, shrink the window from the left
            if(map.size()>k)
            {
                char leftChar=s.charAt(left);
                map.put(leftChar,map.get(leftChar)-1);
                if(map.get(leftChar)==0)
                    map.remove(leftChar);
                left++;
            }
            if(map.size()<=k)
            {
                maxLen=Math.max(maxLen,right-left+1);
            }
            right++;
        }
        return maxLen;
    }
    //Time Complexity:O(2N)
    //Space Complexity: O(k)
    public static int better(String s,int k)
    {
        int n=s.length();
        int left=0,right=0,maxLen=0;
        //Hashmap to store character frequencies
        HashMap<Character,Integer> map=new HashMap<>();
        while(right<n)
        {
            char currentChar=s.charAt(right);
            map.put(currentChar,map.getOrDefault(currentChar,0)+1);
            //If the number of distinct characters exceeds k, shrink the window from the left
            while(map.size()>k)
            {
                char leftChar=s.charAt(left);
                map.put(leftChar,map.get(leftChar)-1);
                if(map.get(leftChar)==0)
                    map.remove(leftChar);
                left++;
            }
            if(map.size()<=k)
            {
                maxLen=Math.max(maxLen,right-left+1);
            }
            right++;
        }
        return maxLen;
    }
    //Time Complexity:O(N2)
    //Space Complexity: O(k)
    public static int brute(String s,int k)
    {
        int maxLen=0;
        //Map to track the count of each character in the current window
        HashMap<Character,Integer> map=new HashMap<>();
        //Iterate through all possible starting points of the substring
        for(int i=0;i<s.length();i++)
        {
            map.clear();
            for(int j=i;j<s.length();j++)
            {
                char ch=s.charAt(j);
                map.put(ch,map.getOrDefault(ch,0)+1);
                if(map.size()<=k)
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
        String s = "aaabbccd";
        int k = 2;
        int length = optimal(s, k);
        System.out.println("Maximum length of substring with at most " + k + " distinct characters: " + length);
    }
}
