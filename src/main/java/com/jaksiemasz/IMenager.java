package com.jaksiemasz;

public interface IMenager extends IEmployee{

    void hire(IEmployee e);
    void fire(IEmployee e);
    boolean canHire();
}
