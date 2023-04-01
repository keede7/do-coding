package com.mangkyu.stream.Quiz3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Quiz3 {

    private static final List<Integer> numbers1 = Arrays.asList(1, 2, 3);
    private static final List<Integer> numbers2 = Arrays.asList(3, 4);

    public static void main(String[] args) {
        new Quiz3().quiz1();
    }

    // 3.1 모든 숫자 쌍의 배열 리스트를 반환하여라.
    // ex) numbers1 = [1,2,3], numbers2 = [3,4] -> [(1,3), (1,4), (2,3), (2,4), (3,3), (3,4)]
    public List<Integer[]> quiz1() {
        /**
         * numbers 배열들을 각 기준으로 loop를 실행한다.
         * 각각의 대상을 ( x, y ) 형식으로 변환한다. 당했네 -> [x, y]
         */

        List<Integer[]> result = new ArrayList<>();
        // 해당 코드를 Stream으로 변환한다.
//        numbers1.forEach(num1 -> {
//                    numbers2.forEach(num2 -> {
//                                Integer[] target = new Integer[] {num1, num2};
//                                result.add(target);
//                            });
//                });
        // N개의 배열끼리 다룰 때는 항상 FlatMap을 쓴다....
        // 스트림 안에서 스트림을 또 열어서 하는 방법이 실제로 쓰이는 건가보네,,
        // 조금 특이해서 안했었는데 결국 특정 해결 방법이니 맞는듯,
        return numbers1.stream()
                .flatMap(num1 -> numbers2.stream().map(num2 -> new Integer[] {num1, num2}))
                .collect(Collectors.toList());
    }

    // 3.2 모든 숫자 쌍의 곱이 가장 큰 값을 반환하여라.
    // ex) numbers1 = [1,2,3], numbers2 = [3,4] -> 12
    public int quiz2() {

        /**
         * 1) 각 배열을 비교하도록 만든다.
         * 2) 각 배열의 값들을 서로 곱한다.
         * 3) 곱한 값을 하나씩 저장한다.
         * 4) 해당 값을 가지고있는 배열안에서 가장 높은 값을 반환한다.
         */

        // 답안 예시 1
//        numbers1.stream()
//                .flatMapToInt(num1 -> numbers2.stream().mapToInt(num2 -> num1 * num2))
//                .max()
//                .getAsInt()
        // 답안 예시2
//        numbers1.stream()
//                .flatMapToInt(num1 -> numbers2.stream().mapToInt(num2 -> num1 * num2))
//                .reduce((num1 , num2) -> num1 > num2 ? num1 :num2);
        //        .reduce(Math::max);
        // 답안 예시2 에서 변환할 수 있는 다른 값.
//        .reduce((num1 , num2) -> Math.max(num1, num2));

        return numbers1.stream()
                // flatMapToInt는 int 타입 특화 mapping이고 인자로 IntStream으로 변환하는 Function 타입 메서드로 변환하도록 한다.
                .flatMapToInt(num1 -> numbers2.stream().mapToInt(num2 -> num1 * num2))
                // reduce( 초기값, 각 값을 가지고 어떻게 변환을 할 것인가 ) => 각 reduce의 메서드마다 다르다.
                .reduce(Integer.MIN_VALUE, Math::max);
    }

}
