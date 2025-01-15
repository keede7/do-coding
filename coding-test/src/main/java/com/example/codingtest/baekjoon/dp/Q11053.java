package com.example.codingtest.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.
 *
 * 예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은 A = {10, 20, 10, 30, 20, 50} 이고, 길이는 4이다.
 *
 * 입력
 * 첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000)이 주어진다.
 *
 * 둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000)
 *
 * 출력
 * 첫째 줄에 수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력한다.
 *
 * 예제 입력 1                    예제 출력 1
 * 6                            4
 * 10() 20() 10 30() 20 50()
 */
public class Q11053 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] D = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] count = new int[N];
        Arrays.fill(count, 1);

        // 각 값 기준에서 최장 증가길이끼리 비교를 하는것. (각 값끼리 비교가 아님)
        for (int i = 1; i < N; i++) {
            for (int j = 0; i > j; j++) {
                if(D[i] > D[j]) {
                    count[i] = Integer.max(count[i], count[j] + 1);
                }
            }
        }

        int result = Arrays.stream(count)
                .max()
                .getAsInt();

        System.out.println(result);
        //[1, 2, 1, 2, 3, 4, 3, 4, 5, 2, 6, 1, 2, 6, 7, 8, 6, 8, 7, 7]
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int[] arr = new int[N];
//        int[] dp = new int[N];
//        int res = 0;
//
//        for(int i=0; i<N; i++)   // N 만큼 돌면서 arr에 요소 저장
//            arr[i] = sc.nextInt();
//
//        for(int i=0; i<N; i++) {
//            dp[i] = 1;
//
//            System.out.println(Arrays.toString(dp));
//            for(int j=0; i>j; j++) {
//                if (arr[i] > arr[j]) { // 698
//                    dp[i] = Math.max(dp[i], dp[j]+1);
//                    res = Math.max(res,  dp[i]);
//                }
//            }
//            System.out.println(Arrays.toString(dp));
//            System.out.println();
//        }
//        System.out.println(res);
    }
}
