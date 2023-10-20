package com.performance.tune.sample;


import com.performance.tune.sample.pojo.CD;
import com.performance.tune.sample.pojo.Employee;
import com.performance.tune.sample.utility.DataGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Sample {
    public static void main(String[] args){

        //mergeStream();

        //arraysToStream();

        writeCharFromStringToSout();
    }

    private static void writeCharFromStringToSout() {
        "Hello World".chars().skip(1).limit(1).mapToObj(i->(char)i).forEach(System.out::print);
    }

    private static void arraysToStream() {
        Arrays.stream(DataGenerator.getCDArrays(),0,1).forEach(System.out::println);
        Arrays.stream(new int[]{1,3,2},0,2).forEach(System.out::println);

        LongStream.of(new long[]{1,1}).forEach(System.out::println);
    }

    private static void mergeStream() {
        //Merge Streams
        var sequentialStream1 = Stream.of(List.of("a","b","c"));
        var sequentialStream2 = Stream.of(List.of(1,2,3));
        var sequentialStream3 = Stream.of(List.of(1,2,3)).parallel();

        System.out.println(sequentialStream1.isParallel());
        System.out.println(sequentialStream2.isParallel());
        System.out.println(sequentialStream3.isParallel());

        var streamConact = Stream.concat(sequentialStream1,sequentialStream3);
        streamConact.forEach(System.out::println);
        System.out.println(streamConact.isParallel());
    }
}
