package com.jaksiemasz;

import java.util.Random;
import java.util.stream.Collectors;

public class CompanyFactory {

    public void print(int levels) {
        Random generator = new Random();
        TeamMenager CEO = new TeamMenager(randomName(),generator.nextInt(10) + 1, EEmployeeRole.CEO);
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
                        ,generator.nextInt(3) + 1,EEmployeeRole.Manager));
            else
                manager.hire(new Developer(randomName()
                        , randomRole()));
        }
        for (IEmployee m:
                manager.getSubordinates().parallelStream()
                        .filter(e -> e instanceof TeamMenager)
                        .collect(Collectors.toList())) {
            fillStructure((TeamMenager) m, d);
        }
    }

    private void printStructure(TeamMenager manager, String lvl) {
        //System.out.println(manager);
        for (IEmployee e :
                manager.getSubordinates()) {
            System.out.println(lvl + e);
            for (IEmployee e2 :
                    manager.getSubordinates()) {
                if (e2 instanceof TeamMenager)
                    printStructure((TeamMenager) e2, lvl + "+");
            }
        }
    }
    private EEmployeeRole randomRole(){
        EEmployeeRole[] roles = {EEmployeeRole.Contributor, EEmployeeRole.Developer
                , EEmployeeRole.TeamLeader, EEmployeeRole.Tester};
        Random generator = new Random();
        return roles[generator.nextInt(roles.length)];

    }


    private String randomNames() {
        Random generate = new Random();
        String[] name = {"John", "Marcus", "Susan", "Henry", "Jacob", "Thomas", "Angela", "Eliot", "Sammy", "Johanos"};

        return name[generate.nextInt(10)];
    }

    private String randomSurname() {
        Random generate = new Random();
        String[] name = {"Smith", "Merc", "Bean", "Beer", "Anderson" , "Janson", "Scala"};

        return name[generate.nextInt(7)];
    }

    private String randomName(){
        return randomNames() + randomSurname();
    }

}
