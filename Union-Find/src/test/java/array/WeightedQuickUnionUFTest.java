package array;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import org.junit.Ignore;
import org.junit.Test;

/**
 * 1.5.1 Show the contents of the id[] array and the number of times the ar-
 * ray is accessed for each input pair when you use quick-find for the sequence
 * 9-0 3-4 5-8 7-2 2-1 5-7 0-3 4-2 .
 */
public class WeightedQuickUnionUFTest {

  @Test
  public void test_tiny() {
    In in = new In("tinyUF.txt");
    int N = in.readInt();
    WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
    while (!in.isEmpty()) {
      int p = in.readInt();
      int q = in.readInt();
      if(uf.connected(p,q)) {
        continue;
      }
      uf.union(p,q);
      StdOut.println(uf.count() + " components, " + "cost: " + uf.cost);
      uf.cost = 0;
    }
  }

  @Test
  public void test_medium() {
    In in = new In("mediumUF.txt");
    int N = in.readInt();
    WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
    while (!in.isEmpty()) {
      int p = in.readInt();
      int q = in.readInt();
      if(uf.connected(p,q)) {
        continue;
      }
      uf.union(p,q);
      StdOut.println(uf.count() + " components, " + "cost: " + uf.cost);
      uf.cost = 0;
    }
  }

  @Test
  @Ignore
  public void test_large() {
    In in = new In("largeUF.txt");
    int N = in.readInt();
    WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
    while (!in.isEmpty()) {
      int p = in.readInt();
      int q = in.readInt();
      if(uf.connected(p,q)) {
        continue;
      }
      uf.union(p,q);
      StdOut.println(uf.count() + " components, " + "cost: " + uf.cost);
      uf.cost = 0;
    }
  }
}

