package com.example.codingtest.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
 *
 * 아래 그림은 2×5 크기의 직사각형을 채운 한 가지 방법의 예이다.
 *
 *
 *
 * 입력
 * 첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)
 *
 * 출력
 * 첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.
 *
 * 예제 입력 1        예제 출력 1
 * 2                2
 * 예제 입력 2        예제 출력 2
 * 9                55
 */
public class Q11726 {
    static int[] D = new int[1000];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        D[0] = 1;
        D[1] = 2;

        for (int i = 2; i < 1000; i++) {
            D[i] = (D[i-2] + D[i-1]) % 10_007;
        }

        int N = Integer.parseInt(st.nextToken());
        System.out.println(D[N-1]);
    }

    /*
        static int[] D = new int[1000];

        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            D[0] = 1;
            D[1] = 2;


            int N = Integer.parseInt(st.nextToken());

            if(N <= 1) {
                System.out.println(D[N-1]);
                return;
            }

            for (int i = 2; i < N; i++) {
                D[i] = (D[i-2] + D[i-1]) % 10_007;
            }

            System.out.println(D[N-1]);
        }

     */
}
