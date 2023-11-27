package com.performance.tune.sample;

import com.performance.tune.sample.pojo.Employee;
import com.performance.tune.sample.utility.DataGenerator;

import java.util.stream.Collectors;

public class ParallelConcurrent {
    public static void main(String[] args) {

        var groupingByConcurrent  = DataGenerator.getEmployees().stream().parallel().collect(Collectors.groupingByConcurrent(Employee::getSalary,Collectors.groupingBy(Employee::getAge)));
        System.out.println(groupingByConcurrent);
        var mapByConcurrent = DataGenerator.getEmployees().stream().parallel().collect(Collectors.toMap(Employee::getId,Employee::getSalary));
        System.out.println(mapByConcurrent);
    }
}
