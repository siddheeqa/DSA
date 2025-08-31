import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule1 {
    public static void main(String[] args) {
        int v=4;
        int[][] prerequisites = {
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2}
        };

        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<v;i++)
            adj.add(new ArrayList<>());

        for(int i=0;i<prerequisites.length;i++)
        {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int[] inDegree=new int[v];
        for(int i=0;i<v;i++)
        {
            for(int it:adj.get(i))
            {
                inDegree[it]++;
            }
        }
        Queue<Integer> queue=new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        ArrayList<Integer> topo=new ArrayList<>();
        while(!queue.isEmpty())
        {
            int node=queue.peek();
            queue.remove();
            topo.add(node);
            for(int it:adj.get(node))
            {
                inDegree[it]--;
                if(inDegree[it]==0)
                    queue.add(it);
            }
        }
        System.out.println(topo);
    }
}
