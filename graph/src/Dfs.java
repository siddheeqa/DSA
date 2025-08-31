import java.util.ArrayList;

public class Dfs {
    public static void dfs(int node,boolean vis[],ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> ans)
    {
        vis[node]=true;
        ans.add(node);
        //getting neighbour nodes
        for(Integer it:adj.get(node))
        {
            if(!vis[it])
            {
                dfs(it,vis,adj,ans);
            }
        }
    }
    public ArrayList<Integer> dfsOfGraph(int v,ArrayList<ArrayList<Integer>> adj)
    {
        boolean vis[] = new boolean[v];
        vis[0]=true;
        ArrayList<Integer> ans=new ArrayList<>();
        dfs(0,vis,adj,ans);
        return ans;
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
        Dfs b=new Dfs();
        ArrayList<Integer> ans=b.dfsOfGraph(5,adj);
        int n=ans.size();
        for(int i=0;i<n;i++)
            System.out.print(ans.get(i)+" ");
    }
}
