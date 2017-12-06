package com.jaksiemasz;

public interface IEmployee {
    String getName();
    String getRole();
    void assign(Task task);
    Report reportWork();
}
