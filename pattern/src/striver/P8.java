package striver;
/*
 *******
  *****
   ***
    *
 */
/*
Time Complexity : O(N2). As the outer loop runs for N times and the first inner loop runs for(0 + 1 + 2 + .. + N-1), the second inner loop runs in decreasing manner in each iteration((2*N -1) + (2*N - 3) + ... + 1) . So, overall it is O(N2).
 */
public class P8 {
    public static void main(String[] args) {
        int n=5;
        for(int i=1;i<=n;i++)
        {
            //Space
            for(int j=1;j<i;j++)
            {
                System.out.print(" ");
            }
            //Stars
            for(int j=1;j<=(2*n)-(2*i)+1;j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
