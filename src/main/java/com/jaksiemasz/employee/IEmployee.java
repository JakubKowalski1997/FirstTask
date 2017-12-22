package com.jaksiemasz.employee;

import com.jaksiemasz.company_struct.Task;
import com.jaksiemasz.report.IReport;

public interface IEmployee {

    String getName();

    EEmployeeRole getRole();

    String getUniversity();

    Sex getSex();

    String getOriginCountry();

    String getEmail();

    int getUnitOfWork();

    void assign(Task task);

    IReport reportWork();
}
