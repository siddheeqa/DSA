import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictionary {
    public static int[] topoSort(int v,List<List<Integer>> adj)
    {
        int[] inDegree=new int[v];
        for(int i=0;i<v;i++)
        {
            for(int it:adj.get(i))
            {
                inDegree[it]++;
            }
        }
        Queue<Integer> queue=new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int[] topo=new int[v];
        int i=0;
        while(!queue.isEmpty())
        {
            int node=queue.peek();
            queue.remove();
            topo[i++]=node;
            for(int it:adj.get(node))
            {
                inDegree[it]--;
                if(inDegree[it]==0)
                    queue.add(it);
            }
        }
        return topo;
    }
    public static String findOrder(String [] dict, int n, int k)
    {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<k;i++)
            adj.add(new ArrayList<>());
        for(int i=0;i<n-1;i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];
            int len = Math.min(s1.length(), s2.length());
            for (int ptr = 0; ptr < len; ptr++) {
                if (s1.charAt(ptr) != s2.charAt(ptr)) {
                    adj.get(s1.charAt(ptr) - 'a').add(s2.charAt(ptr) - 'a');
                    break;
                }
            }
        }
            int[] topo=topoSort(k,adj);
            String ans="";
            for (int it : topo) {
                ans = ans + (char)(it + (int)('a'));
            }
            return ans;
        }
    public static void main(String[] args) {
        int N = 5, K = 4;
        String[] dict = {"baa", "abcd", "abca", "cab", "cad"};
        String ans =findOrder(dict, N, K);
        System.out.println(ans);
    }
}
