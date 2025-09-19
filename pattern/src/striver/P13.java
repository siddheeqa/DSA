package striver;
/*
1
2	3
4	5	6
7	8	9	10
11	12	13	14	15
 */
/*
Time Complexity : O(N2). Where N is the number of rows provided as a input.
 */
public class P13 {
    public static void main(String[] args) {
        int n=5;
        //starting number
        int num=1;
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=i;j++)
            {
                System.out.print(num+++"\t");
            }
            System.out.println();
        }
    }
}
