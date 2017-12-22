package com.jaksiemasz.employee;

import com.google.common.collect.ImmutableList;
import com.jaksiemasz.company_struct.Task;
import com.jaksiemasz.report.DeveloperReport;
import com.jaksiemasz.report.IReport;

import java.util.ArrayList;
import java.util.List;

public class Developer extends AbstractEmployee {

    private String name;
    private EEmployeeRole role;
    private final List<Task> tasks = new ArrayList<>();
    private final DeveloperReport report = new DeveloperReport(this);

    private final int freeResources;

    public Developer(String name, EEmployeeRole role, String email, String originCountry, Sex sex, String university, int freeResources){
        super(name, role,email,originCountry,sex,university);
        this.name = name;
        this.role = EEmployeeRole.Developer;
        this.freeResources = freeResources;
    }

    private Developer(DeveloperBuilder builder) {
        super(builder);
        this.freeResources = builder.freeResources;
        name  = builder.name;
        role = builder.role;
    }

    @Override
    public void assign(Task task) {
        tasks.add(task);
    }

    @Override
    public IReport reportWork() {
        return report;
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
        int unitOfWork = 0;
        for (Task task : tasks){
            unitOfWork += task.getUnitsOfWork();
        }
        return unitOfWork;
    }

    public List<Task> getTaskList() {
        return ImmutableList.copyOf(tasks);
    }

    @Override
    public String toString() {
        return (name + ": " + role);
    }


    public static class DeveloperBuilder extends AbstractEmployee.EmployeeBuilder<DeveloperBuilder>{
        private int freeResources;
        private String name;
        private EEmployeeRole role;

        public DeveloperBuilder setFreeResources(int freeResources){
            this.freeResources = freeResources;
            return this;
        }

        public DeveloperBuilder name(String val){
            name = val;
            return this;
        }

        @Override
        public DeveloperBuilder setCountry(String country) {
            return super.setCountry(country);
        }

        @Override
        public DeveloperBuilder setUniversity(String university) {
            return super.setUniversity(university);
        }

        @Override
        public DeveloperBuilder setEmail(String email) {
            return super.setEmail(email);
        }

        @Override
        public DeveloperBuilder setSex(Sex sex) {
            return super.setSex(sex);
        }

        public DeveloperBuilder role(EEmployeeRole val){
            role = val;
            return this;
        }

        public Developer build(){
            return new Developer(this);
        }
    }

}
