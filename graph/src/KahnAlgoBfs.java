import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class KahnAlgoBfs {
    public static int[] topoSort(int v,ArrayList<ArrayList<Integer>> adj)
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
    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);

        int[] ans = topoSort(V, adj);
        for (int node : ans) {
            System.out.print(node + " ");
        }
    }
}
