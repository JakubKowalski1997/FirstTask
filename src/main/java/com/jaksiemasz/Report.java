package com.jaksiemasz;

import java.util.Random;

public class Report {
    private final int unitWorked;

    public Report(int unitWorked) {
        this.unitWorked = unitWorked;
    }

    public Report reportWork(){
        Report report = new Report(randomUnitWorking());
        return report;
    }

    private int randomUnitWorking() {
        Random generate = new Random();
        return generate.nextInt(2);
    }


    @Override
    public String toString() {
        return "I have done " + unitWorked + " unit of work";
    }
}
