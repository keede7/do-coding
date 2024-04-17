package com.example.codingtest.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 문제
 * 정렬된 두 묶음의 숫자 카드가 있다고 하자. 각 묶음의 카드의 수를 A, B라 하면 보통 두 묶음을 합쳐서 하나로 만드는 데에는 A+B 번의 비교를 해야 한다.
 * 이를테면, 20장의 숫자 카드 묶음과 30장의 숫자 카드 묶음을 합치려면 50번의 비교가 필요하다.
 *
 * 매우 많은 숫자 카드 묶음이 책상 위에 놓여 있다. 이들을 두 묶음씩 골라 서로 합쳐나간다면, 고르는 순서에 따라서 비교 횟수가 매우 달라진다.
 * 예를 들어 10장, 20장, 40장의 묶음이 있다면 10장과 20장을 합친 뒤, 합친 30장 묶음과 40장을 합친다면 (10 + 20) + (30 + 40) = 100번의 비교가 필요하다.
 * 그러나 10장과 40장을 합친 뒤, 합친 50장 묶음과 20장을 합친다면 (10 + 40) + (50 + 20) = 120 번의 비교가 필요하므로 덜 효율적인 방법이다.
 *
 * N개의 숫자 카드 묶음의 각각의 크기가 주어질 때, 최소한 몇 번의 비교가 필요한지를 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 N이 주어진다. (1 ≤ N ≤ 100,000) 이어서 N개의 줄에 걸쳐 숫자 카드 묶음의 각각의 크기가 주어진다.
 * 숫자 카드 묶음의 크기는 1,000보다 작거나 같은 양의 정수이다. 10, 20, 30 ,40 ,50  (((10+20) + 30) + 40)
 *
 * 1과2를 합친다, 1과2를 합친 값을 3과 합친다 1,2,3을 합친 값과 4를 합친다.
 */
public class Q1715 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long target = Long.parseLong(br.readLine());

        PriorityQueue<Long> queue = new PriorityQueue<>();

        for (long i = 0; i < target; i++) {
            queue.add(Long.parseLong(br.readLine()));
        }

        long result = 0;

        while(queue.size() > 1) {
            long before = queue.poll();
            long after = queue.poll();

            long sum = before + after;

            result += sum;
            queue.add(sum);
        }

        System.out.println(result);
    }
}
