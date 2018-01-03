package com.jaksiemasz.employee;

import com.google.common.collect.ImmutableList;
import com.jaksiemasz.report.IReport;
import com.jaksiemasz.company_struct.Task;
import com.jaksiemasz.report.TeamMeangerReport;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static com.google.common.base.Preconditions.checkArgument;


public class TeamMenager extends AbstractEmployee implements IMenager {

    private String name;
    private EEmployeeRole role;
    private final int employeeLimit;

    private final List<IEmployee> subordinates = new ArrayList<>();
    private final List<Task> tasks = new ArrayList<>();
    private final Predicate<IEmployee> hireConditionFunction;
    private final TeamMeangerReport report = new TeamMeangerReport(this);


    public TeamMenager(String name, int employeeLimit, EEmployeeRole role, String email, String originCountry, Sex sex, String university,Predicate<IEmployee> hireConditionFunction) {
        super(name, role,email,originCountry,sex,university);
        this.name = name;
        this.employeeLimit = employeeLimit;
        this.role = role;
        this.hireConditionFunction = hireConditionFunction;
    }

    private TeamMenager(TeamManagerBuilder builder) {
        super(builder);
        name = builder.name;
        role = builder.role;
        this.employeeLimit = builder.limitOfEmployees;
        this.hireConditionFunction = builder.hireConditionFunction;
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

    @Override
    public IReport reportWork(){
       return report;
    }

    public boolean canHire(){
        return (subordinates.size() < employeeLimit);
    }

    @Override
    public List<IEmployee> getEmployeeList() {
        ArrayList<IEmployee> listOfAllSubordinates = new ArrayList<>(subordinates);
        for (IEmployee employee : subordinates) {
            if (employee.getRole() == EEmployeeRole.Manager) {
                listOfAllSubordinates.addAll(((TeamMenager) employee).getAllSubordinatesList());
            }
        }
        return ImmutableList.copyOf(listOfAllSubordinates);
    }

    @Override
    public List<IEmployee> getAllSubordinatesList() {
        return ImmutableList.copyOf(subordinates);
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
    public int getUnitOfWork() {
        return subordinates.size();
    }

    @Override
    public String toString(){
        return (name + ": " + role);
    }

    public static class TeamManagerBuilder extends AbstractEmployee.EmployeeBuilder<TeamManagerBuilder> {

        private int limitOfEmployees;
        private Predicate<IEmployee> hireConditionFunction;
        private String name;
        private EEmployeeRole role;


        public TeamManagerBuilder name(String val){
            name = val;
            return this;
        }

        public TeamManagerBuilder role(EEmployeeRole val){
            role = val;
            return this;
        }

        public TeamManagerBuilder setLimitOfEmployees(int limitOfEmployees) {
            this.limitOfEmployees = limitOfEmployees;
            return this;
        }

        public TeamManagerBuilder setHireConditionFunction(Predicate<IEmployee> hireConditionFunction) {
            this.hireConditionFunction = hireConditionFunction;
            return this;
        }

        public TeamMenager build() {
            return new TeamMenager(this);
        }

    }

}
