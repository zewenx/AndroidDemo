package com.poj;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

//tle
public class POJ_1015 {
    int f[][][];
    Path paths[][];
    List<P> unselected;
    int times = 0;

    public static void main(String[] args) {
        new POJ_1015().work();
    }

    void work() {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int count = 1;
        unselected = new ArrayList<P>();
        List<P> selected = new ArrayList<P>();

        while (m != 0) {
            f = new int[m + 1][n + 1][2];
            paths = new Path[m + 1][n + 1];
            init(f, m + 1, n + 1, 2);
            int sumD = 0, sumJ = 0;
            for (int i = 1; i < m + 1; i++) {
                P p = new P();
                p.d = sc.nextInt();
                p.j = sc.nextInt();
                p.index = i;
                unselected.add(p);
            }
            dp(m, n, selected);

//            for (int i =0;i<n;i++) {
//                Iterator<P> unselectedIterator = unselected.iterator();
//                P pre = unselectedIterator.next();
//                while (unselectedIterator.hasNext()) {
//                    P current = unselectedIterator.next();
//                    if (abs(pre.d + sumD - pre.j - sumJ) > abs(current.d + sumD - current.j - sumJ)) {
//                        pre = current;
//                    } else if (abs(pre.d + sumD - pre.j - sumJ) == abs(current.d + sumD - current.j - sumJ)) {
//                        if (pre.d + sumD + pre.j + sumJ < current.d + sumD + current.j + sumJ) {
//                            pre = current;
//                        }
//                    }
//                }
//                sumD+=pre.d;
//                sumJ+=pre.j;
//                selected.add(pre);
//                unselected.remove(pre);
//            }
//            Collections.sort(selected);
//            Best jury has value 6 for prosecution and value 4 for defence:
//            2 3
//            for (P temp:unselected) {
//                if (temp.isSelected){
//                    sumD+=temp.d;
//                    sumJ+=temp.j;
//                }
//            }

            System.out.println("Jury #" + count);
            System.out.println("Best jury has value " + f[m][n][0] + " for prosecution and value " + f[m][n][1] + " for defence:");
            for (Integer temp : paths[m][n].indexs) {
                System.out.print(" " + temp.toString());

            }
            System.out.println();
            System.out.println("******"+times);
//            selected.clear();
            unselected.clear();
            m = sc.nextInt();
            n = sc.nextInt();
            count++;
        }
    }

    private void init(int[][][] f, int m, int n, int k) {
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                f[i][j][0] = 0;
                f[i][j][1] = 0;
                paths[i][j] = new Path();
            }
    }

    int abs(int i) {
        return Math.abs(i);
    }

    void dp(int m, int n, List<P> selected) {
        times++;
//        System.out.println(m+" "+n);
        if (n == 0) {
            f[m][n][0] = 0;
            f[m][n][1] = 0;
            return;
        }
        if (m <= n) {
            f[m][n][0] = 0;
            f[m][n][1] = 0;
            for (int i = 0; i < m; i++) {
                P ppp = unselected.get(i);
                f[m][n][0] += ppp.d;
                f[m][n][1] += ppp.j;
                paths[m][n].indexs.add(ppp.index);
            }
            return;
        }
        dp(m - 1, n, selected);

        int a = f[m - 1][n][0] - f[m - 1][n][1];
        for (P p : selected) {
            a += (p.d - p.j);
        }
        a = abs(a);

        selected.add(unselected.get(m - 1));
        dp(m - 1, n - 1, selected);

        int b = f[m - 1][n - 1][0] - f[m - 1][n - 1][1];
        for (P p : selected) {
            b += (p.d - p.j);
        }
        b = abs(b);

        P temp = unselected.get(m - 1);
        paths[m][n].indexs.clear();
        if (b < a) {
            f[m][n][0] = f[m - 1][n - 1][0] + temp.d;
            f[m][n][1] = f[m - 1][n - 1][1] + temp.j;
            paths[m][n].indexs.addAll(paths[m - 1][n - 1].indexs);
            paths[m][n].indexs.add(temp.index);
            selected.remove(temp);
        } else if (b == a) {
            int k = f[m - 1][n][1] + f[m - 1][n][0];
            int q = f[m - 1][n - 1][1] + f[m - 1][n - 1][0] + temp.d + temp.j;
            if (q > k) {
                f[m][n][0] = f[m - 1][n - 1][0] + temp.d;
                f[m][n][1] = f[m - 1][n - 1][1] + temp.j;

                paths[m][n].indexs.addAll(paths[m - 1][n - 1].indexs);
                paths[m][n].indexs.add(temp.index);
                selected.remove(temp);
            } else {
                f[m][n][0] = f[m - 1][n][0];
                f[m][n][1] = f[m - 1][n][1];
                paths[m][n].indexs.addAll(paths[m - 1][n].indexs);
                paths[m][n].indexs.remove(temp.index);
                selected.remove(temp);
            }
        } else {
            f[m][n][0] = f[m - 1][n][0];
            f[m][n][1] = f[m - 1][n][1];
            paths[m][n].indexs.addAll(paths[m - 1][n].indexs);
            paths[m][n].indexs.remove(temp.index);
            selected.remove(temp);
        }
    }

    class P implements Comparable<P> {
        public int d;
        public int j;
        public int index;

        @Override
        public int compareTo(P o) {
            int ans = 0;
            if (this.index < o.index) {
                ans = -1;
            } else ans = 1;
            return ans;
        }
    }

    class Path {
        public HashSet<Integer> indexs = new HashSet<Integer>();
    }

//    Output
//    For each round output a line containing the number of the jury selection round ('Jury #1', 'Jury #2', etc.).
//    On the next line print the values D(J ) and P (J ) of your jury as shown below and on another line print the numbers of the m chosen candidates in ascending order. Output a blank before each individual candidate number.
//    Output an empty line after each test case.
//
//    Sample Input
//
//    4 2
//            1 2
//            2 3
//            4 1
//            6 2
//            4 2
//            1 2
//            2 3
//            4 1
//            6 2
//            0 0
//
//    Sample Output
//
//    Jury #1
//    Best jury has value 6 for prosecution and value 4 for defence:
//     2 3
}

