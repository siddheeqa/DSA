package striver;
/*
1        1
12      21
123    321
1234  4321
1234554321
 */
/*
Time Complexity : O(N2). Where, N is the number of rows provided as an input.
 */
public class P12 {
    public static void main(String[] args) {
        int n=5;
        int space=2*(n-1);
        for(int i=1;i<=n;i++)
        {
        //numbers
        for(int j=1;j<=i;j++)
            System.out.print(j);
        //spaces
        for(int j=1;j<=space;j++)
            System.out.print(" ");
        //numbers
        for(int j=i;j>=1;j--)
            System.out.print(j);
        System.out.println();
        space-=2;
        }
    }
}
