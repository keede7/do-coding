package com.example.codingtest.baekjoon.dp;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * RGB거리에는 집이 N개 있다. 거리는 선분으로 나타낼 수 있고, 1번 집부터 N번 집이 순서대로 있다.
 *
 * 집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다. 각각의 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어졌을 때,
 * 아래 규칙을 만족하면서 모든 집을 칠하는 비용의 최솟값을 구해보자.
 *
 * 1번 집의 색은 2번 집의 색과 같지 않아야 한다.
 * N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
 * i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.
 *
 * 입력
 * 첫째 줄에 집의 수 N(2 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 각 집을 빨강, 초록, 파랑으로 칠하는 비용이 1번 집부터 한 줄에 하나씩 주어진다.
 * 집을 칠하는 비용은 1,000보다 작거나 같은 자연수이다.
 *
 * 출력
 * 첫째 줄에 모든 집을 칠하는 비용의 최솟값을 출력한다.
 *
 * 빨 초 파
 * 예제 입력 1        예제 출력 1
 * 3                96
 * 26 40 83
 * 49 60 57
 * 13 89 99
 *
 * 예제 입력 2        예제 출력 2
 * 3                3
 * 1 100 100
 * 100 1 100
 * 100 100 1
 *
 * 예제 입력 3        예제 출력 3
 * 3                102
 * 1 100 100
 * 100 100 100
 * 1 100 100
 *
 * 예제 입력 4        예제 출력 4
 * 6                208
 * 30 19 5
 * 64 77 64
 * 15 19 97
 * 4 71 57
 * 90 86 84
 * 93 32 91
 *
 * 예제 입력 5        예제 출력 5
 * 8                253
 * 71 39 44         39
 * 32 83 55         32
 * 51 37 63         37
 * 89 29 100        89
 * 83 58 11         11
 * 65 13 15         13
 * 47 25 29         25
 * 60 66 19         19
 */
public class Q1149 {

    // 오히려 N번쨰 배열의 값부터 N-1의 색 조건을 만족할 수 있는 조건중 가장 작은 값들을 미리 '모두' 설정
    //
    static int[][] house;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        house = new int[N][3];

        for (int i = 0; i < N; i++) {
            String metricLine = br.readLine();

            String[] metrics = metricLine.split(" ");

            for (int j = 0; j < metrics.length; j++) {
                house[i][j] = Integer.parseInt(metrics[j]);
            }

        }

        System.out.println();
        for (int i = 1; i < N; i++) {
            house[i][0] += Integer.min(house[i-1][1], house[i-1][2]);
            house[i][1] += Integer.min(house[i-1][0], house[i-1][2]);
            house[i][2] += Integer.min(house[i-1][1], house[i-1][0]);
        }

        System.out.println(
                Integer.min( house[N-1][0], Integer.min(house[N-1][1], house[N-1][2]))
        );
    }
}
