package com.poj;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

//tle
public class POJ_1019 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        int[] a = new int[c];
        int[] ans = new int[c];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int length[] = new int[32000];
        int start[] = new int[32000];
        for (int i = 0; i < c; i++) {
            a[i] = sc.nextInt();
            map.put(a[i], i);
        }
        Arrays.sort(a);
        // System.out.println(Arrays.toString(a));
        int count = 0;
        length[0] = 0;
        int size = 0;
        for (int k = 1; k < 32000; k++) {

            if (k < 10)
                size = 1;
            else if (k < 100)
                size = 2;
            else if (k < 1000)
                size = 3;
            else if (k < 10000)
                size = 4;
            else if (k < 100000)
                size = 5;
            length[k] = length[k - 1] + size;
        }

        start[0] = 0;
        start[1]=1;
        for (int k = 2; k < 32000; k++) {
            start[k] = length[k - 1] + start[k - 1];

        }
        for (int k = 1; k < 32000; k++) {
            if (a[count]<=start[k]){
                int tag = map.get(a[count]);
                ans[tag]=a[count]-start[k-1];

                a[count]=a[count]-start[k-1];
                map.put(a[count],tag);
                count++;
                k--;
            }
            if (count == c) break;
        }
        for (int k = 1; k < 32000; k++) {
            if (count == c) break;


            if (a[count]<=length[k]){
                ans[map.get(a[count])]=a[count]-start[k-1];
                int temp = length[k]-a[count]-1;
                ans[map.get(a[count])]=(""+k).charAt(temp)-'0';
                count++;
            }
        }


        for (int i = 0; i < c; i++) {
            System.out.println(ans[i]);
        }
    }

}

