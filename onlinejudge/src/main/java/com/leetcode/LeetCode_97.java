package com.leetcode;

/**
 * 类描述：
 * 创建人：zeven
 * 创建时间：16/4/26 上午10:49
 */
public class LeetCode_97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length()==0) return true;
        if (s1.length()==0&&s2.length()==0) return false;
        if (s1.length()+s2.length()!=s3.length())return false;

        boolean[][] ans = new boolean[s1.length()+1][s2.length()+1];
        for (int i = 0; i < s1.length()+1; i++) {
            for (int j = 0; j < s2.length()+1; j++) {
                ans[i][j] = false;
            }
        }
        ans[0][0] = true;
        int index1 = 0, index2 = 0;
        for (index1 = 0; index1< s1.length(); index1++) {
            if (index1<s3.length()&&s1.charAt(index1)==s3.charAt(index1)){
                ans[index1+1][0]=true;
            }else break;

        }

        for (index2 = 0; index2< s2.length(); index2++) {
            if (index2<s3.length()&&s2.charAt(index2)==s3.charAt(index2)){
                ans[0][index2+1]=true;
            }else break;

        }
        for (index1 = 1; index1 <= s1.length(); index1++) {
            for (index2 = 1; index2 <= s2.length(); index2++) {
                int k = index1 + index2;
                if (k == 0) continue;
                if (index1 - 1 >= 0 && s1.charAt(index1 - 1) == s3.charAt(k - 1))
                    ans[index1][index2] |= ans[index1 - 1][index2];
                if (index2 - 1 >= 0 && s2.charAt(index2 - 1) == s3.charAt(k - 1))
                    ans[index1][index2] |= ans[index1][index2 - 1];
            }
        }

        return ans[s1.length()][s2.length()];
    }


    public static void main(String[] args) {
        System.out.print(new LeetCode_97().isInterleave("a", "b", "ab"));
    }

}
