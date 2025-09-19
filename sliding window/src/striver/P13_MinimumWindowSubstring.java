package striver;
//Find the smallest substring of s that contains all characters of t
public class P13_MinimumWindowSubstring {
    //Time Complexity:O(2N + M ), where N is the size of the string s and M is the size of the string t
    //Space Complexity: O(256)
    public static String optimal(String s,String t)
    {
        int minLen=Integer.MAX_VALUE;
        int sIndex=-1;
        int[] hash=new int[256];
        for(char ch:t.toCharArray())
            hash[ch]++;
        int count=0;
        int left=0,right=0,n=s.length();
        while(right<n)
        {
            //Include the current character in the window
            if(hash[s.charAt(right)]>0)
                count++;
            hash[s.charAt(right)]--;
            //If all characters from t are found in current window(minimize the window size)
            while(count==t.length())
            {
                //Update minLen and sIndex if current window is smaller
                if(right-left+1<minLen)
                {
                    minLen=right-left+1;
                    sIndex=left;
                }
                //Remove leftmost character from the window
                hash[s.charAt(left)]++;
                if(hash[s.charAt(left)]>0)
                {
                    count--;
                }
                left++;
            }
            right++;
        }
        return (sIndex==-1)?"":s.substring(sIndex,sIndex+minLen);
    }
    //Time Complexity:O(N2)
    //Space Complexity: O(256)
    public static String brute(String s,String t)
    {
        int minLen=Integer.MAX_VALUE;
        int sIndex=-1;
        for(int i=0;i<s.length();i++)
        {
            // Array to count frequencies of characters in t
            int[] hash=new int[256];
            for(char ch:t.toCharArray())
                hash[ch]++;
            int count=0;
            for(int j=i;j<s.length();j++)
            {
                if(hash[s.charAt(j)]>0)
                    count++;
                hash[s.charAt(j)]--;
                //If all characters from t are found in current window
                if(count==t.length())
                {
                    //Update minLen and sIndex if current window is smaller
                    if(j-i+1<minLen)
                    {
                        minLen=j-i+1;
                        sIndex=i;
                    }
                    break;
                }
            }
        }
        return (sIndex==-1)?"":s.substring(sIndex,sIndex+minLen);
    }
    public static void main(String[] args) {
        String s = "ddaaabbca";
        String t = "abc";
        String ans =optimal(s,t);
        System.out.println("Minimum length substring containing all characters from \"" + t + "\" is: " + ans);
    }
}
