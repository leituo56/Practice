package org.leituo.princeton.unionFind;

/**
 * Created by leituo56 on 2/20/15.
 */
public class UFTest {
    public static void main(String[] args) {
        UF test = new QuickFindUF(10);
//        0-7 7-4 6-7 2-7 6-9 3-1
        test.union(0, 7);
        System.out.println(test);
        test.union(7, 4);
        System.out.println(test);
        test.union(6, 7);
        System.out.println(test);
        test.union(2, 7);
        System.out.println(test);
        test.union(6, 9);
        System.out.println(test);
        test.union(3, 1);
        System.out.println(test);
    }
}
