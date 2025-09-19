package striver;
/*
     *
    ***
   *****
  *******
 *********
 *********
  *******
   *****
    ***
     *
 */
public class P9 {
    public static void main(String[] args) {
        int n=5;
        for(int i=1;i<=n;i++)
        {
            //Space
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
