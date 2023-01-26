package com.example.codingtest.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
   1026번 문제
  나만 이게안됨 코테 ㅗ
 */
public class Treasures {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 첫쨰 줄 배열 개수
        int N = Integer.parseInt(st.nextToken());

        int[] arrA = new int[N];
        int[] arrB = new int[N];

        // 둘째 줄 A배열 N개 개수
        st = new StringTokenizer(br.readLine());
        for (int i=0; i < N; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        // 세번째 B 배열 N개 개수
        st = new StringTokenizer(br.readLine());
        for (int i=0; i < N; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arrA);
        Arrays.sort(arrB);
        //  각 배열의 곱한 값을 더한 결과 도출
        int result = 0;
        for (int i = 0; i < N; i++) {
            int idxMultipleValue = arrA[i] * arrB[N-1-i];
            result += idxMultipleValue;
        }

        System.out.println("result = " + result);
    }
}
