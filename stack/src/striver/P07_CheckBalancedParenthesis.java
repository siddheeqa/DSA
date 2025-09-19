package striver;

import java.util.Stack;

public class P07_CheckBalancedParenthesis {
    public static boolean isMatched(char open,char close ) {
        if((open == '(' && close == ')') ||
                (open == '[' && close == ']') ||
                (open == '{' && close == '}')
        )
            return true;
        return false;
    }
    //Time Complexity: O(N)
    //Space Complexity: O(N)
    public static boolean isValid(String str) {
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<str.length();i++) {
            if(str.charAt(i)=='(' || str.charAt(i)=='[' || str.charAt(i)=='{')
                stack.push(str.charAt(i));
            else {
                //stack is empty if not match found
                if(stack.isEmpty()) return false;
                //get top of the stack and compare
                char ch=stack.pop();
                if(!isMatched(ch,str.charAt(i))) return false;
            }
        }
        //str="))" in this case stack is empty so it is necessary to check if stack is empty
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        String str = "()[{}()]";
        boolean ans = isValid(str);
        if(ans)
            System.out.println("The given string is valid.");
        else
            System.out.println("The given string is invalid.");
    }
    }
