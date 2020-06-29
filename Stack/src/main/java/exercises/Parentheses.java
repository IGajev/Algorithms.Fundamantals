package exercises;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import example.Stack;

import java.nio.charset.IllegalCharsetNameException;

public class Parentheses {
  public static void main(String[] args) {
    Stack<Character> stack = new Stack<>();
    boolean flag = false;

    while (!StdIn.isEmpty()) {
      char i = StdIn.readChar();
      if (i == '{') {
        stack.push(i);
      } else if (i == '[') {
        stack.push(i);
      } else if (i == '(') {
        stack.push(i);
      } else if (i == '}') {
        Character pop = stack.pop();
        flag = match(pop, i);
      } else if (i == ']') {
        Character pop = stack.pop();
        flag = match(pop, i);
      } else if (i == ')') {
        Character pop = stack.pop();
        flag = match(pop, i);
      } else {
        throw new IllegalCharsetNameException("Only '{' '[' '(' ')' ']' '}' are accepted");
      }
    }
    if (stack.isEmpty() && flag == true) {
      StdOut.print("true");
    } else {
      StdOut.print("false");
    }
  }

  private static boolean match(Character pop, Character i) {
    if (pop.equals('{')) {
      return i.equals('}');
    } else if (pop.equals('[')) {
      return i.equals(']');
    } else if (pop.equals('(')) {
      return i.equals(')');
    } else {
      return false;
    }
  }
}
