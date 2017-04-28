package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述：
 * 创建人：zeven
 * 创建时间：16/4/26 上午10:49
 */
public class LeetCode_93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> x = new ArrayList<String>();
        generate(s, 4, "", x);
        return x;
    }

    void generate(String str, int cut, String target, List<String> ans) {

        if (cut == 1) {
            if (isValid(str)) {
                ans.add(target + "." + str);
            }
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (str.length() - i > (cut-1) * 3 || str.length() - i < cut-1)
                continue;
            String onecut = str.substring(0, i);
            if (isValid(onecut)) {
                String tempTarget = "";
                if (target.length() > 0)
                    tempTarget =target+ "." + onecut;
                else
                    tempTarget = onecut;
                String tempstr = str.substring(i);
                generate(tempstr, cut - 1, tempTarget, ans);
            }
        }

    }

    private boolean isValid(String str) {
        if (str.length()>1&& str.startsWith("0"))return false;

        return Integer.parseInt(str) < 256 && Integer.parseInt(str) >= 0;
    }


    public static void main(String[] args) {
        System.out.print(new LeetCode_93().restoreIpAddresses("010010").toString());
    }

}
