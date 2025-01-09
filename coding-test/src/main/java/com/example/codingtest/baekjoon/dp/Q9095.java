package com.example.codingtest.baekjoon.dp;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 7가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다.
 *
 * 1+1+1+1
 * 1+1+2
 * 1+2+1
 * 2+1+1
 * 2+2
 * 1+3
 * 3+1
 *
 * 정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고,
 * 정수 n이 주어진다. n은 양수이며 11보다 작다.
 *
 * 출력
 * 각 테스트 케이스마다, n을 1, 2, 3의 합으로 나타내는 방법의 수를 출력한다.
 *
 * 예제 입력 1           예제 출력 1
 * 3                    7
 * 4                    44
 * 7                    274
 * 10
 */

public class Q9095 {
    /*
        DP 풀이 구조
        1. 테이블 정의
        2. 점화식
        3. 초기값 세팅
     */
        /*
            1은 1
            - 1 -> 1            총 1번    1

            2는 2
            - 1 -> 2            총 1번    11
            - 2 -> 1            총 1번    2

            3은 4
            - 1 -> 3            총 1번    111
            - 1 -> 1, 2 -> 1    총 2번    12 21
            - 3 -> 1            총 1번    3

            4는 7
            - 1 -> 4            총 1번    1111
            - 1 -> 2, 2 -> 1    총 3번    112 121 211
            - 1 -> 1, 3 -> 1    총 2번    13  31
            - 2 -> 2            총 1번    22

            5는 13
            - 1 -> 5            총 1번   11111
            - 1 -> 3, 2 -> 1    총 4번   1112 1121 1211 2111
            - 1 -> 2, 3 -> 1    총 3번   113 131 311
            - 2 -> 2  1 -> 1    총 3번   122 212 221
            - 2 -> 1  3 -> 1    총 2번   23 32
         */
    static int[] DEF;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        DEF = new int[11];
        DEF[0] = 0;
        DEF[1] = 1;
        DEF[2] = 2;
        DEF[3] = 4;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int input = Integer.parseInt(st.nextToken());

            int result = dp(input);

            System.out.println(result);
        }

    }

    public static int dp(int input) {
        if(input < 0) {
            return 0;
        }

        if(input <= 3) {
            return DEF[input];
        }

        DEF[input] = dp(input - 1) + dp(input - 2) + dp(input - 3);

        return DEF[input];
    }

}
