package striver;
/*
A
AB
ABC
ABCD
ABCDE
 */
/*
Time Complexity : O(N2). Where N is the number of rows provided as a input.
 */
public class P14 {
    public static void main(String[] args) {
        int n=5;
        for(int i=0;i<n;i++)
        {
            for(char ch='A';ch<='A'+i;ch++)
            {
                System.out.print(ch);
            }
            System.out.println();
        }
    }
}
