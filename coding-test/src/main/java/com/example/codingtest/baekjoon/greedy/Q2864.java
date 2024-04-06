package com.example.codingtest.baekjoon.greedy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 2864번 문제
 * 상근이는 2863번에서 표를 너무 열심히 돌린 나머지 5와 6을 헷갈리기 시작했다.
 * 상근이가 숫자 5를 볼 때, 5로 볼 때도 있지만, 6으로 잘못 볼 수도 있고, 6을 볼 때는, 6으로 볼 때도 있지만, 5로 잘못 볼 수도 있다.
 * 두 수 A와 B가 주어졌을 때, 상근이는 이 두 수를 더하려고 한다. 이때, 상근이가 구할 수 있는 두 수의 가능한 합 중, 최솟값과 최댓값을 구해 출력하는 프로그램을 작성하시오.
 *
 * 첫째 줄에 두 정수 A와 B가 주어진다. (1 <= A,B <= 1,000,000)
 */
public class Q2864 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String[] split = input.split(" ");

        if(
                (1 > Integer.parseInt(split[0]) || Integer.parseInt(split[0]) > 1_000_000 )
                || (1 > Integer.parseInt(split[1]) || Integer.parseInt(split[1]) > 1_000_000 )
        ) {
            return;
        }

        AtomicInteger min = new AtomicInteger(0);
        AtomicInteger max = new AtomicInteger(0);

        Arrays.stream(split)
                .forEach(value -> {
                    StringBuilder 최소값 = new StringBuilder();
                    StringBuilder 최대값 = new StringBuilder();

                    for (int idx = 0; idx < value.length(); idx++) {
                        char val = value.charAt(idx);

                        // 만약 5면 6을 추가한다.
                        if(val == '6') {
                            최소값.append("5");
                            최대값.append(val);
                        } else if(val == '5') {
                            최소값.append(val);
                            최대값.append("6");
                        } else {
                            최소값.append(val);
                            최대값.append(val);
                        }
                    }

                    min.getAndAdd(Integer.parseInt(최소값.toString()));
                    max.getAndAdd(Integer.parseInt(최대값.toString()));

                });

        System.out.println(String.format("%s %s", min.get(), max.get()));
    }

}
