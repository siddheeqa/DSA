import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder1 {
    static class Pair {
        String first;
        int second;
        Pair(String _first, int _second) {
            this.first = _first;
            this.second = _second;
        }
    }
    public static int wordLadderLength(String startWord,String targetWord,String[] wordList)
    {
        Queue<Pair> queue=new LinkedList<>();
        queue.add(new Pair(startWord,1));
        Set<String> st=new HashSet<String>();
        int len=wordList.length;
        for(int i=0;i<len;i++)
            st.add(wordList[i]);
        st.remove(startWord);
        while(!queue.isEmpty())
        {
            String word=queue.peek().first;
            int steps=queue.peek().second;
            queue.remove();
            if(word.equals(targetWord)) return steps;
            for(int i=0;i<word.length();i++)
            {
                for(char ch='a';ch<='z';ch++)
                {
                    char[] replacedCharArray=word.toCharArray();
                    replacedCharArray[i]=ch;
                    String replacedWord=new String(replacedCharArray);
                    if(st.contains(replacedWord))
                    {
                        st.remove(replacedWord);
                        queue.add(new Pair(replacedWord,steps+1));
                    }
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        String startWord = "der", targetWord = "dfs";
        String[] wordList = {
                "des",
                "der",
                "dfr",
                "dgt",
                "dfs"
        };
        int ans = wordLadderLength(startWord, targetWord, wordList);
        System.out.print(ans);
    }
}
