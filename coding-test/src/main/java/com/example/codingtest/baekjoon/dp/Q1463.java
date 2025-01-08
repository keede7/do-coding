package com.example.codingtest.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제
 * 정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
 *
 * X가 3으로 나누어 떨어지면, 3으로 나눈다.
 * X가 2로 나누어 떨어지면, 2로 나눈다.
 * 1을 뺀다.
 * 정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.
 *
 * 입력
 * 첫째 줄에 1보다 크거나 같고, 106보다 작거나 같은 정수 N이 주어진다.
 *
 * 출력
 * 첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.
 *
 * 예제 입력 1
 * 2
 * 예제 출력 1
 * 1
 * 예제 입력 2
 * 10
 * 예제 출력 2
 * 3
 * 힌트
 * 10의 경우에 10 → 9 → 3 → 1 로 3번 만에 만들 수 있다.
 */
public class Q1463 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(st.nextToken());

        D = new int[input+1];
        Arrays.fill(D, -1);
        //baseCase
        D[1] = 0;

        System.out.println("Arrays.toString(D) = " + Arrays.toString(D));

        int result = dp(input);

        System.out.println(result);
    }

    static int[] D;

    public static int dp(int n) {
        if(D[n] != -1) {
            System.out.println("n = " + n);
            return D[n];
        }

        System.out.println("B D["+n+"] = " + D[n]);
        D[n] = dp(n-1)+1;
        System.out.println("A D["+n+"] = " + D[n]);
        if(n%2==0) {
            System.out.println("2나누기");
            D[n] = Integer.min(D[n], dp(n / 2) + 1);
        }

        if(n%3==0) {
            System.out.println("3나누기");
            D[n] = Integer.min(D[n], dp(n / 3) + 1);
        }

        System.out.println("C D["+n+"] = " + D[n]);
        System.out.println();
        return D[n];
    }

    public static int dp2(int n) {
        if (D[n] != -1)
            return D[n];

        D[n] = dp(n-1) + 1;
        if (n % 2 == 0) {
            int temp = dp(n / 2) + 1;
            if (D[n] > temp) D[n] = temp;
        }
        if (n % 3 == 0) {
            int temp = dp(n / 3) + 1;
            if (D[n] > temp) D[n] = temp;
        }

        return D[n];
    }
}
