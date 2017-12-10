package com.jaksiemasz;

import java.util.Objects;
import java.util.Random;

public class CompanyFactory {
    private Company company;
    private final Random generator = new Random();

    public Company getRandomCompany(int randomLevel, String companyName) {
        company = new Company(companyName);

        hireRandom(company.getCeoDirector(), randomLevel);

        return company;
    }

    private void hireRandom(TeamMenager manager, int maxLevel) {
        AbstractEmployee randomEmployee;
        if (maxLevel == 0) {
            return; //recursion end
        } else {
            for (int i = 0; i < generator.nextInt(20); i++) {
                randomEmployee = getRandomEmployee();
                manager.hire(randomEmployee);
                if (Objects.equals(randomEmployee.getRole(), "Team menager")) {
                    hireRandom((TeamMenager) randomEmployee, maxLevel - 1);
                }
            }
        }
    }

    private AbstractEmployee getRandomEmployee() {

        DeveloperFactory newDev = new DeveloperFactory();
        TeamMenagerFactory newMenager = new TeamMenagerFactory();
        int randomLimit = 6 + generator.nextInt(10);

        switch (generator.nextInt(5)) {
            case 0:
                return newMenager.createTeamMenager();
            case 1:
                return newMenager.createTeamMenager();
            case 2:
                return newDev.createDeveloper("Tester");
            case 3:
                return newDev.createDeveloper("Developer");
            case 4:
                return newDev.createDeveloper("Leader");
            case 5:
                return newDev.createDeveloper("Contributor");
            default:
                return null;
        }
    }


}
