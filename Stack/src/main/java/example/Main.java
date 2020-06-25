package example;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * % more tobe.txt
 * to be or not to - be - - that - - - is
 * % java FixedCapacityStackOfStrings < tobe.txt
 * to be not that or be (2 left on stack)
 */
public class Main {
  public static void main(String[] args)
  {
    ResizingArrayStack<String> s;
    s = new ResizingArrayStack<>();
    while (!StdIn.isEmpty())
    {
      String item = StdIn.readString();
      if (!item.equals("-"))
        s.push(item);
      else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
    }
    StdOut.println("(" + s.size() + " left on stack)");
  }
}
