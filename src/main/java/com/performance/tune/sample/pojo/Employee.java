package com.performance.tune.sample.pojo;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class Employee{

    public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary, List<Address> addresses) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
        this.addresses = addresses;
    }

    private int id;
    private String name;
    private int age;
    private String gender;
    private String department;
    private int yearOfJoining;
    private double salary;
    private List<Address> addresses;

    public List<Address> getAddress() {
        return addresses;
    }

    public void setAddress(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && age == employee.age && yearOfJoining == employee.yearOfJoining && Double.compare(salary, employee.salary) == 0 && Objects.equals(name, employee.name) && Objects.equals(gender, employee.gender) && Objects.equals(department, employee.department) && Objects.equals(addresses, employee.addresses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, gender, department, yearOfJoining, salary, addresses);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Employee.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("age=" + age)
                .add("gender='" + gender + "'")
                .add("department='" + department + "'")
                .add("yearOfJoining=" + yearOfJoining)
                .add("salary=" + salary)
                .add("address=" + addresses)
                .toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public void setYearOfJoining(int yearOfJoining) {
        this.yearOfJoining = yearOfJoining;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}