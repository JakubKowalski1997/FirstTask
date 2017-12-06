package com.jaksiemasz;

public class Developer extends AbstractEmployee implements IEmployee{

    public Developer(String name, String role) {
        super(name,role);
    }

    @Override
    public void assign(Task task) {

    }

    @Override
    public Report reportWork() {
        return null;
    }

    @Override
    public String toString() {
        return getName() + " - "  + getRole() + " | ";
    }
}
