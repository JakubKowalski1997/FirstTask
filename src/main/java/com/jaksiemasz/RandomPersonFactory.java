package com.jaksiemasz;

import com.google.common.collect.ComparisonChain;

import java.io.IOException;
import java.util.*;

public class RandomPersonFactory {

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


    public void ListOfRandomPeople(int numberOfPeople) throws IOException {
        RandomPersonFactory randomPerson = new RandomPersonFactory();

        List<Person> personList = new ArrayList<>();

        for (int i = 0; i < numberOfPeople; i++) {
            personList.add(randomPerson.createPerson());
        }

        personList.sort(new LexicographicComparator());

        for (int i = 0; i < personList.size(); i++) {
            personList.get(i).show();
        }
    }
}

class LexicographicComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return ComparisonChain.start()
                .compare(p1.getName(), p2.getName())
                .compare(p1.getSurname(), p2.getSurname())
                .compare(p1.getMail(), p2.getMail())
                .result();
    }
}