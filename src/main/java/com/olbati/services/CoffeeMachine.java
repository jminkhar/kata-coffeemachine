package com.olbati.services;

import com.olbati.beans.OrderBean;

public class CoffeeMachine implements BeverageQuantityChecker,EmailNotifier {
    @Override
    public boolean isEmpty(OrderBean drink) {
        return false;
    }

    @Override
    public void notifyMissingDrink(OrderBean drink) {

    }
}
