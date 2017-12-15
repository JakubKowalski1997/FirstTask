package com.jaksiemasz;

import java.util.Date;

public class Task {

    private String specs;
    private String comments;
    boolean hasDeadLine;
    private Date deadLine;

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

    @Override
    public String toString() {
        return hasDeadLine ? specs + "\n" + comments
                : specs + "\n" + comments + "\n" + deadLine;
    }

}
