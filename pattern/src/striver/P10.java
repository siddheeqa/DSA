package striver;
/*
 *
 **
 ***
 ****
 *****
 ****
 ***
 **
 *
 */
/*
Time Complexity : O(N2). Where N is the input provided. This quadratic complexity arises due to the nested loops iterating over N rows and printing a number of stars that sums up to approximately N2 stars in total.
 */
public class P10 {
    public static void main(String[] args) {
        int n=5;
        for(int i=1;i<=2*n-1;i++)
        {
            int stars=i;
            if(i>n) stars=2*n-i;
            for(int j=1;j<=stars;j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
