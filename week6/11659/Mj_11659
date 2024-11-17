package com.mjwoo.mybatis;

/*
    구간합 문제....

*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Mj_11659 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //수의 개수
        int M = Integer.parseInt(st.nextToken());; //합을 구해야 하는 횟수

        long[] sum = new long[N+1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
        }

        for (int q = 0; q < M; q++) {
            st = new StringTokenizer(br.readLine());

            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            System.out.println(sum[k] - sum[j-1]);
        }

    }

}
