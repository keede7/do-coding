package com.example.codingtest.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1789 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long target = Long.parseLong(br.readLine());

        long sum = 0;
        long count = 0;

        for (long value = 1; true; value++) {

            sum += value;
            count++;

            if(sum > target) {
                count--;
                break;
            }
        }

        System.out.println(count);
    }

}
