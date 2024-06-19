package com.example.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 문제
 * N개의 정수가 주어진다. 이때, 최솟값과 최댓값을 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 정수의 개수 N (1 ≤ N ≤ 1,000,000)이 주어진다.
 * 둘째 줄에는 N개의 정수를 공백으로 구분해서 주어진다.
 * 모든 정수는 -1,000,000보다 크거나 같고, 1,000,000보다 작거나 같은 정수이다.
 *
 * 출력
 * 첫째 줄에 주어진 정수 N개의 최솟값과 최댓값을 공백으로 구분해 출력한다.
 */
public class Q10818 {

    // Memory 165_400KB, Time 720ms
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(
                br.readLine().trim()
        );

        if(count == 1){
            String input = br.readLine()
                    .trim();

            System.out.printf("%s %s", input, input);
            return;
        }

        Queue<Integer> minQueue = new PriorityQueue<>();
        Queue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());

        Arrays.stream(
                br.readLine()
                        .trim()
                        .split(" ")
                )
                .mapToInt(Integer::parseInt)
                .forEach(value -> {
                    maxQueue.add(value);
                    minQueue.add(value);
                });

        int min = minQueue.poll();
        int max = maxQueue.poll();

        System.out.printf("%d %d", min, max);
    }

}
