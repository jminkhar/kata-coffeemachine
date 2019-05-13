package com.olbati.beans;

public class OrderBean {
    String drinkOrdered;
    int numberOfSugar;
    String message;
    double money;

    public void setDrinkOrdered(String drinkOrdered) {
        this.drinkOrdered = drinkOrdered;
    }

    public void setNumberOfSugar(int numberOfSugar) {
        this.numberOfSugar = numberOfSugar;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDrinkOrdered() {
        return drinkOrdered;
    }

    public int getNumberOfSugar() {
        return numberOfSugar;
    }

    public String getMessage() {
        return message;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
