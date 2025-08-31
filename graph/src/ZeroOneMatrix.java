import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {
    static class Node {
        int first;
        int second;
        int third;
        Node(int first,int second,int third) {
            this.first=first;
            this.second=second;
            this.third=third;
        }
    }
    public static int[][] nearest(int[][] grid) {
       int n=grid.length;
       int m=grid[0].length;
       int[][] vis=new int[n][m];
       int[][] dist=new int[n][m];
        Queue<Node> queue=new LinkedList<>();
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)

                if(grid[i][j]==1)
                {
                    queue.add(new Node(i,j,0));
                    vis[i][j]=1;
                }
        int[] delrow={-1,0,1,0};
        int[] delcol={0,1,0,-1};
        while(!queue.isEmpty()) {
            int row = queue.peek().first;
            int col = queue.peek().second;
            int steps = queue.peek().third;
            queue.remove();
            dist[row][col]=steps;
            for (int i = 0; i < 4; i++) {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                if(nrow>=0 & nrow<n && ncol>=0 && ncol<m
                && vis[nrow][ncol]==0) {
                    vis[nrow][ncol]=1;
                    queue.add(new Node(nrow,ncol,steps+1));
                }
            }
        }
        return dist;
    }
    public static void main(String[] args) {
        int[][] grid = {
                {0,1,1,0},
                {1,1,0,0},
                {0,0,1,1}
        };
        int[][] ans = nearest(grid);
        for(int i = 0; i < ans.length; i++){
            for(int j = 0; j < ans[i].length; j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
    }
