package com.jaksiemasz.company_struct;

import com.jaksiemasz.employee.Developer;
import com.jaksiemasz.employee.EEmployeeRole;
import com.jaksiemasz.employee.IEmployee;
import com.jaksiemasz.employee.TeamMenager;

public class PrintEmployees {

    public static void printEmployee(IEmployee employee) {
        if (employee.getRole() == EEmployeeRole.Manager || employee.getRole() == EEmployeeRole.CEO) {
            printTeamManager((TeamMenager) employee);
        } else
            printDeveloper((Developer) employee);
        }

    private static void printTeamManager(TeamMenager teamManager) {
        String employeesToString = "\n  ";
        for (IEmployee employee : teamManager.getEmployeeList()) {
            employeesToString += employee.getRole() + " " + employee.getName() + "\n  ";
        }
        System.out.println(teamManager.toString() + employeesToString);
    }

    private static void printDeveloper(Developer developer) {
        System.out.println(developer.toString());
        developer.reportWork().show();
    }
}
