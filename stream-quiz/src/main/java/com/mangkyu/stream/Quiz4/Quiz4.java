package com.mangkyu.stream.Quiz4;


import com.mangkyu.stream.Quiz1.Quiz1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Quiz4 {

    private List<Transaction> transactions;

    public Quiz4() {
        Trader kyu = new Trader("Kyu", "Seoul");
        Trader ming = new Trader("Ming", "Gyeonggi");
        Trader hyuk = new Trader("Hyuk", "Seoul");
        Trader hwan = new Trader("Hwan", "Busan");

        transactions = Arrays.asList(
                new Transaction(kyu, 2019, 30000),
                new Transaction(kyu, 2020, 12000),
                new Transaction(ming, 2020, 40000),
                new Transaction(ming, 2020, 7100),
                new Transaction(hyuk, 2019, 5900),
                new Transaction(hwan, 2020, 4900)
        );
    }

    public static void main(String[] args) {
        new Quiz4().quiz1();
    }

    // 4.1 2020년에 일어난 모든 거래 내역을 찾아 거래값을 기준으로 오름차순 정렬하라.
    public List<Transaction> quiz1() {
        /**
         * 1) 각 트랜잭션 중에서 2020년에 발생한 거래내역을 조회한다.
         * 2) 각 트랜잭션을 거래값으로 비교를 한다.
         * 3) 거래값이 높은순으로 정렬하자.
         */
        return transactions.stream()
                // 2020년 거래내역들을 필터링한다.
                .filter(transaction -> transaction.getYear() == 2020)
                // 각 거래내역의 값들을 가지고 비교한다.
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .collect(Collectors.toList());
    }

    // 4.2 거래 내역이 있는 거래자가 근무하는 모든 도시를 중복 없이 나열하라.
    public List<String> quiz2() {

        return transactions.stream()
                // .map(transaction -> transaction.getTrader.getCity)
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct() // distinct도 순서가 중요하다.
                .collect(Collectors.toList());
    }

    // 4.3 서울에서 근무하는 모든 거래자를 찾아서 이름순서대로 정렬하라.
    public List<Trader> quiz3() {
        /*
        해당 방법이 조금 더 안전할 것 같다.
        .map(Transaction::getTrader)
                .distinct()
                .filter(t -> t.getCity().equals("Seoul"))
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
         */

        return transactions.stream()
                .map(Transaction::getTrader)
                // 서울 거래자들을 뽑아낸다.
                .filter(trader -> trader.getCity().equals("Seoul"))
                // 해당 거래자들의 이름을 순서로 정렬한다.
                .sorted(Comparator.comparing(Trader::getName))
                .distinct()
                .collect(Collectors.toList());
    }

    // 4.4 모든 거래자의 이름을 구분자(",")로 구분하여 정렬하라.
    public String quiz4() {
        // 각 거래자들을 뽑아낸다
        return transactions.stream()
                .map(Transaction::getTrader)
                .distinct()
                // 이름으로 변환시켜 둔다.
                .map(Trader::getName)
                // 정렬한다.
                .sorted(Comparator.comparing(Function.identity()))
                // 거래자들의 이름을 기준으로 구분자를 만든다.
                .collect(Collectors.joining(","));
    }

    // 4.5 부산에 거래자가 있는지를 확인하라.
    public boolean quiz5() {
        return transactions.stream()
                .map(Transaction::getTrader)
                .anyMatch(trader -> trader.getCity().equals("Busan"));
    }

    // 4.6 서울에 거주하는 거래자의 모든 거래 금액을 구하라.
    public List<Integer> quiz6() {
        return transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Seoul"))
                // 동일한 mapping 조건이다.
//                .mapToInt(Transaction::getValue)
//                .boxed()
                .map(Transaction::getValue)
                .collect(Collectors.toList());

    }
 // TODO : 모든 거래 내역 중에서 거래 금액의 ,,
    // 4.7 모든 거래 내역중에서 최댓값과 최솟값을 구하라. 단, 최댓값은 reduce를 이용하고 최솟값은 stream의 min()을 이용하라.
    public Integer[] quiz7() {

        Integer max = transactions.stream()
                .map(Transaction::getValue)
                .reduce((integer, integer2) -> integer > integer2 ? integer : integer2)
//                .reduce(Integer::max)
                .get();

        Integer min = transactions.stream()
                .map(Transaction::getValue)
                .min(Comparator.comparing(Function.identity()))
                .orElse(null);

        return new Integer[]{max, min};
    }

}
