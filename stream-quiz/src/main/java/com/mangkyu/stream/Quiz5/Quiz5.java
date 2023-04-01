package com.mangkyu.stream.Quiz5;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Quiz5 {

    private static final String[] STRING_ARR = {"aaa", "bb", "c", "dddd"};

    // 5.1 모든 문자열의 길이를 더한 결과를 출력하여라.
    public int quiz1() {
        return Arrays.stream(STRING_ARR)
                .mapToInt(String::length)
                .sum();
    }

    // 5.2 문자열 중에서 가장 긴 것의 길이를 출력하시오.
    public int quiz2() {

        return Arrays.stream(STRING_ARR)
                .mapToInt(String::length)
                .reduce(Integer.MIN_VALUE, Math::max);

    }

    // 5.3 임의의 로또번호(1~45)를 정렬해서 출력하시오.
    public List<Integer> quiz3() {

        /**
         *  방법 1
         *      1) 1~45까지 만든 배열을 만든다
         *      2) 해당 배열을 랜덤으로 섞는다.
         *      3) 6개 까지 뽑는다.
         *      4) 다시 정렬한다.
         */

        // 배열을 쫙 만들고,
        // 해당 배열에서 랜덤으로 뽑아서 넣어두는,,

        return new Random()
                .ints(45, 1, 45)
                .distinct()
                .limit(6)
                .sorted()
                .boxed()
                .collect(Collectors.toList());

    }

    // 5.4 두 개의 주사위를 굴려서 나온 눈의 합이 6인 경우를 모두 출력하시오.
    public List<Integer[]> quiz4() {

        final int DICE_MIN_VALUE = 1;
        final int DICE_MAX_VALUE = 6;

        return IntStream.rangeClosed(DICE_MIN_VALUE, DICE_MAX_VALUE)
                .boxed()
                .flatMap( number1 -> IntStream.rangeClosed(DICE_MIN_VALUE, DICE_MAX_VALUE)
                        .filter(number2 -> number1 + number2 == DICE_MAX_VALUE)
                        .boxed()
                        .map(number2 -> new Integer[] {number1, number2}))
                .collect(Collectors.toList());
    }

}
