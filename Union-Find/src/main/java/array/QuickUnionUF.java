package array;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class QuickUnionUF {
  private int[] id;
  private int count;
  public int cost;

  public QuickUnionUF(int N) {
    count = N;
    id = new int[N];
    for(int i = 0; i < N; i++) {
      id[i] = i;
    }
  }

  public int count() {
    return count;
  }

  public boolean connected(int p, int q) {
    return find(p) == find(q);
  }

  public int find(int p) {
    cost++;
    while (p != id[p]) {
      cost++;
      p = id[p];
    }
    return p;
  }

  public void union(int p, int q) {
    int pRoot = find(p);
    int qRoot = find(q);
    if (pRoot == qRoot) {
      return;
    }
    id[pRoot] =  qRoot;
    cost++;
    count--;
  }

  public static void main(String[] args) {
    In in = new In(args[0]);
    int N = in.readInt();
    QuickUnionUF uf = new QuickUnionUF(N);
    while (!in.isEmpty()) {
      int p = in.readInt();
      int q = in.readInt();
      if(uf.connected(p,q)) {
        continue;
      }
      uf.union(p,q);
      StdOut.println(uf.count() + " components");
    }
  }
}
