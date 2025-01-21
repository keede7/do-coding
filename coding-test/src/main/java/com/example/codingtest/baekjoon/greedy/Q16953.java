package com.example.codingtest.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 정수 A를 B로 바꾸려고 한다. 가능한 연산은 다음과 같은 두 가지이다.
 *
 * 2를 곱한다.
 * 1을 수의 가장 오른쪽에 추가한다.
 *
 * A를 B로 바꾸는데 필요한 연산의 최솟값을 구해보자.
 *
 * 입력
 * 첫째 줄에 A, B (1 ≤ A < B ≤ 109)가 주어진다.
 *
 * 출력
 * A를 B로 바꾸는데 필요한 연산의 최솟값에 1을 더한 값을 출력한다. 만들 수 없는 경우에는 -1을 출력한다.
 *
 * 예제 입력 1        예제 출력 1
 * 2 162            5
 *
 * 2 → 4 → 8 → 81 → 162
 *
 * 예제 입력 2        예제 출력 2
 * 4 42             -1
 *
 * 예제 입력 3         예제 출력 3
 * 100 40021         5
 *
 * 100 → 200 → 2001 → 4002 → 40021
 */
public class Q16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int result = 1;

        while (A != B) {
            if(A > B) {
                System.out.println("-1");
                return;
            }

            String s = String.valueOf(B);

            if(B % 2 == 0) {
                B = B / 2;
            } else if (s.charAt(s.length() - 1) == '1') {
                s = s.substring(0, s.length() - 1);
                B = Integer.parseInt(s);
            } else {
                System.out.println("-1");
                return;
            }

            result++;
        }

        System.out.println(result);
    }
}
