import java.util.*;

public class PrintShortestPath {
    static class Pair
    {
        int first;
        int second;
        Pair(int first,int second)
        {
            this.first=first;
            this.second=second;
        }
    }
    public static List<Integer> dijkstra(ArrayList<ArrayList<Pair>>adj,int v)
    {
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->x.second-y.second);
        int[] dist=new int[v+1];
        int[] parent=new int[v+1];
        for(int i=1;i<=v;i++)
        {
            dist[i]=(int)(1e9);
            parent[i]=i;
        }
        dist[1]=0;
        //node-weight
        pq.add(new Pair(1,0));
        while (!pq.isEmpty())
        {

            int node=pq.peek().first;
            int dis=pq.peek().second;
            pq.remove();
            for(Pair it:adj.get(node))
            {
               int adjNode=it.first;
               int weight=it.second;
               if(dis+weight<dist[adjNode])
               {
                   dist[adjNode]=dis+weight;
                   pq.add(new Pair(adjNode,dis+weight));
                   parent[adjNode]=node;
               }
            }
        }
        List<Integer> path=new ArrayList<>();
        if(dist[v]==1e9) {
            path.add(-1);
            return path;
        }
        int node=v;
        while(parent[node]!=node)
        {
            path.add(node);
            node=parent[node];
        }
        path.add(1);
        Collections.reverse(path);
        return path;
    }
    public static void main(String[] args) {
        int v=5;
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<=v;i++)
            adj.add(new ArrayList<>());
        //node - weight
        adj.get(1).add(new Pair(2,2));
        adj.get(1).add(new Pair(4,1));
        adj.get(2).add(new Pair(1,2));
        adj.get(2).add(new Pair(3,4));
        adj.get(2).add(new Pair(5,5));
        adj.get(3).add(new Pair(2,4));
        adj.get(3).add(new Pair(4,3));
        adj.get(3).add(new Pair(5,1));
        adj.get(4).add(new Pair(1,1));
        adj.get(4).add(new Pair(3,3));
        adj.get(5).add(new Pair(2,5));
        adj.get(5).add(new Pair(3,1));
        List<Integer> ans=dijkstra(adj,v);
        System.out.println(ans);
    }
}
