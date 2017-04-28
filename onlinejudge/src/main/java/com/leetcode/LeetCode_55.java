package com.leetcode;

/**
 * 类描述：
 * 创建人：zeven
 * 创建时间：16/4/26 上午10:43
 */
public class LeetCode_55 {
    public boolean canJump(int[] nums) {
        int step = nums[0];
        for (int i =1;i<nums.length;i++){
            if (step<=0)
                return false;
            else {
                step--;
                step = Math.max(step,nums[i]);
            }
        }
        return true;

//  dfs TLE
//        int s[] = new int[nums.length];
//        for (int i = 0; i < s.length; i++) {
//            s[i] = 0;
//        }
//        s[0] = 1;
//        return dfs(0, nums, s);
    }

    boolean dfs(int k, int[] nums, int[] s) {
        if (k + nums[k] >= nums.length - 1) return true;
        if (nums[k] == 0) return false;
        for (int i = nums[k]; i > 0; i--) {
            if (s[k + i] == 0)
                if (dfs(k + i, nums, s))
                    return true;
            s[k+i]=1;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.print(new LeetCode_55().canJump(new int[]{2,0,6,9,8,4,5,0,8,9,1,2,9,6,8,8,0,6,3,1,2,2,1,2,6,5,3,1,2,2,6,4,2,4,3,0,0,0,3,8,2,4,0,1,2,0,1,4,6,5,8,0,7,9,3,4,6,6,5,8,9,3,4,3,7,0,4,9,0,9,8,4,3,0,7,7,1,9,1,9,4,9,0,1,9,5,7,7,1,5,8,2,8,2,6,8,2,2,7,5,1,7,9,6}));
    }
}
