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

        RandomPerson randomPerson = new RandomPerson();

        List<Person> personList = new ArrayList<Person>();

        for (int i = 0; i < 50; i++) {
            personList.add(randomPerson.createPerson());
        }

        Collections.sort(personList, new LexicographicComparator());


        for (int i = 0; i < personList.size(); i++) {
            personList.get(i).show();
        }

        System.out.println("Let's check if list is making correct \n" + personList.get(0).toString()); // checking if list is saving propely or everything is just random xD

        System.out.println("Let's crash it!!!");

        Person personCrash = new Person("Jakub1", "Kowalski", "cotamaniewiem");
        personCrash.show();
    }

}

class LexicographicComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        int sizeCmp = p1.getName().compareTo(p2.getName());
        if (sizeCmp != 0) {
            return sizeCmp;
        }
        int nrOfToppingsCmp = p1.getSurname().compareTo(p2.getSurname());
        if (nrOfToppingsCmp != 0) {
            return nrOfToppingsCmp;
        }
        return p1.getMail().compareTo(p2.getMail());
    }
}
