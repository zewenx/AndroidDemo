package com.poj;

import java.util.Scanner;


//ac
public class POJ_1088 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int x, y;
        x = scanner.nextInt();
        y = scanner.nextInt();
        int data[][] = new int[x][y];
        for (int i = 0; i < x; i++)
            for (int j = 0; j < y; j++) {
                data[i][j] = scanner.nextInt();
            }
        int length[][] = new int[x][y];
        initLength(length);

        for (int i = 0; i < x; i++) {
            for (int j = 0;j<y;j++){
                getAnswer(data, length, i, j, x, y);
            }
        }


        ans(length);
    }

    private static void getAnswer(int[][] data, int[][] length, int i, int j, int x, int y) {
        if (length[i][j] != 0) return;
        int a = 0, b = 0, c = 0, d = 0;
        if (i - 1 >= 0 && data[i][j] < data[i - 1][j]) {
            getAnswer(data, length, i - 1, j, x, y);
            a = length[i - 1][j] + 1;
        }
        if (i + 1 < x && data[i][j] < data[i + 1][j]) {
            getAnswer(data, length, i + 1, j, x, y);
            b = length[i + 1][j] + 1;
        }
        if (j - 1 >= 0 && data[i][j] < data[i][j - 1]) {
            getAnswer(data, length, i, j - 1, x, y);
            c = length[i][j - 1] + 1;
        }
        if (j + 1 < y && data[i][j] < data[i][j + 1]) {
            getAnswer(data, length, i, j + 1, x, y);
            d = length[i][j + 1] + 1;
        }
        length[i][j] = Math.max(length[i][j], a);
        length[i][j] = Math.max(length[i][j], b);
        length[i][j] = Math.max(length[i][j], c);
        length[i][j] = Math.max(length[i][j], d);
//        if (length[i][j]==0)
//            length[i][j] =1;
    }

    private static void initLength(int[][] length) {
        for (int i = 0; i < length.length; i++) {
            for (int j = 0; j < length[0].length; j++) {
                length[i][j] = 0;
            }
        }
    }

    public static void print(int[][] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {

                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void ans(int[][] data) {
        int ans = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                ans = Math.max(ans, data[i][j]);
            }
        }
        ans++;
        System.out.println(ans);
    }
}
