package com.jaksiemasz.employee;

import java.util.List;

public interface IMenager extends IEmployee {

    void hire(IEmployee e);

    void fire(IEmployee e);

    boolean canHire();

    List<IEmployee> getEmployeeList();

    List<IEmployee> getAllSubordinatesList();
}
