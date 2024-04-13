package com.example.codingtest.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제
 * 미국으로 유학간 동혁이는 세탁소를 운영하고 있다. 동혁이는 최근에 아르바이트로 고등학생 리암을 채용했다.
 * 동혁이는 리암에게 실망했다.
 * 리암은 거스름돈을 주는 것을 자꾸 실수한다.
 *
 * 심지어 $0.5달러를 줘야하는 경우에 거스름돈으로 $5달러를 주는것이다!
 *
 * 어쩔수 없이 뛰어난 코딩 실력을 발휘해 리암을 도와주는 프로그램을 작성하려고 하지만, 디아블로를 하느라 코딩할 시간이 없어서 이 문제를 읽고 있는 여러분이 대신 해주어야 한다.
 *
 * 거스름돈의 액수가 주어지면 리암이 줘야할 쿼터(Quarter, $0.25)의 개수, 다임(Dime, $0.10)의 개수, 니켈(Nickel, $0.05)의 개수, 페니(Penny, $0.01)의 개수를 구하는 프로그램을 작성하시오.
 *
 * 거스름돈은 항상 $5.00 이하이고, 손님이 받는 동전의 개수를 최소로 하려고 한다.
 *
 * 예를 들어, $1.24를 거슬러 주어야 한다면, 손님은 4쿼터, 2다임, 0니켈, 4페니를 받게 된다.
 *
 * 3
 * 124
 * 25
 * 194
 *
 * 4 2 0 4  (124)
 * 1 0 0 0  (25)
 * 7 1 1 4  (194)
 *
 */
public class Q2720 {
    private static final int[] COINS = {25, 10, 5, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            int targetCoins = Integer.parseInt(br.readLine());

            int quarter = targetCoins / COINS[0];
            targetCoins = targetCoins % COINS[0];

            int dime =  (targetCoins % COINS[0]) / COINS[1];
            targetCoins = targetCoins % COINS[1];

            int nickel =  (targetCoins % COINS[1]) / COINS[2];
            targetCoins = targetCoins % COINS[2];

            int penny =  (targetCoins % COINS[2]) / COINS[3];

            System.out.println(String.format("%d %d %d %d", quarter, dime, nickel, penny));
        }
    }

}
