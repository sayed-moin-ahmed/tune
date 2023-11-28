package com.performance.tune.sample;

import com.performance.tune.sample.pojo.Employee;
import com.performance.tune.sample.utility.DataGenerator;

import java.util.stream.Collectors;

public class PartitionSample {
    public static void main(String[] args) {
        var partitioningByAge = DataGenerator.getEmployees().stream().collect(Collectors.partitioningBy(employee -> employee.getAge()>10));
        System.out.println(partitioningByAge);

        var partitioningGroupBy = DataGenerator.getEmployees().stream().collect(Collectors.partitioningBy(employee -> employee.getAge()>10,Collectors.groupingBy(Employee::getAge)));
        System.out.println(partitioningGroupBy);

        var groupByWithMapping = DataGenerator.getEmployees().stream().collect(Collectors.groupingBy(Employee::getSalary,Collectors.mapping(Employee::getAge,Collectors.toList())));
        System.out.println(groupByWithMapping);

        var mappingWithGroupBy = DataGenerator.getEmployees().stream().map(Employee::getAge).collect(Collectors.toList());
        System.out.println(mappingWithGroupBy);

    }
}
