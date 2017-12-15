package com.jaksiemasz;

public abstract class AbstractEmployee implements IEmployee{
    private final String name;
    private final EEmployeeRole role;

    public AbstractEmployee(String name, EEmployeeRole role) {
        this.name = name;
        this.role = role;
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
        return (name + role);
    }
}



