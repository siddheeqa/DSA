package striver;
/*
 *        *
 **      **
 ***    ***
 ****  ****
 **********
 ****  ****
 ***    ***
 **      **
 *        *
 */
//Time Complexity : O(N2)
public class P20 {
    public static void main(String[] args) {
    int n=5;
    int space=2*n-2;
    for(int i=1;i<=2*n-1;i++)
    {
        //stars for first half
        int stars=i;
        //stars for second half
        if(i>n)
            stars = 2*n-i;
        //stars
        for(int j=1;j<=stars;j++)
        {
            System.out.print("*");
        }
        //spaces
        for(int j=1;j<=space;j++) {
            System.out.print(" ");
        }
        //stars
        for(int j=1;j<=stars;j++){
            System.out.print("*");
        }
        if(i<n) space-=2;
        else space+=2;
        System.out.println();
    }
    }
}
