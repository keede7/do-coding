package com.example.codingtest.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Example {

    static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = Integer.parseInt(st.nextToken());

        memo = new int[count+1];
        Arrays.fill(memo, 0);
        memo[0] = 1;
        memo[1] = 1;

        int result = fibonacci(count);
        System.out.println("result = " + result);
    }

    public static int fibonacci(int n) {
        if(memo[n] > 0) {
            return memo[n];
        }

        if(n <= 1) {
            memo[n] = n;
            return memo[n];
        }

        memo[n] = fibonacci(n-1) + fibonacci(n-2);
        return memo[n];
    }
}
