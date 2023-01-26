package com.example.codingtest.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    5585 문제
 */
public class Change {

    private static final int[] coins = {500, 100, 50, 10, 5, 1};
    private static final int CHANGE = 1000;

    public static void main(String[] args) throws IOException {
        System.out.println("하이");
        // 입력 오픈
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 첫번쨰 입력을 받는다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 지불한 돈
        int charge = Integer.parseInt(st.nextToken());

        if (charge <= 0 || charge > 1000) {
            return;
        }

        int remainCoin = CHANGE - charge;

        int result = 0;

        for (int coin : coins) {
            result += remainCoin / coin;
            remainCoin = remainCoin % coin;
        }

        System.out.println(result);
    }
}
