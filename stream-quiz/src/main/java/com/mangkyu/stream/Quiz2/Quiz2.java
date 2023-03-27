package com.mangkyu.stream.Quiz2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Quiz2 {

    private static List<String> WORDS = Arrays.asList("TONY", "a", "hULK", "B", "america", "X", "nebula", "Korea");

    // 2.1 List에 저장된 단어들의 접두사가 각각 몇개씩 있는지 Map<String, Integer>으로 변환하여라.
    // ex) ("T", 1), ("a", 2) ...
    public Map<String, Integer> quiz1() {

        /**
         *  각 문자열의 접두사 값을 추출한다.
         *  접두사 문자의 개수를 합친다.
         */
        Map<String, Integer> result = WORDS.stream()
                // 첫번째 값을 추출.
                .map(word -> String.valueOf(word.charAt(0)))
                .collect(
                        Collectors.toMap(
                                Function.identity(),
                                str -> 1,
                                (before, after) -> before += after)
                );

        return result;
    }

    // 2.2 List에 저장된 단어들 중에서 단어의 길이가 2 이상인 경우에만, 모든 단어를 대문자로 변환하여 스페이스로 구분한 하나의 문자열로 합한 결과를 반환하여라.
    // ex) ["Hello", "a", "Island", "b"] -> “H I”
    public String quiz2() {
        /**
         * 1. 컬렉션의 각 문자열 중에서 길이가 2개 이상인 단어를 추출한다.
         * 2. 단어를 대문자로 변환한다.
         * 3. 각 단어의 접두사를 스페이스로 구분하여 합친다.
         */

        String result = WORDS.stream()
                .filter(word -> word.length() >= 2)
                .map(word -> String.valueOf(word.charAt(0)))
                .map(String::toUpperCase)
                .reduce((str1, str2) -> str1 += (" "+str2))
                .orElse(null);

        System.out.println("result = " + result);

        return result;
    }

}
