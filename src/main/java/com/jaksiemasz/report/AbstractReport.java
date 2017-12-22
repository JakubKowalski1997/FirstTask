package com.jaksiemasz.report;

public abstract class AbstractReport implements IReport{

    private String description = "There is no description included";

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void showDescription() {
        System.out.println(description);
    }
}
