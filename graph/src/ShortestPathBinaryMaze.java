import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMaze {
    static class Pair {
        int first, second, third;
        Pair(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
    public static int shortestPath(int[][] grid,int[] source,int[] destination)
    {
        if(source[0] == destination[0] &&
                source[1] == destination[1]) return 0;
        Queue<Pair> queue=new LinkedList<>();
        int n=grid.length;
        int m=grid[0].length;
        int[][] dist=new int[n][m];
        for(int i = 0;i<n;i++) {
            for(int j =0;j<m;j++) {
                dist[i][j] = (int)(1e9);
            }
        }
        dist[source[0]][source[1]]=0;
        queue.add(new Pair(0,source[0],source[1]));
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        while(!queue.isEmpty())
        {
            Pair it=queue.remove();
            int dis=it.first;
            int r=it.second;
            int c=it.third;
            for(int i=0;i<4;i++)
            {
                int newr=r+dr[i];
                int newc=c+dc[i];
                if(newr >= 0 && newr < n && newc >= 0 && newc < m
                        && grid[newr][newc] == 1 && dis + 1 < dist[newr][newc]) {
                    dist[newr][newc] = 1 + dis;

                    if(newr == destination[0] &&
                            newc == destination[1]) return dis + 1;
                    queue.add(new Pair(1+dis, newr, newc));
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] source={0,1};
        int[] destination={2,2};

        int[][] grid={{1, 1, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0},
                {1, 0, 0, 1}};
        int res = shortestPath(grid, source, destination);

        System.out.print(res);
    }
}
