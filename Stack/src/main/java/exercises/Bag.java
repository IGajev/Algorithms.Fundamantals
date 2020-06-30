package exercises;

import edu.princeton.cs.algs4.StdOut;

/**
 * 1.3.27 Write a method max() that takes a reference to the first node in a linked list as
 * argument and returns the value of the maximum key in the list. Assume that all keys are
 * positive integers, and return 0 if the list is empty.
 *
 * 1.3.28 Develop a recursive solution to the previous question.
 */
public class Bag {
  private class Node {
    int key;
    Node next;
  }

  private int N;

  public Node getFirst() {
    return first;
  }

  private Node first;

  public void add(int key) {
    Node oldfirst = first;
    first = new Node();
    first.key = key;
    first.next = oldfirst;
    N++;
  }

  public int max(Node first) {
    int max = 0;
    for (Node n = first; n != null; n = n.next ) {
      if (n.key > max) {
        max = n.key;
      }
    }
    return max;
  }

  public static void main(String[] args) {
    Bag bag = new Bag();
    bag.add(1);
    bag.add(10);
    bag.add(2);
    bag.add(3);
    bag.add(0);

    StdOut.println("max is " + bag.max(bag.first));
    StdOut.println("maxRecursive is " + bag.maxRecursive(bag.first));
  }

  public int maxRecursive(Node first) {
    if(first == null) {
      return 0;
    } else {
      if (first.key > maxRecursive(first.next))
        return first.key;
      else
        return maxRecursive(first.next);
    }
  }
}
