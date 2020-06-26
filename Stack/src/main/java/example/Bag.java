package example;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {
  private class Node {
    Item item;
    Node next;
  }

  private int N;

  private Node first;

  public void add(Item item) {
    Node oldfirst = first;
    first = new Node();
    first.item = item;
    first.next = oldfirst;
    N++;
  }

  @Override public Iterator<Item> iterator() {
    return new ListIterator();
  }

  private class ListIterator implements Iterator<Item> {
    private Node current = first;

    @Override public Item next() {
      Item item = current.item;
      current = current.next;
      return item;
    }

    @Override public boolean hasNext() {
      return current != null;
    }

    @Override public void remove() {
    }
  }
}
