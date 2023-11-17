package com.performance.tune.sample;

import com.performance.tune.sample.pojo.CD;
import com.performance.tune.sample.pojo.Employee;
import com.performance.tune.sample.utility.DataGenerator;

import java.util.Arrays;

public class StreamToArray {
    public static void main(String[] args) {
        var employeeIds = DataGenerator.getEmployees().stream().map(Employee::getId).toArray(Integer[]::new);
        System.out.println(Arrays.toString(employeeIds));
        var tracks = Arrays.stream(DataGenerator.getCDArrays()).map(e->(CD)e).map(CD::noOfTracks).toArray(Integer[]::new);
        System.out.println(Arrays.toString(tracks));
    }
}
