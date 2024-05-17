package com.example.codingtest.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 문제
 * 민식이는 다음과 같은 폴리오미노 2개를 무한개만큼 가지고 있다. AAAA와 BB
 *
 * 이제 '.'와 'X'로 이루어진 보드판이 주어졌을 때, 민식이는 겹침없이 'X'를 모두 폴리오미노로 덮으려고 한다. 이때, '.'는 폴리오미노로 덮으면 안 된다.
 *
 * 폴리오미노로 모두 덮은 보드판을 출력하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 보드판이 주어진다. 보드판의 크기는 최대 50이다.
 *
 * 출력
 * 첫째 줄에 사전순으로 가장 앞서는 답을 출력한다. 만약 덮을 수 없으면 -1을 출력한다.
 */
public class Q1343 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String input = st.nextToken();

        String result = input.replaceAll("XXXX", "AAAA");

        result = result.replaceAll("XX", "BB");

        if(result.contains("X")) {
            result = "-1";
        }

        System.out.println(result);
    }

}
