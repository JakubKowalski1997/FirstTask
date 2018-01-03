package com.jaksiemasz.company_struct;

import com.jaksiemasz.employee.*;

import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CompanyFactory {

    private Random generate = new Random();

    public void print(int levels) {
        Random generator = new Random();
        TeamMenager CEO = new TeamMenager(randomName(),generator.nextInt(2) + 1, EEmployeeRole.CEO, randomEmail(), randomOriginCountry(), randomSex(), randomUniversity(), randomPredicate());
        fillStructure(CEO, levels);
        System.out.println(CEO);
        printStructure(CEO, "+");

    }

    private void fillStructure(TeamMenager manager, int d) {
        if (d <= 0) return;
        d--;

        Random generator = new Random();
        while (manager.canHire()) {
            boolean isManager = generator.nextBoolean();
            if (isManager)
                manager.hire(new TeamMenager(randomName()
                        ,generator.nextInt(5) + 1,EEmployeeRole.Manager, randomEmail(), randomOriginCountry(), randomSex(), randomUniversity(), randomPredicate()));
            else
                manager.hire(new Developer(randomName()
                        , randomRole(), randomEmail(), randomOriginCountry(), randomSex(), randomUniversity(), 10));
                //manager.hire(new Developer.DeveloperBuilder().name(randomName()).role(randomRole()).setCountry(randomOriginCountry()).setEmail(randomEmail()).setSex(randomSex()).setUniversity(randomUniversity()).setFreeResources(10).build());
        }
        for (IEmployee m:
                manager.getEmployeeList().parallelStream()
                        .filter(e -> e instanceof TeamMenager)
                        .collect(Collectors.toList())) {
            fillStructure((TeamMenager) m, d);
        }
    }

    private void printStructure(TeamMenager manager, String lvl) {
        //System.out.println(manager);
        for (IEmployee e :
                manager.getEmployeeList()) {
            System.out.println(lvl + e);
            for (IEmployee e2 :
                    manager.getEmployeeList()) {
                if (e2 instanceof TeamMenager)
                    printStructure((TeamMenager) e2, lvl + "+");
            }
        }
    }
    private EEmployeeRole randomRole(){
        EEmployeeRole[] roles = {EEmployeeRole.Contributor, EEmployeeRole.Developer
                , EEmployeeRole.TeamLeader, EEmployeeRole.Tester};
        //Random generator = new Random();
        return roles[generate.nextInt(roles.length)];

    }


    private String randomNames() {
        String[] name = {"John", "Marcus", "Susan", "Henry", "Jacob", "Thomas", "Angela", "Eliot", "Sammy", "Johanos"};

        return name[generate.nextInt(name.length)];
    }

    private String randomSurname() {
        String[] name = {"Smith", "Merc", "Bean", "Beer", "Anderson" , "Janson", "Scala", "Kowalsky", "Nowak", "Jeferson", "Bell", "Edison", "Tesla"};

        return name[generate.nextInt(name.length)];
    }

    private String randomName(){
        return randomNames() + randomSurname();
    }

    private String randomOriginCountry(){
        String[] countryArray = {"Poland", "Russia", "UK", "Germany", "Slovakia", "USA"};

        return countryArray[generate.nextInt(countryArray.length)];
    }

    private Sex randomSex(){
        return generate.nextBoolean() ? Sex.FEMALE : Sex.MALE;
    }

    private String randomEmail() {
        String[] emailArray = {"onet.pl", "gmail.com", "o2.pl", "agh.edu.pl", "wp.pl"};
        return randomName() + '@' + emailArray[generate.nextInt(5)];
    }

    private String randomUniversity() {
        String[] universityArray = {"agh", "uj", "uek", "pk"};
        return universityArray[generate.nextInt(universityArray.length)];
    }

    private Predicate<IEmployee> randomPredicate() {
        return HireConditions.isNothing();
    }

}
