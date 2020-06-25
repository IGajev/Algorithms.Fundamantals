package example;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;

public class GenericStack<Item>
{
  private final List<Item> a;
  // stack entries

  public GenericStack() {
    a = new ArrayList<>();
  }

  public boolean isEmpty() {
      return a.size() == 0;
  }

  public int size() {
    return a.size();
  }

  public void push(Item item) {
    a.add(item);
  }

  public Item pop() {
    return a.remove(a.size() - 1);
  }

  /**
   * % more tobe.txt
   * to be or not to - be - - that - - - is
   * % java FixedCapacityStackOfStrings < tobe.txt
   * to be not that or be (2 left on stack)
   * @param args Not used
   */
  public static void main(String[] args)
  {
    GenericStack<String> s;
    s = new GenericStack<>();
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