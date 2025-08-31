import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

public class ShortestPathDAG {
    static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    static void topoSort(int node, ArrayList < ArrayList < Pair >> adj,
                          int vis[], Stack < Integer > st) {
        //This is the function to implement Topological sort.

        vis[node] = 1;
        for (int i = 0; i < adj.get(node).size(); i++) {
            int v = adj.get(node).get(i).first;
            if (vis[v] == 0) {
                topoSort(v, adj, vis, st);
            }
        }
        st.add(node);
    }
    public static int[] shortestPath(int n,int m,int[][] edges) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<Pair>());
        for(int i=0;i<m;i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v, wt));
        }
            int[] vis=new int[n];
            Stack<Integer> st=new Stack<Integer>();
            for(int i=0;i<n;i++)
                if(vis[i]==0)
                {
                    topoSort(i,adj,vis,st);
                }
        int[] dist=new int[n];
            for(int i=0;i<n;i++)
                dist[i]=(int)(1e9);
        dist[0]=0;
        while(!st.isEmpty())
        {
            int node=st.peek();
            st.pop();
            for(Pair it:adj.get(node))
            {
                int v=it.first;
                int wt=it.second;
                if(dist[node]+wt<dist[v])
                    dist[v]=wt+dist[node];
            }
        }
        for (int i = 0; i < n; i++) {
            if (dist[i] == 1e9) dist[i] = -1;
        }
        return dist;
    }
    public static void main(String[] args) {
        int n = 6, m = 7;
        //n-total nodes
        //m-edge length
        int[][] edge = {{0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};
        int res[] =shortestPath(n, m, edge);
        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
