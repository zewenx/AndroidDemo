package com.leetcode;

/**
 * 类描述：
 * 创建人：zeven
 * 创建时间：16/4/26 上午10:49
 */
public class LeetCode_64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int f[][] = new int[m][n];
        f[0][0] = grid[0][0];
        for (int i = 1; i < m; i++)
            f[i][0] = f[i - 1][0] + grid[i][0];

        for (int i = 1; i < n; i++)
            f[0][i] = f[0][i - 1] + grid[0][i];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = Math.min(f[i][j - 1], f[i - 1][j]) + grid[i][j];
            }
        }
        return f[m - 1][n - 1];
    }


    public static void main(String[] args) {
        int k =3300;
        int data[][] = new int [k][k];
        for (int i=0;i<k;i++){
            for(int j = 0;j<k;j++){
                data[i][j] = (int) (Math.random()*1000);
            }
        }
        for (int i =0;i<20;i++) {
            long start = System.currentTimeMillis();
            System.out.println(new LeetCode_64().minPathSum(data));
            System.out.println(System.currentTimeMillis() - start);
        }
    }

}
