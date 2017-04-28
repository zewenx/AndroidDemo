package com.leetcode;

/**
 * 类描述：
 * 创建人：zeven
 * 创建时间：16/4/26 上午10:49
 */
public class LeetCode_63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int f[][] = new int[m][n];

        for (int i =0;i<m;i++){
            for (int j =0;j<n;j++){
                f[i][j]=0;
            }
        }

        if (obstacleGrid[0][0]==0) f[0][0]=1;

        for (int i =0;i<m;i++){
           for (int j =0;j<n;j++){
               if (obstacleGrid[i][j]!=1) {
                   if (j - 1 >= 0)
                       f[i][j] += f[i][j - 1];
                   if (i - 1 >= 0)
                       f[i][j] += f[i - 1][j];
               }
           }
        }
        return f[m-1][n-1];
    }


    public static void main(String[] args) {
        System.out.print(new LeetCode_63().uniquePathsWithObstacles(new int[][]{{1,0}}));
    }

}
