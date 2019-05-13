package com.olbati;

import com.olbati.beans.DrinkBean;
import com.olbati.beans.OrderBean;
import com.olbati.enums.Drinks;

public class DrinkMaker {
    DrinkBean drinkRequested;
    OrderBean order;
    boolean makeTheDrink = true;

    public DrinkMaker takeOrders(OrderBean order) {
        this.order = order;
        double difference = order.getMoney() - Drinks.getNameByCode(order.getDrinkOrdered()).getPrice();
        if (difference < 0) {
            makeTheDrink = false;
            order.setMessage("Not enough money is given, please add : " + Double.valueOf(-difference));
            order.setDrinkOrdered("M");
        }
        return this;
    }

    public DrinkMaker makeDrink() {
        drinkRequested = new DrinkBean();
        String drink = order.getDrinkOrdered();
        if ("M".equals(drink)) {
            drinkRequested.setDrink(drink);
            drinkRequested.setMessage(order.getMessage());
        } else if ("O".equals(drink)) {
            drinkRequested.setDrink(Drinks.getNameByCode(drink).toString());
        } else {
            drinkRequested.setDrink(Drinks.getNameByCode(drink).toString());
            drinkRequested.setSugar(order.getNumberOfSugar());
            if (order.getNumberOfSugar() > 0) drinkRequested.setStick(true);
        }
        drinkRequested.setServed(makeTheDrink);
        return this;
    }

    public DrinkBean getDrinkRequested() {
        return drinkRequested;
    }
}
