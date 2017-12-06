package com.jaksiemasz;

import java.util.Random;

public class DeveloperFactory {
    public Developer createDeveloper(String role){
        Developer developer = new Developer(randomNameAndSurname(), role);
        return developer;
    }

    private String randomName() {
        Random generate = new Random();
        String[] name = {"John", "Marcus", "Susan", "Henry", "Jacob", "Thomas", "Angela", "Eliot", "Sammy", "Johanos"};

        return name[generate.nextInt(10)];
    }

    private String randomSurname() {
        Random generate = new Random();
        String[] name = {"Smith", "Merc", "Bean", "Beer", "Anderson" , "Janson", "Scala"};

        return name[generate.nextInt(7)];
    }

    private String randomNameAndSurname(){
       return randomName() + randomSurname();
    }
}
