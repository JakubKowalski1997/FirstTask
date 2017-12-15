package com.jaksiemasz;

public interface IEmployee {
    String getName();
    EEmployeeRole getRole();

    void assign(Task task);
    Report reportWork();
}
