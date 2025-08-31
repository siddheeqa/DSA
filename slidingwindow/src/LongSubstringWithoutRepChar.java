import java.util.HashMap;

/*
public class LongSubstringWithoutRepChar{
    public static void main(String[] args) {
        String s="cadbzabcd";
        int maxLen=0;
        for(int i=0;i<s.length();i++)
        {
            Set<Character> set=new HashSet<>();
            for(int j=i;j<s.length();j++)
            {
                if(set.contains(s.charAt(j)))
                {
                    break;
                }
                maxLen=Math.max(maxLen,j-i+1);
                set.add(s.charAt(j));
            }
        }
        System.out.println(maxLen);
    }
}
 */
public class LongSubstringWithoutRepChar {
    public static void main(String[] args) {
        String s="cadbzabcd";
        int maxLen=0;
        int left=0,right=0;
        int n=s.length();
        HashMap<Character,Integer> map=new HashMap<>();
        while(right<n)
        {
            char current=s.charAt(right);
            if(map.containsKey(current) && map.get(current)>=left)
                left=map.get(current)+1;
            maxLen=Math.max(maxLen,right-left+1);
            map.put(current,right);
            right++;
        }
        System.out.println(maxLen);
    }
}

