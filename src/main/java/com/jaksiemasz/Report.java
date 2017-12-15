package com.jaksiemasz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Report {

    private List<Task> tasksDone = new ArrayList<>();
    private HashMap<Task, String> taskComments = new HashMap<>();

    public void addFinishedTask(Task task) {
        tasksDone.add(task);
    }

    public void addFinishedTask(Task task, String comment) {
        tasksDone.add(task);
        taskComments.put(task, comment);
    }

    public Report merge(Report other) {
        Report merged = new Report();
        merged.tasksDone.addAll(tasksDone);
        merged.tasksDone.addAll(other.tasksDone);
        merged.taskComments.putAll(taskComments);
        merged.taskComments.putAll(other.taskComments);
        return merged;
    }
}
