package com.jaksiemasz.report;

import com.jaksiemasz.employee.Developer;

public class DeveloperReport extends AbstractReport{
    private final Developer developer;


    public DeveloperReport(Developer developer) {
        this.developer = developer;
    }


    @Override
    public void show() {
        developer.getTaskList()
                .stream()
                .sorted(ReportComparator.taskWeightSort())
                .forEach((task) -> System.out.println("  " + task));
    }
}
