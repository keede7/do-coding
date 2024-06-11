package com.example.codingtest.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 문제
 * Day Of Mourning의 기타리스트 강토가 사용하는 기타에서 N개의 줄이 끊어졌다.
 * 따라서 새로운 줄을 사거나 교체해야 한다. 강토는 되도록이면 돈을 적게 쓰려고 한다.
 * 6줄 패키지를 살 수도 있고, 1개 또는 그 이상의 줄을 낱개로 살 수도 있다.
 *
 * 끊어진 기타줄의 개수 N과 기타줄 브랜드 M개가 주어지고,
 * 각각의 브랜드에서 파는 기타줄 6개가 들어있는 패키지의 가격, 낱개로 살 때의 가격이 주어질 때,
 * 적어도 N개를 사기 위해 필요한 돈의 수를 최소로 하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 N과 M이 주어진다.
 * N은 100보다 작거나 같은 자연수이고, M은 50보다 작거나 같은 자연수이다.
 * 둘째 줄부터 M개의 줄에는 각 브랜드의 패키지 가격과 낱개의 가격이 공백으로 구분하여 주어진다.
 * 가격은 0보다 크거나 같고, 1,000보다 작거나 같은 정수이다.
 *
 * 출력
 * 첫째 줄에 기타줄을 적어도 N개 사기 위해 필요한 돈의 최솟값을 출력한다.
 */
public class Q1049 {

    public static void main(String[] args) throws Exception {

        PriorityQueue<Integer> packages = new PriorityQueue<>();
        PriorityQueue<Integer> piece = new PriorityQueue<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int 필요한_기타_끈_수 = Integer.parseInt(input[0]);
        int size = Integer.parseInt(input[1]);

        int 필요금액 = 0;

        for (int i = 0; i < size; i++) {
            String[] sample = br.readLine().split(" ");
            packages.add(Integer.parseInt(sample[0]));
            piece.add(Integer.parseInt(sample[1]));
        }

        System.out.println("packages = " + packages);
        System.out.println("piece = " + piece);

        final int 패키지_개수 = 6;

//        for(int idx = 0; idx < size; idx++) {
            // 필요한 기타줄을 패키지 개수로 몫과 나머지를 구한다.
            int 몫 = 필요한_기타_끈_수 / 패키지_개수;
            int 나머지값 = 필요한_기타_끈_수 % 패키지_개수;
        System.out.println("몫 = " + 몫);
        System.out.println("나머지값 = " + 나머지값);

            int 패키지가격 = packages.poll();
            int 낱개당가격 = piece.poll();

            // 낱개 가격 * 나머지 값의 가격이 패키지 가격보다 높으면
            // 몫 + 1의 계산값과 패키지가격을 곱한다.
        System.out.println("낱개당가격 * 나머지값 = " + 낱개당가격 * 나머지값);
        System.out.println("낱개당가격 * 필요한_기타_끈_수  = " + 낱개당가격 * 필요한_기타_끈_수);
        System.out.println("패키지가격 = " + 패키지가격);

        // 낱개 당 가격으로 모두 샀을때 합리적이면 모두 구매한다.
        if( 낱개당가격 * 필요한_기타_끈_수 <= 패키지가격 ){
            필요금액 += 낱개당가격 * 필요한_기타_끈_수;
            System.out.println("money = " + 필요금액);
            return;
        }


//        if(나머지값 * 낱개당가격 <= 패키지가격) {
//            필요금액 += 나머지값 * 낱개당가격;
//        } else {
//            필요금액 += 패키지가격 * (몫 + 1);
//        }

        System.out.println("필요금액 = " + 필요금액);
        // 그 다음 몫과 패키지금액을 곱한 값과 몫 * 6 * 낱개금액 을 비교해서 패키지금액이 더 크면 패키지금액을 더한다.
        // 그게 아니라면 몫 * 6 * 낱개금액을 더한다.
        System.out.println();
        System.out.println("몫 * 패키지가격 = " + 몫 * 패키지가격);
        System.out.println("몫 * 6 * 낱개당가격 = " + 몫 * 6 * 낱개당가격);

        if( (몫 * 패키지가격) > (몫 * 6 * 낱개당가격) ) {
            필요금액 += 몫 * 패키지가격;
        } else {
            필요금액 += 몫 * 6 * 낱개당가격;
        }

//            if(piecePrice * count > packagePrice) {
//                money += quotient * packagePrice;
//                money += remains * piecePrice;
//                System.out.println("money1 = " + money);
//            } else {
//                money += count * piecePrice;
//                System.out.println("money2 = " + money);
//            }

//            if(piecePrice * remains > packagePrice) {
//
//            }
//        }

        // 패키지 가격으로 우선 계산할 경우 (예제 계산은 맞으나 반례가 존재하여 실패)
//        for(int idx = 0; idx < size; idx++) {
//            // 1. 필요한 기타줄의 개수를 파악한다.
//            // 2. 일단 6개 패키지로 필요한 기타줄의 개수를 나눈다.
//            int packagePrice = packages.poll();
//            int quotient = count / packageCount;
//
//            System.out.println("quotient = " + quotient);
//            // 3. 나눈 몫과 6개 패키지의 값을 곱한 다음 결과값에 더한다.
//            int multipleResult = packagePrice * quotient;
//            System.out.println("multipleResult = " + multipleResult);
//
//            money += multipleResult;
//            System.out.println("money = " + money);
//            // 합한 개수를 뺀다
//            count -= quotient * packageCount;
//            System.out.println("패키지 금액 계산 후 필요한 기타줄 개수 = " + count);
//            System.out.println("count = " + count);
//            int piecePrice = piece.poll();
//            System.out.println("piecePrice = " + piecePrice);
//
//            int remains = count % packageCount;
//            System.out.println("remains = " + remains);
//            // 4. 나머지 값을 낱개의 값에 곱한다.
//            int remainsMultiple = remains * piecePrice;
//            System.out.println("remainsMultiple = " + remainsMultiple);
//            // 5. 4번 과정의 값과 6개 패키지 금액의 값을 비교 했을 때,
//            // 6. 4번의 값이 패키지 가격을 초과할 경우에는 패키지 가격으로 1개를 더 산다.
//            // 7. 아니라면 4번의 금액을 결과값에 더한다.
//            money += Math.min(remainsMultiple, packagePrice);
//            count -= remains;
//
//            System.out.println();
//
//            if(count <= 0) {
//                break;
//            }
//        }

        System.out.println("money = " + 필요금액);
    }

}
