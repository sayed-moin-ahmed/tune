package com.performance.tune.sample;


import com.performance.tune.sample.pojo.Employee;
import com.performance.tune.sample.pojo.Person;
import com.performance.tune.sample.utility.DataGenerator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
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
        //removeIf();
        //flatMap();
        //mapMulti();
        //rangeClosedWithNewArrayList();
        //System.out.println("hello".chars().skip(1).limit(2).mapToObj(e->(char) e).findFirst().get());
        //findMatch();
        //minMaxAvg();
        //reduce();
        BinaryOperator<String> sortStringAsc = (str1,str2) -> str1.compareTo(str2)>0?str1:str2;
        var result = sortStringAsc.apply("b","a");
        System.out.println("---"+result);
        String[] value = {"d","a","c","b"};
        var result1 = Stream.of(value).sorted(Collections.reverseOrder()).peek(System.out::println).reduce(sortStringAsc).orElse("");
        System.out.println(result1);
    }

    private static void reduce() {
        Double totalSalary = DataGenerator.getEmployees().stream().reduce(0.0,(sum,e)->sum+e.getSalary(),(sum1,sum2)->sum1+sum2);
        System.out.println(totalSalary);
    }

    private static void minMaxAvg() {
        Employee maxSalary = DataGenerator.getEmployees().stream().max(Comparator.comparing(Employee::getSalary).thenComparing(Employee::getId)).get();
        System.out.println(maxSalary);
        Employee minSalary = DataGenerator.getEmployees().stream().min(Comparator.comparing(Employee::getSalary).thenComparing(Employee::getId)).get();
        System.out.println(minSalary);
        double avgSalary = DataGenerator.getEmployees().stream().collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(avgSalary);
    }

    private static void findMatch() {
        System.out.println(IntStream.rangeClosed(1,10).anyMatch(e->e/2==0));
        System.out.println(IntStream.rangeClosed(1,10).allMatch(e->e/2==0));
        System.out.println(IntStream.rangeClosed(1,10).noneMatch(e->e/2==0));
    }

    private static void rangeClosedWithNewArrayList() {
        List<Integer> collect = IntStream.range(1,  10).boxed().sorted(Collections.reverseOrder()).collect(ArrayList::new, List::add, List::addAll);
        System.out.println(collect);
        List<Integer> collect1 = IntStream.range(1,  10).collect(ArrayList::new, List::add, List::addAll);
        System.out.println(collect1);
    }

    private static void flatMap() {
        DataGenerator.getEmployees().stream()
                .peek(System.out::println)
                .flatMap(e-> e.getAddress().stream())
                .forEach(System.out::println);
       /* List<String> input = List.of("a", "b", "c");
        List<String> result = input.stream()
                .flatMap(element -> Stream.of(element + "-1", element + "-2"))
                .collect(Collectors.toList());
        System.out.println(result);*/
    }

    private static void mapMulti() {
     /*   Stream.of(1, 2, 3, 4)
                .mapMulti((number, downstream) -> downstream.accept(number))
                .forEach(System.out::print);*/

        List<String> input = List.of("a", "b", "c");
        List<String> result = input.stream()
                .<String>mapMulti((element, consumer) -> {
                    consumer.accept(element + "-1");
                    consumer.accept(element + "-2");
                })
                .collect(Collectors.toList());
        System.out.println(result);
    }

    private static void removeIf() {
        Predicate<Person> test = person -> person.getAge()<=10;
        var result = new ArrayList<Person>(DataGenerator.getPersons());
        result.removeIf(test::test);
        System.out.println(result);
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
