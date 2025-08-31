import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleBfs {
    static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static boolean detect(int src, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[src] = true;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(src, -1));
        while (!queue.isEmpty()) {
            int node = queue.peek().first;
            int parent = queue.peek().second;
            queue.remove();
            for (int adjacentNode : adj.get(node)) {
                if (vis[adjacentNode] == false) {
                    vis[adjacentNode] = true;
                    queue.add(new Pair(adjacentNode, node));
                } else if (parent != adjacentNode)
                    return true;
            }
        }
        return false;
    }
        public static boolean isCycle ( int v, ArrayList<ArrayList<Integer>>adj){
            boolean[] vis = new boolean[v];
            for (int i = 0; i < v; i++)
                if (!vis[i]) {
                    if (detect(i, adj, vis)) return true;
                }
            return false;
        }
        public static void main (String[]args)
        {
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                adj.add(new ArrayList<>());
            }
            adj.get(1).add(2);
            adj.get(2).add(1);
            adj.get(2).add(3);
            adj.get(3).add(2);
            boolean ans = isCycle(4, adj);
            if (ans)
                System.out.println("Cycle");
            else
                System.out.println("Not cycle");
        }
}

