package com.jaksiemasz;

import java.io.IOException;
import java.util.Random;

public class RandomPerson {

    public Person createPerson() throws IOException {
        Person person =  new Person(randomName(), randomSurname(), pseudoRandomMail());
        return person;
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

    private String pseudoRandomMail() {
        return randomName() + randomSurname().length() + "@" + randomSurname();
    }

}
