package striver;
/*
    A
   ABA
  ABCBA
 ABCDCBA
ABCDEDCBA
 */
/*
Time Complexity : O(N2)
 */
public class P17 {
    public static void main(String[] args) {
        int n=5;
        for(int i=0;i<n;i++)
        {
            //space
            for(int j=1;j<=n-i-1;j++)
            {
                System.out.print(" ");
            }
            //printing character
            char ch='A';
            int breakPoint=(2*i+1)/2;
            for(int j=1;j<=(2*i)+1;j++)
            {
                System.out.print(ch);
                if(j<=breakPoint)
                    ch++;
                else
                    ch--;
            }
            System.out.println();
        }
    }
}
