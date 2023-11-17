package com.performance.tune.sample;

import com.performance.tune.sample.pojo.Address;
import com.performance.tune.sample.pojo.Employee;
import com.performance.tune.sample.pojo.Person;
import com.performance.tune.sample.utility.DataGenerator;

import java.util.ArrayList;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

public class Reduce {
    public static void main(String[] args) {
        var maxSalary = DataGenerator.getEmployees().stream()
                        .reduce(BinaryOperator.maxBy(comparing(Employee::getSalary))).orElse(null);
        var minSalary = DataGenerator.getEmployees().stream()
                .reduce(BinaryOperator.minBy(comparing(Employee::getSalary))).orElse(null);

        var min = DataGenerator.getEmployees().stream().min(comparing(Employee::getSalary)).get();
        var max = DataGenerator.getEmployees().stream().max(comparing(Employee::getSalary)).get();
        System.out.println(min);
        System.out.println(max);
        System.out.println(maxSalary);
        System.out.println(minSalary);
        var result = DataGenerator.getPersons().stream().map(Person::getName).peek(System.out::println).reduce("",(str,str1)-> str.concat(str1),(str,str1)-> str.concat(str1));
        System.out.println(result);
        //<U> U reduce(U identity,BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner);
        var rs = DataGenerator.getPersons().stream().map(Person::getAge).reduce(0,(val,accumulator)->val+accumulator,(accumulator,combiner)->accumulator+combiner);
        System.out.println(rs);
        //<R> R collect(Supplier<R> supplier,BiConsumer<R, ? super T> accumulator,BiConsumer<R, R> combiner);
        var rs1 = DataGenerator.getEmployees().stream().flatMap(e->e.getAddress().stream()).collect(ArrayList::new,ArrayList::add,ArrayList::addAll);
        System.out.println(rs1);
        rs1.add(new Address("204","samp",560064));
        System.out.println(rs1);

        var rs2 = DataGenerator.getEmployees().stream().flatMap(e->e.getAddress().stream()).collect(Collectors.toList());
                rs2.add(new Address("sam","tom",10));
        System.out.println(rs2);
        var rs3 = DataGenerator.getEmployees().stream().flatMap(e->e.getAddress().stream()).toList();
        //below line will give unsupported exception
        //rs3.add(new Address("sam","tom",10));
        System.out.println(rs3);

        var append = Stream.of("Hello","world!","{}").collect(()->new StringBuilder(),(sb,str)->sb.append(" ").append(str),(sb1,sb2)->sb1.append(sb2));
        System.out.println(append);


    }
}
