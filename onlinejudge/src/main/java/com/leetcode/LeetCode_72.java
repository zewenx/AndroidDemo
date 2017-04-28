package com.leetcode;

/**
 * Created by zeven on 3/17/2017.
 */

public class LeetCode_72 {

    public int minDistance(String word1, String word2) {
        int length_1 = word1.length();
        int length_2 = word2.length();
        if (length_1==0|length_2==0){
            return length_1+length_2;
        }


        int [][] ans = new int [length_1+1][length_2+1];
        init(ans,length_1,length_2);
        for (int i =1;i<=length_1;i++){
            for (int j = 1;j<=length_2;j++){
                if (word1.charAt(i-1) == word2.charAt(j-1))
                    ans[i][j]=getMaxAns(ans[i-1][j-1],ans[i-1][j]-1,ans[i][j-1]-1);
                else {
                    ans[i][j]=getMaxAns(ans[i-1][j-1]-1,ans[i-1][j]-1,ans[i][j-1]-1);
                }
            }
        }
//        System.out.println(ans[length_1][length_2]);
        return -ans[length_1][length_2];

    }

    private int getMaxAns(int i, int i1, int i2) {
        int ans = Math.max(i,i1);
        return Math.max(ans,i2);
    }

    private void init(int[][] ans,int length_1,int length_2) {
        for (int i =0;i<length_1+1;i++){
            for (int j = 0;j<length_2+1;j++){
                ans[i][j] = 0;;
                ans[0][j] = -j;
            }
            ans[i][0]= -i;
        }
    }

    public static void  main(String aravs[]){
        new LeetCode_72().minDistance("a","ab");
    }
}
