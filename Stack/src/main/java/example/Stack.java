package example;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Pushdown stack (linked-list implementation)
 * @param <Item>
 */
public class Stack<Item> {

  private class Node {
    Item item;
    Node next;
  }

  private int N;

  private Node first;

  public void push(Item item) {
    Node oldFirst = first;
    first = new Node();
    first.item = item;
    first.next = oldFirst;
    N++;
  }

  public Item pop() {
    Item poppedItem = first.item;
    first = first.next;
    N--;
    return poppedItem;
  }

  public boolean isEmpty(){
    return first == null;
  }

  public int size() {
    return N;
  }

  /**
   * % more tobe.txt
   * to be or not to - be - - that - - - is
   * % java FixedCapacityStackOfStrings < tobe.txt
   * to be not that or be (2 left on stack)
   */
  public static void main(String[] args)
  { // Create a stack and push/pop strings as directed on StdIn.
    Stack<String> s = new Stack<String>();
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
