package example;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * Pushdown (LIFO) stack (resizing array implementation)
 * @param <Item>
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {

  private Item[] a = (Item[]) new Object[1];
  private int N = 0;

  public boolean isEmpty() { return N == 0; }

  public int size() { return N; }

  private void resize(int max) {
    Item[] temp = (Item[]) new Object[max];
    for (int i = 0; i < N; i++) {
      temp[i] = a[i];
    }
    a = temp;
  }

  public void push(Item item) {
    if (a.length == N) {
      resize(N*2);
    }
    a[N++] = item;
  }

  public Item pop() {
    Item item = a[--N];
    a[N] = null;
    if (N > 0 && N == a.length/4) {
      resize(a.length/2);
    }
    return item;
  }

  @Override public Iterator<Item> iterator() {
    return new ReverseArrayIterator();
  }

  private class ReverseArrayIterator implements Iterator<Item> {
    private int i = N;

    @Override public boolean hasNext() {
      return i > 0;
    }

    @Override public Item next() {
      return a[--i];
    }

    @Override public void remove() {
    }
  }

  /**
   * % more tobe.txt
   * to be or not to - be - - that - - - is
   * % java FixedCapacityStackOfStrings < tobe.txt
   * to be not that or be (2 left on stack)
   */
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
