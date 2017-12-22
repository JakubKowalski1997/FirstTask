package com.jaksiemasz.report;

import com.jaksiemasz.company_struct.PrintEmployees;
import com.jaksiemasz.employee.TeamMenager;

public class TeamMeangerReport extends AbstractReport{
    private final TeamMenager teamManager;

    public TeamMeangerReport(TeamMenager teamManager) {
        this.teamManager = teamManager;
    }

    @Override
    public void show() {
        teamManager.getAllSubordinatesList()
                .stream()
                .sorted(ReportComparator.employeeLexicalSort())
                .forEach(PrintEmployees::printEmployee);
    }


}
