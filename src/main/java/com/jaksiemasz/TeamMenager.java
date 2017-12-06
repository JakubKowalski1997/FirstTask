package com.jaksiemasz;

import java.util.ArrayList;
import java.util.List;

public class TeamMenager extends AbstractEmployee implements IMenager{

    private final int size;

    private final List<AbstractEmployee> listEmployee;

    public TeamMenager(String name, int size) {
        super(name, "Team menager");
        this.size = size;
        listEmployee = new ArrayList<>(this.size);
    }

    public TeamMenager(String name, String role, int size) {
        super(name, role);
        this.size = size;
        listEmployee = new ArrayList<>(this.size);
    }

    @Override
    public void hire(AbstractEmployee employee) {
        listEmployee.add(employee);
    }

    @Override
    public void fire(AbstractEmployee employee) {
        listEmployee.remove(employee);
    }

    @Override
    public boolean canHire() {
        if(listEmployee.size() <= size ){
         return true;
        }
        else return false;
    }


    @Override
    public void assign(Task task) {
        listEmployee.get(task.getNumberEmployee()).assign(task); // Zatrudnieni są oznaczani przez numerki trzeba by do nich po imieniu zaczac mowic XD
        System.out.println(task.toString());
    }


    @Override
    public Report reportWork() {
        for(int i = 0; i < listEmployee.size(); i++){
            return listEmployee.get(i).reportWork();
        }
        return null;
    }

    public List<AbstractEmployee> getListEmployee() {
        return listEmployee;
    }

    @Override
    public String toString() {
        return getName() + " - "  + getRole() + " | ";
    }
}
