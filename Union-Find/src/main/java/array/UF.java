package array;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class UF {
  private int[] id;
  private int count;
  public int cost;

  public UF(int N) {
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
    return id[p];
  }

  public void union(int p, int q) {
    int pID = find(p);
    int qID = find(q);

    if (pID == qID) {
      return ;
    }

    for (int i = 0; i< id.length; i++) {
      cost++;
      if(id[i] == pID) {
        cost++;
        id[i] = qID;
      }
    }
    count--;
  }

  public static void main(String[] args) {
    In in = new In(args[0]);
    int N = in.readInt();
    UF uf = new UF(N);
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
