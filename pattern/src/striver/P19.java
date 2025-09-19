package striver;
/*
 **********
 ****  ****
 ***    ***
 **      **
 *        *
 *        *
 **      **
 ***    ***
 ****  ****
 **********
 */
/*
Time Complexity : O(N2)
 */
public class P19 {
    public static void main(String[] args) {
        int n=5;
        //print the upper half pattern
        int spaces=0;
        for(int i=1;i<=n;i++)
        {
            //stars
            for(int j=1;j<=n-i+1;j++)
            {
                System.out.print("*");
            }
            //spaces
            for(int j=1;j<=spaces;j++)
            {
                System.out.print(" ");
            }
            //stars
            for(int j=1;j<=n-i+1;j++)
            {
                System.out.print("*");
            }
            spaces+=2;
            System.out.println();

        }
        //print the lower half pattern
        spaces=2*n-2;
        for(int i=1;i<=n;i++)
        {
            //stars
            for(int j=1;j<=i;j++)
            {
                System.out.print("*");
            }
            //spaces
            for(int j=1;j<=spaces;j++)
            {
                System.out.print(" ");
            }
            //stars
            for(int j=1;j<=i;j++)
            {
                System.out.print("*");
            }
            spaces-=2;
            System.out.println();
        }
    }
}
