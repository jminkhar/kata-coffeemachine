package com.olbati;

import com.olbati.beans.OrderBean;

public class TranslateOrder {

    public static OrderBean translateOrder(String order, double money) {
        String[] instructions = order.split(":");
        OrderBean orderRequested = new OrderBean();
        orderRequested.setDrinkOrdered(instructions[0]);
        if ("M".equals(instructions[0])) {
            orderRequested.setMessage(instructions[1]);
        } else {
            if (instructions.length > 1)
                orderRequested.setNumberOfSugar(Integer.valueOf(instructions[1]));
            else orderRequested.setNumberOfSugar(0);
        }
        orderRequested.setMoney(money);
        return orderRequested;
    }
}
