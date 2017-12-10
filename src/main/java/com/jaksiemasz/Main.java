package com.jaksiemasz;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
       /*TeamMenager Grzesiek = new TeamMenager("Grzesiek",  10);
       Grzesiek.hire(new Developer("Jakub Kowalski","Team leader"));
        Grzesiek.hire(new Developer("Jakub Brzęczyszczykiewicz","Developer"));
        Grzesiek.hire(new Developer("Jakub","Ko"));
       Grzesiek.assign(new Task("123", 10,0));
       Grzesiek.assign(new Task("bug", 4,1));
       //System.out.println(Grzesiek.printListEmployee()); // nie działa jak chce :(
       System.out.println(Grzesiek.getListEmployee().get(0).getRole());
       System.out.println(Grzesiek.getListEmployee().get(1).getRole());
       System.out.println(Grzesiek.getListEmployee().get(2).getRole());
        System.out.println(Grzesiek.getListEmployee().get(0).reportWork());*/
        CompanyFactory newComp = new CompanyFactory();
        newComp.getRandomCompany(4,"JakSieMaszCare");


    }

}

