import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinMulToReachEnd {
   static class Pair
   {
       int steps;
       int node;
       Pair(int steps,int node)
       {
           this.steps=steps;
           this.node=node;
       }
   }
   public static int countPaths(int[] arr,int start,int end)
   {
       if(start==end) return 0;
       int mod=100000;
       int[] dist=new int[mod];
       Arrays.fill(dist,(int)(1e9));
       Queue<Pair> queue=new LinkedList<>();
       queue.add(new Pair(0,start));
       dist[start]=0;
       while (!queue.isEmpty())
       {
           Pair pr= queue.poll();
           int steps = pr.steps;
           int node = pr.node;

           for(int factor:arr)
           {
               int newNode=(node*factor)%mod;
               if(steps+1<dist[newNode])
               {
                   dist[newNode]=steps+1;
                   if(newNode==end) return steps+1;
                   queue.add(new Pair(steps+1,newNode));
               }
           }
       }
       return -1;
   }
    public static void main(String[] args) {
        int[] arr = {2, 5, 7};
        int start = 3, end = 30;
        int ans=countPaths(arr,start,end);
        System.out.println(ans);
    }
}
