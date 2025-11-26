package com.mycompany.app.implementInterface;

import com.mycompany.app.interfaceTransaction.InterfaceTransaction;

public class ViewTransactionImplement implements InterfaceTransaction {

    private String time;
    private String type;
    private double money;

    public ViewTransactionImplement(String time, String type, double money) {
        this.time = time;
        this.type = type;
        this.money = money;
    }

    @Override
    public String getTime() {
        return time;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public double getMoney() {
        return money;
    }

    @Override
    public String toString() {
        return time + " | " + type + " | " + money;
    }
}
