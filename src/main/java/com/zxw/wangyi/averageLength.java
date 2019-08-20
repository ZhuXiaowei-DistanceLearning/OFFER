package com.zxw.wangyi;

import java.util.Scanner;

public class averageLength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入字符串");
        String s = sc.nextLine();
        char[] charArray = s.toCharArray();
        float total = charArray.length;
        float len = 0;
        float num = 0;
        for (int i = 0; i < charArray.length - 1; i++) {
            if (charArray[i] != charArray[i + 1]) {
                len += 1;
            }
        }
        System.out.println(total / len);
    }
}
