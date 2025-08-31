import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BipartiteGraphBfs {
    public static boolean check(int start,int v,ArrayList<ArrayList<Integer>> adj,int[] color)
    {
        Queue<Integer> queue=new LinkedList<>();
        queue.add(start);
        color[start]=1;
        while(!queue.isEmpty())
        {
            int node=queue.peek();
            queue.remove();
            for(int it:adj.get(node))
            {
                if(color[it]==0)
                {
                    if(color[node]==1)
                        color[it]=2;
                    else
                        color[it]=1;
                    queue.add(it);
                }
                else if(color[it]==color[node])
                    return false;
            }
        }
        return true;
    }
    public static boolean isBipartite(int v,ArrayList<ArrayList<Integer>> adj)
    {
        int[] color=new int[v];
        for(int i=0;i<v;i++)
        {
            if(color[i]==0)
            {
                if(check(i,v,adj,color)==false)
                    return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 6; i++) adj.add(new ArrayList<>());

        adj.get(0).add(3);
        adj.get(0).add(4);

        adj.get(1).add(4);
        adj.get(1).add(5);

        adj.get(2).add(3);
        adj.get(2).add(5);

        adj.get(3).add(0);
        adj.get(3).add(2);

        adj.get(4).add(0);
        adj.get(4).add(1);

        adj.get(5).add(1);
        adj.get(5).add(2);
        if(isBipartite(6,adj))
            System.out.println("Bipartite");
        else
            System.out.println("Not Bipartite");
    }
}
