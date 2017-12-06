package com.jaksiemasz;

public interface IMenager extends IEmployee{
    void hire(AbstractEmployee employee);
    void fire(AbstractEmployee employee);
    boolean canHire();
}
