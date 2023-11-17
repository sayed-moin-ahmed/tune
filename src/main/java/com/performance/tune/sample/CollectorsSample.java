package com.performance.tune.sample;

import com.performance.tune.sample.pojo.Address;
import com.performance.tune.sample.pojo.Employee;
import com.performance.tune.sample.pojo.Person;
import com.performance.tune.sample.utility.DataGenerator;

import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.function.UnaryOperator.identity;

public class CollectorsSample {
    public static void main(String[] args) {
        var averageSalary = DataGenerator.getEmployees().stream().collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(averageSalary);
        var groupBySalary = DataGenerator.getEmployees().stream().collect(Collectors.groupingBy(Employee::getSalary));
        System.out.println(groupBySalary);
        var maxBy = DataGenerator.getEmployees().stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary)));
        System.out.println(maxBy);
        var joining = DataGenerator.getEmployees().stream().map(Employee::getName).collect(Collectors.joining(","));
        System.out.println(joining);
        Function<Person, Integer> keyMapper = Person::getAge;
        Function<Person, String> valueMapper = Person::getName;
        var map1 = DataGenerator.getPersons().stream().collect(Collectors.toMap(keyMapper,valueMapper,(k1,k2)->k1));
        System.out.println(map1);
        BinaryOperator<Person> compare = (person1, person2) -> person1.getName().compareTo(person2.getName()) > 0 ? person1:person2;
        var map2 = DataGenerator.getPersons().stream().collect(Collectors.toMap(keyMapper,identity(),compare));
        System.out.println(map2);
    }
}
