import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bfs {
    public ArrayList<Integer> bfsOfGraph(int v,ArrayList<ArrayList<Integer>> adj)
    {
        ArrayList<Integer> bfs=new ArrayList<>();
        boolean[] vis=new boolean[v];
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        vis[0]=true;
        while(!q.isEmpty())
        {
            Integer node=q.poll();
            bfs.add(node);
            for(Integer it:adj.get(node))
            {
                if(!vis[it])
                {
                    vis[it]=true;
                    q.add(it);
                }
            }
        }
        return bfs;
    }
    public static void main(String[] args)
    {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<5;i++)
        {
            adj.add(new ArrayList<>());
        }
        //undirected edges
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(4);
        adj.get(4).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);
        Bfs b=new Bfs();
        ArrayList<Integer> ans=b.bfsOfGraph(5,adj);
        int n=ans.size();
        for(int i=0;i<n;i++)
            System.out.println(ans.get(i)+" ");
    }
}
