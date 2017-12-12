package com.jaksiemasz;

public interface IMenager extends IEmployee{
    void hire(AbstractEmployee employee);
    void hire(TeamMenager menager);
    void fire(AbstractEmployee employee);
    void fire(TeamMenager menager);
    boolean canHire();
}
