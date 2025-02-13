package com.example.codingtest.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/**
 * N명의 사람들은 매일 아침 한 줄로 선다. 이 사람들은 자리를 마음대로 서지 못하고 오민식의 지시대로 선다.
 *
 * 어느 날 사람들은 오민식이 사람들이 줄 서는 위치를 기록해 놓는다는 것을 알았다.
 * 그리고 아침에 자기가 기록해 놓은 것과 사람들이 줄을 선 위치가 맞는지 확인한다.
 *
 * 사람들은 자기보다 큰 사람이 왼쪽에 몇 명 있었는지만을 기억한다. N명의 사람이 있고, 사람들의 키는 1부터 N까지 모두 다르다.
 *
 * 각 사람들이 기억하는 정보가 주어질 때, 줄을 어떻게 서야 하는지 출력하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 사람의 수 N이 주어진다. N은 10보다 작거나 같은 자연수이다.
 * 둘째 줄에는 키가 1인 사람부터 차례대로 자기보다 키가 큰 사람이 왼쪽에 몇 명이 있었는지 주어진다.
 * i번째 수는 0보다 크거나 같고, N-i보다 작거나 같다. i는 0부터 시작한다.
 *
 * 출력
 * 첫째 줄에 줄을 선 순서대로 키를 출력한다.
 *
 * 예제 입력 1        예제 출력 1
 * 4                4 2 1 3
 * 2 1 1 0
 *
 * 예제 입력 2        예제 출력 2
 * 5                1 2 3 4 5
 * 0 0 0 0 0
 *
 * 예제 입력 3        예제 출력 3
 * 6                6 5 4 3 2 1
 * 5 4 3 2 1 0
 *
 * 예제 입력 4        예제 출력 4
 * 7                6 2 3 4 7 5 1
 * 6 1 1 1 2 0 0    7 2 3 4 5 6 1
 *
 */
public class Q1138 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] sut = IntStream.rangeClosed(1, N)
                .toArray();

    }
}
