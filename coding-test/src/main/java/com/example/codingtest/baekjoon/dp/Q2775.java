package com.example.codingtest.baekjoon.dp;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/**
 * 평소 반상회에 참석하는 것을 좋아하는 주희는 이번 기회에 부녀회장이 되고 싶어 각 층의 사람들을 불러 모아 반상회를 주최하려고 한다.
 *
 * 이 아파트에 거주를 하려면 조건이 있는데, “a층의 b호에 살려면 자신의 아래(a-1)층의 1호부터 b호까지 사람들의 수의 합만큼 사람들을 데려와 살아야 한다” 는 계약 조항을 꼭 지키고 들어와야 한다.
 *
 * 아파트에 비어있는 집은 없고 모든 거주민들이 이 계약 조건을 지키고 왔다고 가정했을 때, 주어지는 양의 정수 k와 n에 대해 k층에 n호에는 몇 명이 살고 있는지 출력하라.
 * 단, 아파트에는 0층부터 있고 각층에는 1호부터 있으며, 0층의 i호에는 i명이 산다.
 *
 * 입력
 * 첫 번째 줄에 Test case의 수 T가 주어진다. 그리고 각각의 케이스마다 입력으로 첫 번째 줄에 정수 k, 두 번째 줄에 정수 n이 주어진다
 *
 * 출력
 * 각각의 Test case에 대해서 해당 집에 거주민 수를 출력하라.
 *
 * 제한
 * 1 ≤ k, n ≤ 14
 * 예제 입력 1            예제 출력 1
 * 2                    6
 * 1                    10
 * 3
 * 2
 * 3
 */
public class Q2775 {
/*
    1층 3호에 산다   => 0층의 1,2,3 => 6명
    2층 3호에 산다.. => 1층의 1,3,6 => 10명
    3층 3호에 산다.. => 2층의 1,4,10 => 15명
    4층 3호에 산다.. => 3층의 1,5,15 => 21명

    1층 2호에 산다   => 0층의 1,2 => 3명
    2층 2호에 산다.. => 1층의 1,3 => 4명
    3층 2호에 산다.. => 2층의 1,4 => 5명
    4층 2호에 산다.. => 3층의 1,5 => 6명

                     N층의 N, (N, N+1), (N , N+1, N+2)
 */

    static int[] G_STAIR;
    static Queue<Integer> queue = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int HO = Integer.parseInt(st.nextToken());

        G_STAIR = new int[15];

        for (int i = 0; i < G_STAIR.length; i++) {
            G_STAIR[i] = i;
        }

        for (int i = 0; i < HO; i++) {
            st = new StringTokenizer(br.readLine());
            int stair = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int ho = Integer.parseInt(st.nextToken());

            // DP ON
            int result = dp(stair, ho);
            System.out.println("result = " + result);
            queue.add(result);
            System.out.println("queue.poll() : " + queue.poll());
            System.out.println("queue.poll() : " + queue.poll());
        }


    }

    private static int dp(int stair, int ho) {
        if(stair <= 1) {
            return IntStream
                    .rangeClosed(1, ho)
                    .sum();
        }

        for (int i = 0; i < stair; i++) {
            for (int j = ho; j > 0; j--) {
                System.out.println("ho = " + ho);
                int c = Arrays.stream(G_STAIR).limit(j+1).sum();
                System.out.println("c = " + c);
                G_STAIR[j] = c;
            }
        }

        System.out.println("Arrays.toString(G_STAIR) = " + Arrays.toString(G_STAIR));

        return G_STAIR[ho];
    }

}
