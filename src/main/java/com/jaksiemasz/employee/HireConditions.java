package com.jaksiemasz.employee;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class HireConditions {

    public static Predicate<IEmployee> isNothing(){
        return (employee) -> true;
    }

    public static Predicate<IEmployee> isUniversity(String university){
        return (employee ) -> employee.getUniversity().equals(university);
    }

    public static Predicate<IEmployee> isSex(Sex sex){
        return (employee) -> employee.getSex() == sex;
    }

    public static Predicate<IEmployee> isCountry(String country){
        return (employee) -> employee.getOriginCountry().equals(country);
    }

    public static Predicate<IEmployee> isEmail(String email){
        return (employee) -> employee.getEmail().contains('@' + email);
    }

}
