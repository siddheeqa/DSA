import java.util.ArrayList;
import java.util.HashSet;

public class NoOfDistinctIslands {
    static class Pair
    {
        int first;
        int second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    public static void dfs(int row,int col,int[][] vis,char[][] grid,ArrayList<String> vec,int row0,int col0)
    {
        vis[row][col]=1;
        vec.add(toString(row-row0,col-col0));
        int n= grid.length;
        int m= grid[0].length;
        int[] delrow={-1,0,1,0};
        int[] delcol={0,-1,0,1};
        for(int i=0;i<4;i++)
        {
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];
            if (nrow>=0 && nrow<n && ncol>=0
                    && ncol<m && grid[nrow][ncol]=='1'
                    && vis[nrow][ncol]==0)
                dfs(nrow,ncol,vis,grid,vec,row0,col0);
        }
    }
    public static String toString(int r,int c){
        return Integer.toString(r)+" "+Integer.toString(c);
    }
    public static int numIslands(char[][] grid)
    {
        int n=grid.length;
        int m= grid[0].length;
        int[][] vis=new int[n][m];
        HashSet<ArrayList<String>> st=new HashSet<>();
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
            {
                if(vis[i][j]==0 && grid[i][j]=='1')
                {
                    ArrayList<String> vec=new ArrayList<>();
                    dfs(i,j,vis,grid,vec,i,j);
                    st.add(vec);
                }
            }
        return st.size();
    }
    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','0','1','1'},
                {'1','0','0','0','0'},
                {'0','0','0','0','1'},
                {'1','1','0','1','1'}
        };

        System.out.println(numIslands(grid));
    }
}
