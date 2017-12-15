package com.jaksiemasz;

import java.util.ArrayList;
import java.util.List;

public class Developer extends AbstractEmployee {

    final private String name;
    final private EEmployeeRole role;
    private List<Task> tasks = new ArrayList<>();
    private Report workDone = new Report();

    public Developer(String name){
        super(name, EEmployeeRole.Developer);
        this.name = name;
        this.role = EEmployeeRole.Developer;
    }

    public Developer(String name, EEmployeeRole role){
        super(name, role);
        this.name = name;
        this.role = EEmployeeRole.Developer;
    }

    @Override
    public void assign(Task task) {
        tasks.add(task);
    }

    @Override
    public Report reportWork() {
        return workDone;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public EEmployeeRole getRole() {
        return role;
    }

    @Override
    public String toString() {
        return (name + ": " + role);
    }
}
