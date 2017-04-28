package com.poj;

import java.util.Scanner;

//ac
public class POJ_2533 {
    int num[];
    int largeNum[];
    int dp [];

    public static void main(String[] args) {
//        new POJ_2533().work();
        new POJ_2533().withDP();
    }

    private void withDP() {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        num = new int[m];
        dp = new int[m];
        for (int i = 0; i < m; i++) {
            num[i] = sc.nextInt();
        }
        init(dp,m);
        for (int i =0;i<m;i++) {
            int temp = 1;
            for (int j = 0; j < i; j++) {
                if (num[i]>num[j]){
                    temp = Math.max(temp,dp[j]+1);
                }
            }
            dp[i]=temp;
        }
        int large = dp[0];
        for (int i = 0; i < m; i++) {
            large = Math.max(large, dp[i]);
        }
        System.out.println(large);
    }

    void work() {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        num = new int[m];
        largeNum = new int[m];
        init(largeNum,m);
        for (int i = 0; i < m; i++) {
            num[i] = sc.nextInt();
        }
        int length = 0;
        largeNum[length] = num[0];

        for (int i = 0; i < m; i++) {
            if (num[i] > largeNum[length]) {
                largeNum[++length] = num[i];
            } else {
                for (int j = 0; j < length+1; j++) {
                    if (largeNum[j] > num[i] ) {
                        largeNum[j] = num[i];
                        break;
                    }
                }
            }
        }
        System.out.println(length+1);
//        for (int i =0;i<length+1;i++){
//            System.out.print(" *"+largeNum[i]+"* ");
//        }
    }

    private void init(int [] s,int m) {
        for (int i = 0; i < m; i++) {
            s[i] = 0;
        }
    }


}

