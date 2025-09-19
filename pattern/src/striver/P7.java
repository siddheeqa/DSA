package striver;

/*
    *
   ***
  *****
 *******
*********
 */
/*
Time Complexity : O(N2). As the outer loop runs for N times and the first inner loop runs for(N-1 + N-2 + ... + 1), the second inner loop runs incrementally in each iteration(1 + 3 + 5 + ...+2* N-1). So, overall it is O(N2).
 */
public class P7 {
    public static void main(String[] args) {
        int n=5;
        for(int i=1;i<=n;i++)
        {
            //This loop is for space
            for(int j=1;j<=n-i;j++)
            {
                System.out.print(" ");
            }
            //This loop is for stars
            for(int j=1;j<=(2*i)-1;j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
