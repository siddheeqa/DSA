package striver;
/*
ABCDE
ABCD
ABC
AB
A
 */
/*
Time Complexity : O(N2). The overall complexity will be O(N2), where N is the number of row
 */
public class P15 {
    public static void main(String[] args) {
        int n=5;
        for(int i=0;i<n;i++)
        {
            for(char ch ='A';ch<='A'+(n-i-1);ch++)
            {
                System.out.print(ch);
            }
            System.out.println();
        }
    }
}
