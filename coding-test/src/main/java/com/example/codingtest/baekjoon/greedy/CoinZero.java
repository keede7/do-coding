package com.example.codingtest.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  11047번 문제
 */
public class CoinZero {

    public static void  main(String[] args) throws IOException {

        // 왜 Scanner로도 할 수 있는데 이것을 쓰는 이유
        // 입력 오픈
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 첫번쨰 입력을 받는다.
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 각 동전의 개수와 가격을 받는다.
        int coinCount = Integer.parseInt(st.nextToken());
        int toCalcTargetPrice = Integer.parseInt(st.nextToken());

        if( 1 > coinCount || coinCount > 10) {
            return;
        }

        if( 1 > toCalcTargetPrice || toCalcTargetPrice > 100_000_000) {
            return;
        }
        // 각 코인들을 받을 배열을 생성
        int[] coinList = new int[coinCount];

        int inputCount = 0;
        // 각 라인을 받아서 배열에 하나씩 추가한다.
        while(inputCount < coinCount) {
//            st = new StringTokenizer(br.readLine());

            int i = Integer.parseInt(br.readLine());

            if ( 1 > i || i > 1_000_000) {
                System.exit(0);
            }

            coinList[inputCount] =  i;
            ++inputCount;
        }

        int result = 0;

        for(int index = coinList.length - 1 ; index >= 0; index--) {
            int targetValue = coinList[index];

            if(toCalcTargetPrice > targetValue) {
                result += toCalcTargetPrice / targetValue;
                toCalcTargetPrice %= targetValue;
            }
        }

        System.out.println(result);

    }
}
