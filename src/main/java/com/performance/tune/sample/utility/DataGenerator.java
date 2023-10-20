package com.performance.tune.sample.utility;

import com.performance.tune.sample.pojo.CD;
import com.performance.tune.sample.pojo.Employee;
import com.performance.tune.sample.pojo.Genre;

import java.time.Year;
import java.util.List;

public class DataGenerator {
    public static List<CD>  getCDs() {
        // Some ready-made CDs.
        final CD cd0 = new CD("Jaav", "Java Jive", 8, Year.of(2017), Genre.POP);
        final CD cd1 = new CD("Jaav", "Java Jam", 6, Year.of(2017), Genre.JAZZ);
        final CD cd2 = new CD("Funkies", "Lambda Dancing", 10, Year.of(2018), Genre.POP);
        final CD cd3 = new CD("Genericos", "Keep on Erasing", 8, Year.of(2018), Genre.JAZZ);
        final CD cd4 = new CD("Genericos", "Hot Generics", 10, Year.of(2018), Genre.JAZZ);
        // A fixed-size list of CDs.
        List<CD> cdList = List.of(cd0, cd1, cd2, cd3, cd4);
        return cdList;
    }

    public static Object[] getCDArrays(){
        return getCDs().toArray();
    }


    public static List<Employee> getEmployees(){
        var employee1 =  new Employee(1,"a",10,"MALE","IT",01012020,1000);
        var employee3 = new Employee(3,"b",15,"FEMALE","IT",01012021,1001);
        var employee2 = new Employee(2,"c",10,"FEMALE","SALES",01012020,1000);
        var employee4= new Employee(4,"d",15,"MALE","SALES",01012021,1001);
        return  List.of(employee1,employee2,employee3,employee4);
    }


}
