package com.performance.tune.sample;


import com.performance.tune.sample.pojo.CD;
import com.performance.tune.sample.pojo.Employee;
import com.performance.tune.sample.utility.DataGenerator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Sample {
    public static void main(String[] args) throws InterruptedException {

        //mergeStream();

        //arraysToStream();

        //writeCharFromStringToSout(DataGenerator.value);

        //stringStream();

        //fileReadStream();

        //dropWhile();

        //distinct();
    }

    private static void distinct() {
        //distinct works on equals and hashcode, if we remove then distinct will not work
        DataGenerator.getPersons().stream().distinct().toList().forEach(System.out::println);
    }

    private static void dropWhile() {
        var value = Stream.of("a","b","a","ab","abc").dropWhile(val->val.length()<=1).collect(Collectors.groupingBy(String::length));
        System.out.println(value);
    }

    private static void fileReadStream() {
        System.out.println("Enter Name:");
        var input = new Scanner(System.in).nextLine();
        try(var file = new FileReader(Sample.class.getClassLoader().getResource("./Sample.txt").getPath()); var bufferedReader = new BufferedReader(file); var stream = bufferedReader.lines()){
            stream.map(e->e.formatted(input)).forEach(System.out::println);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void stringStream() {
        DataGenerator.value.lines().map(e->e.split("")).collect(Collectors.groupingBy(Function.identity())).entrySet().forEach(e->System.out.println(e.getKey()+""+e.getValue()));
    }

    private static void writeCharFromStringToSout(String value) {
        System.out.println(value.subSequence(0,value.length()).chars().skip(1).limit(1).mapToObj(e->(char)e).findFirst().get());
        value.chars().skip(1).limit(1).mapToObj(i->(char)i).forEach(System.out::println);
        new Random().ints().limit(10).forEach(System.out::println);
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
