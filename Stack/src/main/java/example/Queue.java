package example;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Queue<Item> {

  private class Node {
    Item item;
    Node next;
  }

  private int N;

  private Node first;

  private Node last;

  public void enqueue(Item item) {
    Node oldlast = last;
    last = new Node();
    last.item = item;
    last.next = null;
    if (isEmpty()) {
      first = last;
    } else {
      oldlast.next = last;
    }
    N++;
  }

  public Item dequeue() {
    Item poppedItem = first.item;
    first = first.next;
    N--;
    if ( isEmpty() ) {
      last = null;
    }
    return poppedItem;
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public int size() {
    return N;
  }

  /**
   * % more tobe.txt
   * to be or not to - be - - that - - - is
   * % java Queue < tobe.txt
   * to be or not to be (2 left on queue)
   * @param args
   */
  public static void main(String[] args)
  { // Create a queue and enqueue/dequeue strings.
    Queue<String> q = new Queue<String>();
    while (!StdIn.isEmpty())
    {
      String item = StdIn.readString();
      if (!item.equals("-"))
        q.enqueue(item);
      else if (!q.isEmpty()) StdOut.print(q.dequeue() + " ");
    }
    StdOut.println("(" + q.size() + " left on queue)");
  }
}
