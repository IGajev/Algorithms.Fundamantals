package exercises;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 1.3.29 Write a Queue implementation that uses a circular linked list, which is the same
 * as a linked list except that no links are null and the value of last.next is first when-
 * ever the list is not empty. Keep only one Node instance variable ( last ).
 * @param <Item>
 */
public class CircularQueue<Item> {

  private class Node {
    Item item;
    Node next;
  }

  private int N;


  private Node last;

  public void enqueue(Item item) {
    Node oldlast = last;
    last = new Node();
    last.item = item;
    if (isEmpty()) {
      last.next = last;
    } else {
      last.next = oldlast.next;
      oldlast.next = last;
    }
    N++;
  }

  public Item dequeue() {
    Item poppedItem = last.next.item;
    last.next = last.next.next;
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
    CircularQueue<String> q = new CircularQueue<String>();
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
