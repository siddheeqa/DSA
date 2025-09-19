package striver;
/*
A
BB
CCC
DDDD
EEEEE
 */
/*
Time Complexity : O(N2). The overall complexity will be O(N2), where N is the number of row
 */
public class P16 {
    public static void main(String[] args) {
        int n=5;
        for(int i=0;i<n;i++)
        {
            for(char ch='A';ch<='A'+i;ch++)
            {
                System.out.print((char)('A'+i));
            }
            System.out.println();
        }
    }
}
