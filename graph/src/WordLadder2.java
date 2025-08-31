import java.util.*;

public class WordLadder2 {
    static ArrayList<ArrayList<String>> findSequences(String startWord,String targetWord,String[] wordList)
    {
        Set<String> set=new HashSet<String>();
        int len=wordList.length;
        for(String word:wordList)
            set.add(word);
        Queue<ArrayList<String>> queue=new LinkedList<>();
        ArrayList<String> ls=new ArrayList<>();
        ls.add(startWord);
        queue.add(ls);
        ArrayList<String> usedOnLevel=new ArrayList<>();
        usedOnLevel.add(startWord);
        int level=0;
        ArrayList<ArrayList<String>> ans=new ArrayList<>();
        while(!queue.isEmpty())
        {
            ArrayList<String> vec= queue.peek();
            queue.remove();
            //now erase all words that have been used in the previous levels
            if(vec.size()>level)
            {
                level++;
                for(String it:usedOnLevel)
                    set.remove(it);
                usedOnLevel.clear();
            }
            String word=vec.get(vec.size()-1);
            if(word.equals(targetWord))
            {
                if(ans.size()==0)
                    ans.add(vec);
                else if(ans.get(0).size()== vec.size())
                    ans.add(vec);
            }
            for(int i=0;i<word.length();i++)
            {
                for(char c='a';c<='z';c++)
                {
                    char[] replacedCharArray=word.toCharArray();
                    replacedCharArray[i]=c;
                    String replacedWord=new String(replacedCharArray);
                    if(set.contains(replacedWord))
                    {
                        vec.add(replacedWord);
                        ArrayList<String> temp=new ArrayList<>(vec);
                        queue.add(temp);
                        usedOnLevel.add(replacedWord);
                        vec.remove(vec.size()-1);
                    }
                }
            }
        }
        return ans;
    }
    static class comp implements Comparator< ArrayList < String >> {

        public int compare(ArrayList < String > a, ArrayList < String > b) {
            String x = "";
            String y = "";
            for (int i = 0; i < a.size(); i++)
                x += a.get(i);
            for (int i = 0; i < b.size(); i++)
                y += b.get(i);
            return x.compareTo(y);
        }
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
        ArrayList <ArrayList< String >> ans = findSequences(startWord, targetWord, wordList);

        // If no transformation sequence is possible.
        if (ans.size() == 0)
            System.out.println(-1);
        else {

            Collections.sort(ans, new comp());
            for (int i = 0; i < ans.size(); i++) {
                for (int j = 0; j < ans.get(i).size(); j++) {
                    System.out.print(ans.get(i).get(j) + " ");
                }
                System.out.println();
            }
        }
    }
}
