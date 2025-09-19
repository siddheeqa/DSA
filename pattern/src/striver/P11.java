package striver;
/*
1
01
101
0101
10101
 */
/*
Time Complexity : O(N2). Where, N is the number of rows provided as an input.
 */
public class P11 {
    public static void main(String[] args) {
        int n=5;
        int start=1;
        for(int i=1;i<=n;i++)
        {
            if(i%2!=0)
                start=1;
            else
                start=0;
            for(int j=1;j<=i;j++)
            {
                System.out.print(start);
                start=1-start;
            }
            System.out.println();
        }
    }
}
