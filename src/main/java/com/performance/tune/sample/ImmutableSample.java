package com.performance.tune.sample;

public final class ImmutableSample {

    private final String name;
    private final int age;

    public ImmutableSample(String name,int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw  new CloneNotSupportedException();
    }

    @Override
    public String toString() {
        return "ImmutableSample{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
