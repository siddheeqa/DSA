import java.util.ArrayList;

public class NoOfProvinces {
    public static void dfs(int node,boolean[] vis,ArrayList<ArrayList<Integer>> adj)
    {
        vis[node]=true;
        //getting neighbour nodes
        for(Integer it:adj.get(node))
        {
            if(!vis[it])
            {
                dfs(it,vis,adj);
            }
        }
    }
    public int numProvinces(int v,ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] vis=new boolean[v+1];
        int count=0;
        for(int i=1;i<=v;i++)
        {
            if(!vis[i])
            {
                count++;
                dfs(i,vis,adj);
            }
        }
        return count;
    }
    public static void main(String[] args)
    {
        //1 based
        ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<=3;i++)
            adj.add(new ArrayList<Integer>());
        adj.get(1).add(2);
        adj.get(3).add(1);
        NoOfProvinces n=new NoOfProvinces();
        System.out.println(n.numProvinces(3,adj));
    }
}
