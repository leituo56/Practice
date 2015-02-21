package org.leituo.princeton.unionFind;

/**
 * Created by leituo56 on 2/20/15.
 */
public class QuickFindUF extends UF {

    private int count;

    QuickFindUF(int n){
        count = n;
        data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        if (connected(p, q)) return;
        int pid = data[p];
        for (int i = 0; i < data.length; i++) {
            if (data[i] == pid)
                data[i] = data[q];
        }
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
        return data[p] == data[q];
    }

    @Override
    public int count() {
        return count;
    }

}
