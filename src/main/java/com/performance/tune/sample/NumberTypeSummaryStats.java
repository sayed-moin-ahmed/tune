package com.performance.tune.sample;

import com.performance.tune.sample.pojo.Person;
import com.performance.tune.sample.utility.DataGenerator;

import java.util.stream.IntStream;

public class NumberTypeSummaryStats {
    public static void main(String[] args) {
        var emptyStream = IntStream.empty().summaryStatistics();
        System.out.println(emptyStream);
        var result = IntStream.range(0,Integer.MAX_VALUE).summaryStatistics();
        System.out.println(result);
        var summary = DataGenerator.getPersons().stream().mapToInt(Person::getAge).summaryStatistics();
        System.out.println(summary);
        while (true);
    }
}
