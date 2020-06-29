package exercises;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import example.Stack;

public class FixParentheses {
  public static void main(String[] args) {
    Stack<String> operatorStack = new Stack();
    Stack<String> expressionStack = new Stack();

    while (!StdIn.isEmpty()){
      String str = StdIn.readString();
      if (str.equals("*") || str.equals("+") || str.equals("-")) {
        operatorStack.push(str);
      } else if (str.equals(")")) {
        String expression2 = expressionStack.pop();
        String expression1 = expressionStack.pop();
        String operator = operatorStack.pop();
        expressionStack.push("(" + expression1 + operator + expression2 + ")");
      } else {
        expressionStack.push(str);
      }
    }
    StdOut.print(expressionStack.pop());
  }
}
