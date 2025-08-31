import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceUG {
    public static int[] shortestPath(int[][] edge,int n,int m,int source)
    {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        for(int i=0;i<m;i++) {
            adj.get(edge[i][0]).add(edge[i][1]);
            adj.get(edge[i][1]).add(edge[i][0]);
        }
        int[] dist=new int[n];
        for(int i=0;i<n;i++)
            dist[i]=(int)1e9;
        dist[source]=0;
        Queue<Integer> queue=new LinkedList<>();
        queue.add(source);
        while(!queue.isEmpty())
        {
            int node=queue.peek();
            queue.remove();
            for(int it:adj.get(node))
            {
                if(dist[node]+1<dist[it])
                {
                    dist[it]=1+dist[node];
                    queue.add(it);
                }
            }
        }
        for(int i = 0;i<n;i++) {
            if(dist[i] == 1e9) {
                dist[i] = -1;
            }
        }
        return dist;
    }
    public static void main(String[] args) {
        int n=9, m=10;
        int[][] edge = {{0,1},{0,3},{3,4},{4,5},{5,6},{1,2},{2,6},{6,7},{7,8},{6,8}};
        int res[] = shortestPath(edge,n,m,0);
        for(int i=0;i<n;i++){
            System.out.print(res[i]+" ");
        }
    }
}
