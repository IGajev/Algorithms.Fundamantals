package expression;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

public class Evaluate {
  public static void main(String[] args)
  {
    Stack<String> ops = new Stack<String>();
    Stack<Double> vals = new Stack<Double>();
    System.out.println("Start of Evaluation.");
    while (!StdIn.isEmpty())
    { // Read token, push if operator.
      String s = StdIn.readString();
      if
      (s.equals("("))
        ;
      else if (s.equals("+"))
        ops.push(s);
      else if (s.equals("-"))
        ops.push(s);
      else if (s.equals("*"))
        ops.push(s);
      else if (s.equals("/"))
        ops.push(s);
      else if (s.equals("sqrt")) ops.push(s);
      else if (s.equals(")"))
      { // Pop, evaluate, and push result if token is ")".
        String op = ops.pop();
        double v = vals.pop();
        if
        (op.equals("+"))
          v = vals.pop() + v;
        else if (op.equals("-"))
          v = vals.pop() - v;
        else if (op.equals("*"))
          v = vals.pop() * v;
        else if (op.equals("/"))
          v = vals.pop() / v;
        else if (op.equals("sqrt")) v = Math.sqrt(v);
        vals.push(v);
      } // Token not operator or paren: push double value.
      else vals.push(Double.parseDouble(s));
    }
    StdOut.println(vals.pop());
  }
}
