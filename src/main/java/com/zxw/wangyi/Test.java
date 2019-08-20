package com.zxw.wangyi;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入需要的魔法币个数：");
        int line = sc.nextInt();
        int coin = 0;
        StringBuilder sb = new StringBuilder();
        while (coin != line) {
            // 偶数
            if (line % 2 == 0) {
                coin = (coin - 2) / 2;
                sb.append("2");
            } else {
                // 奇数
                coin = (coin - 1) / 2;
                sb.append("1");
            }
        }
        System.out.println(sb.reverse());
    }

    public void reserve() {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入需要的魔法币个数：");
        int line = sc.nextInt();
        int coin = 0;
        StringBuilder sb = new StringBuilder();
        while (line >= 1) {
            // 偶数
            if (line % 2 == 0) {
                line = (line - 2) / 2;
                sb.append("2");
            } else {
                // 奇数
                line = (line - 1) / 2;
                sb.append("1");
            }
        }
        System.out.println(sb.reverse());
    }
}
