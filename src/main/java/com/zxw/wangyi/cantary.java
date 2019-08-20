package com.zxw.wangyi;

import java.util.Scanner;

public class cantary {
    // 求相反数
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入一个数：");
        String input = sc.nextLine();
        char[] array = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = array.length - 1; i >= 0; i--) {
            char c = array[i];
            if (c != 48) {
                sb.append(c - '0');
            }
        }
        System.out.println(Integer.valueOf(sb.toString()) + Integer.valueOf(input));
    }
}
