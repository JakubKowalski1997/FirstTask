package com.jaksiemasz;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;


public class TeamMenager extends AbstractEmployee implements IMenager{

    final private String name;
    final private EEmployeeRole role;
    private int employeeLimit;

    private List<IEmployee> subordinates = new ArrayList<>();
    private List<Task> tasks = new ArrayList<>();
    private Report workComplited = new Report();


    public TeamMenager(String name, int employeeLimit, EEmployeeRole role) {
        super(name, role);
        this.name = name;
        this.employeeLimit = employeeLimit;
        this.role = role;
    }

    public void hire (IEmployee e) {
        checkArgument(canHire()
                ,"Manager %s is not able to hire more employees", name);
        checkArgument(!subordinates.contains(e)
                ,"Manager %s is not able to hire the same employee (%s) twice", name, e);
        subordinates.add(e);
    }

    public void fire (IEmployee e) {
        checkArgument(subordinates.contains(e), "Employee %s is not a subordinate", e);
        subordinates.remove(e);
    }

    public void assign(Task task){
        tasks.add(task);
    }

    public void assign(Task task, IEmployee e){
        checkArgument(subordinates.contains(e)
                ,"Can't assign task %s to employee %s (employee is not a subordinate of %s)"
                ,task, e, this);
        e.assign(task);
    }

    public Report reportWork(){
        Report subordinatesWork = new Report();
        for (IEmployee e:
                subordinates) {
            subordinatesWork = subordinatesWork.merge(e.reportWork());
        }
        return subordinatesWork;
    }

    public boolean canHire(){
        return (subordinates.size() < employeeLimit);
    }

    public List<IEmployee> getSubordinates() {
        return subordinates;
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
    public String toString(){
        return (name + ": " + role);
    }
}
