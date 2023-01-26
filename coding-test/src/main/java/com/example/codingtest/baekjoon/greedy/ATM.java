package com.example.codingtest.baekjoon.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATM {
    public static void main(String[] args) throws IOException {

        // 입력 오픈
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 첫번쨰 입력을 받는다.
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력값으로 배열을 생성
        int N = Integer.parseInt(st.nextToken());
        int arr[] = new int[N];
        // 그 다음값부터는 배열의 값을 저장.
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 간단하게 아래 방법으로도 정렬 가능
		Arrays.sort(arr);

//        // 삽입 정렬
//        for (int i = 1; i < N; i++) {
//            int insert_index = i;
//            int insert_value = arr[i];
//            for (int j = i; j > 0; j--) {
//                if (arr[j - 1] < insert_value) {
//                    break;
//                }
//
//                insert_index = j - 1;
//            }
//
//            for (int j = i; j > insert_index; j--) {
//                arr[j] = arr[j - 1];
//            }
//
//            arr[insert_index] = insert_value;
//        }

        int sum[] = new int[N];
        sum[0] = arr[0];
        int answer = arr[0];
        for (int i = 1; i < N; i++) {
            sum[i] = sum[i - 1] + arr[i];
            answer += sum[i];
        }
        System.out.println(answer);
    }
}
