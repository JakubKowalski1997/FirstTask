package com.jaksiemasz;

public abstract class AbstractEmployee implements IEmployee{
    private final String name;
    private final String role;

    public AbstractEmployee(String name, String role) {
        this.name = name;
        this.role = role;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getRole() {
        return role;
    }
}



