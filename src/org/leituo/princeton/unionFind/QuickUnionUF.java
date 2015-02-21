package org.leituo.princeton.unionFind;

/**
 * Created by leituo56 on 2/20/15.
 */
public class QuickUnionUF extends UF {

    private int count;

    QuickUnionUF(int n){
        count = n;
        data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = i;
        }
    }

    private int root(int n){
        validate(n);
        while(n != data[n]){
            n = data[n];
        }
        return n;
    }

    @Override
    public void union(int p, int q) {
        if(connected(p, q)) return;
        int i = root(p);
        int j = root(q);
        data[j] = i;
        count--;
    }

    @Override
    public int find(int p) {
        validate(p);
        return data[p];
    }

    @Override
    public boolean connected(int p, int q) {
        validate(p);
        validate(q);
        return root(p) == root(q);
    }

    @Override
    public int count() {
        return count;
    }
}
