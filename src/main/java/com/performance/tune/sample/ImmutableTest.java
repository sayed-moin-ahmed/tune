package com.performance.tune.sample;

public class ImmutableTest {
    public static void main(String[] args) {
        var immutable = new ImmutableRecord("a",10);
        System.out.println(immutable);
        System.out.println(immutable.age()+"--"+immutable.name());
        var immutableSample = new ImmutableSample("b",11);
        try {
            immutableSample.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println(immutableSample);
        System.out.println(immutableSample.getAge()+"--"+immutableSample.getName());

    }
}
