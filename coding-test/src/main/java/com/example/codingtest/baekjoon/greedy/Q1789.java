package com.example.codingtest.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * 서로 다른 N개의 자연수의 합이 S라고 한다. S를 알 때, 자연수 N의 최댓값은 얼마일까?
 *
 * 첫째 줄에 자연수 S(1 ≤ S ≤ 4,294,967,295)가 주어진다.
 *
 * 첫째 줄에 자연수 N의 최댓값을 출력한다.
 */
public class Q1789 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long target = Long.parseLong(br.readLine());

        Set<Long> collection = new HashSet<>();

        for (long num = 1; true; num++) {

            long tmp = target - num;

            if (tmp < 0) {
                break;
            }

            collection.add(num);
            target -= num;
        }

        boolean search = search(collection, target);

        if(search) {
            System.out.println(collection.size()+1);
        }
    }

    private static boolean search(Set<Long> collection, long target) {

        if(collection.contains(target)) {
            collection.remove(target);
            return search(collection, target + target);
        }

        return true;
    }
}
