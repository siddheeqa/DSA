package striver;
/*
555555555
544444445
543333345
543222345
543212345
543222345
543333345
544444445
555555555
 */
//Time Complexity: O(N2)
public class P22 {
    public static void main(String[] args) {
        int n=5;
        for(int i=0;i<2*n-1;i++)
        {
            for(int j=0;j<2*n-1;j++)
            {
                int top=i;
                int left=j;
                int right=(2*n-2)-j;
                int bottom=(2*n-2)-i;
                //Minimum of 4 directions
                int val=Math.min(Math.min(top,bottom),Math.min(left,right));
                System.out.print(n-val);
            }
            System.out.println();
        }
    }
}
