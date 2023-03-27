package com.mangkyu.stream.Quiz1;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Quiz1 {

    public static void main(String[] args) throws IOException {
        new Quiz1().quiz3();
    }

    // 1.1 각 취미를 선호하는 인원이 몇 명인지 계산하여라.
    public Map<String, Integer> quiz1() throws IOException {
        List<String[]> csvLines = readCsvLines();

        /**
         * 두번째 문자열(취미) 를 가져온다.
         * 각 문자열을 특정 문자를 기준으로 쪼갠다.
         * 각 운동을 기준으로 개수를 추가한다.
         */

        Map<String, Integer> result = csvLines.stream()
                .map(user -> user[1].trim())
                .peek(System.out::println)
                .flatMap(hobbies -> Stream.of(hobbies.split(":")))
                .collect(Collectors.toMap(Function.identity(), hobby -> 1, (before, after)-> before += after));

        System.out.println("result = " + result);
        return result;
    }

    // 1.2 각 취미를 선호하는 정씨 성을 갖는 인원이 몇 명인지 계산하여라.
    public Map<String, Integer> quiz2() throws IOException {
        List<String[]> csvLines = readCsvLines();

        Map<String, Integer> result = csvLines.stream()
                .filter(user -> user[0].contains("정"))
                .map(user -> user[1].trim())
                .flatMap(hobbies -> Arrays.stream(hobbies.split(":")))
                // keyMapper의 경우 hobby -> hobby 와 같이 자기 자신(취미 문자열)을 Key로 하지만
                // 자기 자신을 사용할 경우 항등함수인 Function.identity()로 표현이 가능하다.
                .collect(Collectors.toMap(Function.identity(), hobby -> 1, (before, after) -> before += after));

        System.out.println("result = " + result);

        return result;
    }

    // 1.3 소개 내용에 '좋아'가 몇번 등장하는지 계산하여라.
    public int quiz3() throws IOException {
        List<String[]> csvLines = readCsvLines();

        final String filterStr = "좋아";

        int sum = csvLines.stream()
                .filter(user -> user[2].contains(filterStr))
                .map(user -> user[2].trim())
                .mapToInt(intro -> intro.length() - intro.replace(filterStr, " ").length()).sum();

        return sum;
    }

    private List<String[]> readCsvLines() throws IOException {
        CSVReader csvReader = new CSVReader(new FileReader(getClass().getResource("/user.csv").getFile()));
        csvReader.readNext();
        return csvReader.readAll();
    }

}
