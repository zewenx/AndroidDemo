package com.leetcode;

/**
 * 类描述：
 * 创建人：zeven
 * 创建时间：16/4/26 上午10:49
 *
 * the test cases in leetcode make this method
 * seem to be better in runtime than the while-method,
 * but it's the opposite
 */
public class LeetCode_64_fastest {
    int count =0;
    public int minPathSum(int[][] grid) {
        int[][] memo = new int[grid.length][grid[0].length];
        return minPathSumHelper(grid, 0, 0, memo);
    }

    public int minPathSumHelper(int[][] grid, int row, int col, int[][] memo) {
        if (row == grid.length - 1 && col == grid[0].length - 1) return grid[row][col];
        if (memo[row][col] != 0) return memo[row][col];

        int rowInc = Integer.MAX_VALUE, colInc = Integer.MAX_VALUE;
        if (row < grid.length - 1) rowInc = minPathSumHelper(grid, row + 1, col, memo);
        if (col < grid[0].length - 1) colInc = minPathSumHelper(grid, row, col + 1, memo);
        memo[row][col] = Math.min(rowInc, colInc) + grid[row][col];
        return memo[row][col];
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
            System.out.println(new LeetCode_64_fastest().minPathSum(data));
            System.out.println(System.currentTimeMillis() - start);
        }
    }

}
