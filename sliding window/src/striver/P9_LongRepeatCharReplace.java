package striver;
//Find the length of the longest substring that can be obtained by replacing at most k characters so that all characters in it are the same.
public class P9_LongRepeatCharReplace {
    //Time Complexity:O(N)
    //Space Complexity: O(26)
    public static int optimal(String s,int k)
    {
        int n=s.length();
        int maxLen=0;
        int maxFreq=0;
        int left=0,right=0;
        int[] hash=new int[26];
        while(right<n)
        {
            hash[s.charAt(right)-'A']++;
            maxFreq=Math.max(maxFreq,hash[s.charAt(right)-'A']);
            // Check if current window is invalid
            if((right-left+1)-maxFreq>k)
            {
                hash[s.charAt(left)-'A']--;
                left++;
            }
            maxLen=Math.max(maxLen,right-left+1);
            right++;
        }
        return maxLen;
    }
    //Time Complexity:O((N+N) * 26)
    //Space Complexity: O(26)
    public static int better(String s,int k)
    {
        int n=s.length();
        int maxLen=0;
        int maxFreq=0;
        int left=0,right=0;
        int[] hash=new int[26];
        while(right<n)
        {
            hash[s.charAt(right)-'A']++;
            maxFreq=Math.max(maxFreq,hash[s.charAt(right)-'A']);
            // Check if current window is invalid
            while((right-left+1)-maxFreq>k)
            {
                //Slide the left pointer to make the window valid again
                hash[s.charAt(left)-'A']--;
                //Recalculate maxFreq for current window
                maxFreq=0;
                for(int i=0;i<26;i++)
                    maxFreq=Math.max(maxFreq,hash[i]);
                left++;
            }
            maxLen=Math.max(maxLen,right-left+1);
            right++;
        }
        return maxLen;
    }
    //Time Complexity:O(N2)
    //Space Complexity: O(26)
    public static int brute(String s,int k)
    {
        int n=s.length();
        int maxLen=0;
        //Variable to track the maximum frequency  of any single character in the current window
        int maxFreq=0;
        for(int i=0;i<n;i++)
        {
            int[] hash=new int[26];
            for(int j=i;j<n;j++)
            {
                // Update frequency of current character in the hash array
                hash[s.charAt(j)-'A']++;
                maxFreq=Math.max(maxFreq,hash[s.charAt(j) - 'A']);
                int changes=(j-i+1)-maxFreq;
                // If the number of changes is less than or equal to k, the current window is valid
                if(changes<=k)
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
        String s = "AABABBA";
        int k = 2;
        int length = better(s, k);
        System.out.println("Maximum length of substring with at most " + k + " characters replaced: " + length);
    }
}
