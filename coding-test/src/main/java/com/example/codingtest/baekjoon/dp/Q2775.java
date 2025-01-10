package com.example.codingtest.baekjoon.dp;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/**
 * 맞았지만 속도 이슈로 인해 틀렸음.
 */
public class Q2775 {

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
