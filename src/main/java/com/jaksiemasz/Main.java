package com.jaksiemasz;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Company comp1 = new CompanyFactory().getRandomCompany(4,"JakSieMasz.Care");
        comp1.getCeoDirector().toString();




    }

}

