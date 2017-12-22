package com.jaksiemasz.report;

import com.jaksiemasz.company_struct.Task;
import com.jaksiemasz.employee.IEmployee;

import java.util.Comparator;

class ReportComparator {
    public static Comparator<IEmployee> employeeLexicalSort() {
        return Comparator
                .comparing(IEmployee::getName)
                .thenComparing(Comparator.comparing(emp -> emp.getRole().name()))
                .thenComparing(IEmployee::getUnitOfWork);
    }

    public static Comparator<Task> taskWeightSort() {
        return Comparator
                .comparing(Task::getUnitsOfWork)
                .thenComparing(Task::toString);
    }

    public static Comparator<Task> taskNameSort() {
        return Comparator
                .comparing(Task::toString)
                .thenComparing(Task::getUnitsOfWork);
    }
}
