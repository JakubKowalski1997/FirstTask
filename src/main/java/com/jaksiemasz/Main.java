package com.jaksiemasz;

import com.google.common.collect.ComparisonChain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Email is SUPER random \n");

        RandomPersonFactory randomPerson = new RandomPersonFactory();

        randomPerson.ListOfRandomPeople(20);

        System.out.println("Let's crash it!!!");

        Person personCrash = new Person("Jakub1", "Kowalski", "cotamaniewiem");
        personCrash.show();
    }

}

