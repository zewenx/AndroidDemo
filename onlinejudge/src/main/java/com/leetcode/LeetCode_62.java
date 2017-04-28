package com.leetcode;

/**
 * 类描述：
 * 创建人：zeven
 * 创建时间：16/4/26 上午10:49
 */
public class LeetCode_62 {
    public int uniquePaths(int m, int n) {
        int f[][] = new int[m][n];
        f[0][0]=1;
        for (int i =0;i<m;i++){
            for (int j =0;j<n;j++){
                f[i][j]=0;
            }
        }
        for (int i =0;i<m;i++){
            f[i][0]=1;
        }
        for (int i =0;i<n;i++){
            f[0][i]=1;
        }
        for (int i =1;i<m;i++){
           for (int j =1;j<n;j++){
               if (j-1>=0)
               f[i][j]+=f[i][j-1];
               if (i-1>=0)
                   f[i][j]+=f[i-1][j];
           }
        }
        return f[m-1][n-1];
    }


    public static void main(String[] args) {
        System.out.print(new LeetCode_62().uniquePaths(1, 2));
    }

}
