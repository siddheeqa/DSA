import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class DijkstraUsingSet {
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
    public static int[] dijkstra(int v,ArrayList<ArrayList<Pair>> adj , int src) {

        int[] dist = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);
        TreeSet<Pair> set = new TreeSet<>((a, b) -> {
            if (a.first != b.first)
                return a.first - b.first;
            return a.second - b.second; // Tie-breaker
        });
        set.add(new Pair(0,src));
        dist[src] = 0;
        while(!set.isEmpty())
        {
            Pair top=set.pollFirst();
            int u=top.second;
            for(Pair it:adj.get(u))
            {
                int V=it.second;
                int weight=it.first;
                if(dist[V]>dist[u]+weight)
                {
                    if(dist[V]!=Integer.MAX_VALUE)
                        set.remove(new Pair(dist[V],V));
                    dist[V]=dist[u]+weight;
                    set.add(new Pair(dist[V],V));
                }
            }
        }
        return dist;
    }
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        adj.get(0).add(new Pair(10, 1));
        adj.get(0).add(new Pair(5, 4));
        adj.get(1).add(new Pair(1, 2));
        adj.get(2).add(new Pair(4, 3));
        adj.get(4).add(new Pair(3, 1));
        adj.get(4).add(new Pair(9, 2));
        adj.get(4).add(new Pair(2, 3));

        int source = 0;
        int[] ans=dijkstra(V,adj,source);
        System.out.println(Arrays.toString(ans));
    }
}
