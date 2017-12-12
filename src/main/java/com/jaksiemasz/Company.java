package com.jaksiemasz;



public class Company {

    TeamMenager CEO = new TeamMenager("Grzegorz Szeremeta", "CEO", 2);

    private final String name;

    public Company(String companyName) {
        name = companyName;
    }

    public TeamMenager getCeoDirector() {
        return CEO;
    }

    public void setCeoDirector(TeamMenager newCeoDirector) {
        CEO = newCeoDirector;
    }



}
