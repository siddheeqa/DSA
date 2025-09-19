package striver;
//Count the number of substrings of a given string that contain at least one 'a', one 'b', and one 'c'.
public class P8_NoOfSubStringContainAll3Char {
    //Time Complexity:O(N)
    //Space Complexity: O(1)
    public static int optimal(String s)
    {
        int[] lastSeen={-1,-1,-1};
        int count=0;
        int n=s.length();
        for(int i=0;i<s.length();i++)
        {
            lastSeen[s.charAt(i)-'a']=i;
            //check if all characters have been seen
            if(lastSeen[0]!=-1 && lastSeen[1]!=-1 && lastSeen[2]!=-1)
            {
                //count valid substrings ending at current index
                count+=1+Math.min(Math.min(lastSeen[0],lastSeen[1]),lastSeen[2]);
            }
        }
        return count;
    }
    //Time Complexity:O(N2)
    //Space Complexity: O(1)
    public static int better(String s)
    {
        int count=0;
        int n=s.length();
        // Iterate through each starting point of substring
        for(int i=0;i<n;i++)
        {
            int[] hash=new int[3];
            // Iterate through each ending point of substring
            for(int j=i;j<n;j++)
            {
                hash[s.charAt(j)-'a']=1;
                //check if all characters are present
                if(hash[0]+hash[1]+hash[2]==3)
                {
                    //Increment count for valid substring
                    count+=n-j;
                    break;
                }
            }
        }
        return count;
    }
    //Time Complexity:O(N2)
    //Space Complexity: O(1)
    public static int brute(String s)
    {
        int count=0;
        // Iterate through each starting point of substring
        for(int i=0;i<s.length();i++)
        {
            int[] hash=new int[3];
            // Iterate through each ending point of substring
            for(int j=i;j<s.length();j++)
            {
                hash[s.charAt(j)-'a']=1;
                //check if all characters are present
                if(hash[0]+hash[1]+hash[2]==3)
                {
                    //Increment count for valid substring
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        String s = "bbacba";
        int ans = optimal(s);
        System.out.println("Number of substrings containing 'a', 'b', 'c' in \"" + s + "\" is: " + ans);
    }
}
