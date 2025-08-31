import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstraUsingPQ {
    static class Pair
    {
        int node;
        int distance;
        Pair(int node,int distance)
        {
            this.node=node;
            this.distance = distance;
        }
    }
    static int[] dijkstra(int v,ArrayList<ArrayList<Pair>> adj,int source)
    {
        PriorityQueue<Pair> pq=new PriorityQueue<Pair>((x,y)->x.distance - y.distance);
        int[] dist=new int[v];
        for(int i=0;i<v;i++)
            dist[i] = (int)(1e9);
        dist[source]=0;
        pq.add(new Pair(source,0));
        while (pq.size()!=0)
        {
            int dis=pq.peek().distance;
            int node=pq.peek().node;
            pq.remove();
            for(Pair it:adj.get(node))
            {
                int adjNode=it.node;
                int edgeWeight=it.distance;
                if(dis+edgeWeight<dist[adjNode])
                {
                    dist[adjNode]=dis+edgeWeight;
                    pq.add(new Pair(adjNode,dist[adjNode]));
                }
            }
        }
        return dist;
    }
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        adj.get(0).add(new Pair(1, 10));
        adj.get(0).add(new Pair(4, 5));
        adj.get(1).add(new Pair(2, 1));
        adj.get(2).add(new Pair(3, 4));
        adj.get(4).add(new Pair(1, 3));
        adj.get(4).add(new Pair(2, 9));
        adj.get(4).add(new Pair(3, 2));

        int source = 0;
        int[] ans=dijkstra(V,adj,source);
        System.out.println(Arrays.toString(ans));

    }
}
