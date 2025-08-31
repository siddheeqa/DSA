public class FloodFill {
    public static void dfs(int row,int col,int[][] ans,int newColor,int[] delRow,int[] delCol,int iniColor)
    {
        ans[row][col]=newColor;
        int n=ans.length;
        int m=ans[0].length;
        for(int i=0;i<4;i++)
        {
            int nrow=row+delRow[i];
            int ncol=col+delCol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && ans[nrow][ncol]==iniColor && ans[nrow][ncol]!=newColor)
            {
                dfs(nrow,ncol,ans,newColor,delRow,delCol,iniColor);
            }
        }
    }
    public static int[][] floodfill(int[][] image,int sr,int sc,int newColor)
    {
        int iniColor=image[sr][sc];
        int[][] ans=image;
        int delRow[]={-1,0,1,0};
        int delCol[]={0,1,0,-1};
        dfs(sr,sc,ans,newColor,delRow,delCol,iniColor);
        return ans;
    }
    public static void main(String[] args)
    {
        int[][] image =  {
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };
       int[][] ans=floodfill(image,1,1,2);
        for(int i = 0; i < ans.length; i++){
            for(int j = 0; j < ans[i].length; j++)
                System.out.print(ans[i][j] + " ");
            System.out.println();
        }
    }
}
