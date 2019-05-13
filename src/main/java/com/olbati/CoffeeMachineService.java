package com.olbati;

import com.olbati.beans.DrinkBean;
import com.olbati.beans.OrderBean;
import com.olbati.report.DailyReports;
import com.olbati.services.CoffeeMachine;

public class CoffeeMachineService {
    private DrinkBean drinkRequested;
    private DailyReports dailyReports = new DailyReports();

    private CoffeeMachine coffeeMachineCore = new CoffeeMachine();

    public void command(String order, double money) {
        OrderBean orderedDrink = TranslateOrder.translateOrder(order, money);
        if (coffeeMachineCore.isEmpty(orderedDrink)) {
            coffeeMachineCore.notifyMissingDrink(orderedDrink);
        } else {
            DrinkMaker drinkMaker = new DrinkMaker().takeOrders(orderedDrink).makeDrink();
            drinkRequested = drinkMaker.getDrinkRequested();
            if (drinkRequested.isServed()) dailyReports.record(drinkRequested);
        }
    }

    public DrinkBean getDrinkRequested() {
        return drinkRequested;
    }
}
