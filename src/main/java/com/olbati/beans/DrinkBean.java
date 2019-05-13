package com.olbati.beans;

import com.olbati.enums.Drinks;

public class DrinkBean {
    String drink;
    int sugar;
    boolean stick;
    String message;
    boolean served;

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public int getSugar() {
        return sugar;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public boolean isStick() {
        return stick;
    }

    public void setStick(boolean stick) {
        this.stick = stick;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isServed() {
        return served;
    }

    public void setServed(boolean served) {
        this.served = served;
    }

    public String toString() {
        if (!"M".equals(drink)) {
            return String.format(Drinks.valueOf(drink).getMessage(), sugar, stick ? "a" : "no");
        } else return message;
    }
}
