package com.performance.tune.sample;

import com.performance.tune.sample.pojo.Employee;
import com.performance.tune.sample.utility.DataGenerator;

import java.util.function.BinaryOperator;

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
        var list = DataGenerator.getEmployees().stream().sorted(comparing(Employee::getSalary)).toList();

    }
}
