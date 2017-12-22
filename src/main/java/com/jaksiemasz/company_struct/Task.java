package com.jaksiemasz.company_struct;

import java.util.Date;

public class Task {

    private final String specs;
    private final String comments;
    private final boolean hasDeadLine;
    private Date deadLine;
    private int unitsOfWork;

    public Task(String specs, String comments) {
        hasDeadLine = false;
        this.specs = specs;
        this.comments = comments;
    }

    public Task(String specs, String comments, Date deadLine) {
        hasDeadLine = true;
        this.specs = specs;
        this.comments = comments;
        this.deadLine = deadLine;
    }

    public Task(String specs, String comments, Date deadLine, int unitsOfWork) {
        this.hasDeadLine = true;
        this.specs = specs;
        this.comments = comments;
        this.deadLine = deadLine;
        this.unitsOfWork = unitsOfWork;
    }

    @Override
    public String toString() {
        return hasDeadLine ? specs + "\n" + comments
                : specs + "\n" + comments + "\n" + deadLine;
    }

    public int getUnitsOfWork() {
        return unitsOfWork;
    }
}
