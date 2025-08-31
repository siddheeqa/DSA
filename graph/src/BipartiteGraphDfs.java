import java.util.ArrayList;

public class BipartiteGraphDfs {
    public static boolean dfs(int node,int col,int[] color,ArrayList<ArrayList<Integer>> adj)
    {
        color[node]=col;
        for(int it:adj.get(node))
        {
            if(color[it]==0) {
                if(dfs(it,3-col,color,adj)==false)
                    return false;
            }
            else if(color[node]==color[it])
                return false;
        }
        return true;
    }
    public static boolean check(int v,ArrayList<ArrayList<Integer>> adj)
    {
        int[] color=new int[v];
        for(int i=0;i<v;i++)
        {
            if(color[i]==0)
            {
                if(dfs(i,1,color,adj)==false)
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
        if(check(6,adj))
            System.out.println("Bipartite");
        else
            System.out.println("Not Bipartite");
    }
}
