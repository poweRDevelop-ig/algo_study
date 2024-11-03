package com.mjwoo.mybatis;

import java.io.*;
import java.util.Scanner;

public class Algo_9095 {
    public static void main(String[] args) throws IOException {


        /*
            1,2,3 더하기
            정수 n이 주어졌을 때 n을 1,2,3의 합으로 나타내는 방법의 수를 구하기
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int t = 0; t < N; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] dp = new int[11];

            dp[1] = 1; //배열에 1을 만드는 방법 저장
            dp[2] = 2; //2를 만드는 방법 = 1+1, 2
            dp[3] = 4; //3을 만드는 방법 = 1+1+1, 1+2, 2+1, 3

            for (int i = 4; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }

            sb.append(dp[n]).append('\n');
        }

        System.out.print(sb);
    }
}
