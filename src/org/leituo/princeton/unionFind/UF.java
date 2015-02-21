package org.leituo.princeton.unionFind;

/**
 * Created by leituo56 on 2/20/15.
 */
public abstract class UF {
    protected int[] data;

    public abstract void union(int p, int q);
    public abstract int find(int p);
    public abstract boolean connected(int p, int q);
    public abstract int count();

    protected void validate(int n){
        if(n >= data.length || n < 0)
            throw new IndexOutOfBoundsException("index " + n + " is out of bounds!");
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            builder.append(data[i]);
            if(i < data.length - 1)
                builder.append(" ");
        }
        return builder.toString();
    }
}
