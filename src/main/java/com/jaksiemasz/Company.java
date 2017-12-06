package com.jaksiemasz;

public class Company {
    private final int sizeOfCompany;

    public Company(int sizeOfCompany) {
        this.sizeOfCompany = sizeOfCompany;
    }

    public void createCompany() {
        TeamMenager teamMenagerMain = new TeamMenager("Grzegorz Szeremeta", "CEO", 2);
        System.out.println(teamMenagerMain.getName() + " - "  + teamMenagerMain.getRole());
        DeveloperFactory newDev = new DeveloperFactory();
        TeamMenagerFactory newTeamMenager = new TeamMenagerFactory();

        if (sizeOfCompany == 2) {
            teamMenagerMain.hire(newDev.createDeveloper("Team leader"));
            teamMenagerMain.hire(newDev.createDeveloper("Developer"));
            System.out.println(teamMenagerMain.getListEmployee().get(0).toString() + teamMenagerMain.getListEmployee().get(1).toString());
        }else
        {
            int i = 0;

            teamMenagerMain.hire(newTeamMenager.createTeamMenager());
            teamMenagerMain.hire(newTeamMenager.createTeamMenager());
            while(i != sizeOfCompany){
                System.out.println();
                if(teamMenagerMain.canHire()){
                    teamMenagerMain.hire(newTeamMenager.createTeamMenager());
                }else

                    {
                    if(newTeamMenager.createTeamMenager().canHire()){
                    newTeamMenager.createTeamMenager().hire(newTeamMenager.createTeamMenager());
                    }}
                System.out.println();

                i++;
            }
        }
    }
}
