package com.jaksiemasz;

public class Task {
    private final String stringTask;
    private final int unitOfWorkToMakeTask;
    private final int numberEmployee;

    public Task(String stringTask, int unitOfWorkToMakeTask,int numberEmployee) {
        this.stringTask = stringTask;
        this.unitOfWorkToMakeTask = unitOfWorkToMakeTask;
        this.numberEmployee = numberEmployee;
    }


    public int getNumberEmployee() {
        return numberEmployee;
    }

    @Override
    public String toString() {
        return "Implementing a: " + stringTask + " it will take " + unitOfWorkToMakeTask + " unit of work.";
    }
}
