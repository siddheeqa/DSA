import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    static class Pair
    {
        int row;
        int col;
        int tm;
        Pair(int row,int col,int tm)
        {
            this.row=row;
            this.col=col;
            this.tm=tm;
        }
    }
    public static int orangesRotting(int[][] arr)
    {
        if(arr==null || arr.length==0) return 0;
        int n=arr.length;
        int m=arr[0].length;
        Queue<Pair> queue=new LinkedList<>();
        int[][] vis=new int[n][m];
        int freshOranges=0;
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++) {
                //2 indicate rotten orange
                if (arr[i][j] == 2) {
                    queue.add(new Pair(i, j, 0));
                    vis[i][j] = 2;
                }
                if(arr[i][j]==1)
                    freshOranges++;
            }
        if(freshOranges==0) return 0;
        int tm=0;
        int drow[]={-1,0,1,0};
        int dcol[]={0,1,0,-1};
        int count=0;
        while(!queue.isEmpty())
        {
            int r=queue.peek().row;
            int c=queue.peek().col;
            int t=queue.peek().tm;
            tm=Math.max(tm,t);
            queue.remove();
            for(int i=0;i<4;i++)
            {
                int nrow=r+drow[i];
                int ncol=c+dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && arr[nrow][ncol]==1)
                {
                    queue.add(new Pair(nrow,ncol,t+1));
                    vis[nrow][ncol]=2;
                    count++;
                }
            }
        }
        if(freshOranges==count) return tm;
        return -1;
    }
    public static void main(String[] args) {
        int arr[][]={ {2,1,1} , {1,1,0} , {0,1,1} };
        int time=orangesRotting(arr);
        System.out.println(time);
    }
}
