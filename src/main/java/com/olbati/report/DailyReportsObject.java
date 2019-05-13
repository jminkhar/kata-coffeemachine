package com.olbati.report;

import com.olbati.enums.Drinks;

public class DailyReportsObject {
    private long teaCount;
    private long coffeeCount;
    private long chocolateCount;
    private long orangeCount;
    private long hotTeaCount;
    private long hotCoffeeCount;
    private long hotChocolateCount;
    private double moneyEarned;

    public double getMoneyEarned() {
        return moneyEarned;
    }

    public void setMoneyEarned(double moneyEarned) {
        this.moneyEarned = moneyEarned;
    }

    public long getTeaCount() {
        return teaCount;
    }

    public void setTeaCount(long teaCount) {
        this.teaCount = teaCount;
    }

    public void addTea() {
        this.teaCount++;
        this.moneyEarned+= Drinks.TEA.getPrice();
    }

    public long getCoffeeCount() {
        return coffeeCount;
    }

    public void setCoffeeCount(long coffeeCount) {
        this.coffeeCount = coffeeCount;
    }

    public void addCoffee() {
        this.coffeeCount++;
        this.moneyEarned+= Drinks.COFFEE.getPrice();
    }

    public long getChocolateCount() {
        return chocolateCount;
    }

    public void setChocolateCount(long chocolateCount) {
        this.chocolateCount = chocolateCount;
    }

    public void addChocolate() {
        this.chocolateCount++;
        this.moneyEarned+= Drinks.CHOCOLATE.getPrice();
    }

    public long getOrangeCount() {
        return orangeCount;
    }

    public void setOrangeCount(long orangeCount) {
        this.orangeCount = orangeCount;
    }

    public void addOrange() {
        this.orangeCount++;
        this.moneyEarned+= Drinks.ORANGE.getPrice();
    }

    public long getHotTeaCount() {
        return hotTeaCount;
    }

    public void setHotTeaCount(long hotTeaCount) {
        this.hotTeaCount = hotTeaCount;
    }

    public void addHotTea() {
        this.hotTeaCount++;
        this.moneyEarned+= Drinks.EXTRA_HOT_TEA.getPrice();
    }

    public long getHotCoffeeCount() {
        return hotCoffeeCount;
    }

    public void setHotCoffeeCount(long hotCoffeeCount) {
        this.hotCoffeeCount = hotCoffeeCount;
    }

    public void addHotCoffee() {
        this.hotCoffeeCount++;
        this.moneyEarned+= Drinks.EXTRA_HOT_COFFEE.getPrice();
    }

    public long getHotChocolateCount() {
        return hotChocolateCount;
    }

    public void setHotChocolateCount(long hotChocolateCount) {
        this.hotChocolateCount = hotChocolateCount;
    }

    public void addHotChocolate() {
        this.hotChocolateCount++;
        this.moneyEarned+= Drinks.EXTRA_HOT_CHOCOLATE.getPrice();
    }

    @Override
    public String toString() {
        return "----------------------\n" +
               "| Daily Reports       |\n " +"----------------------\n" +
                "Tea sold=" + teaCount +
                ", Coffee sold=" + coffeeCount +
                ", Chocolate sold=" + chocolateCount +
                ", Orange sold=" + orangeCount +
                ", Hot Tea sold=" + hotTeaCount +
                ", Hot Coffee sold=" + hotCoffeeCount +
                ", Hot Chocolate sold=" + hotChocolateCount +
                ", Total=" + moneyEarned ;
    }
//    @Override
//    public String toString() {
//        return "Daily Reports {" +
//                "Tea sold=" + teaCount +
//                ", Coffee sold=" + coffeeCount +
//                ", Chocolate sold=" + chocolateCount +
//                ", Orange sold=" + orangeCount +
//                ", Hot Tea sold=" + hotTeaCount +
//                ", Hot Coffee sold=" + hotCoffeeCount +
//                ", Hot Chocolate sold=" + hotChocolateCount +
//                ", Total=" + moneyEarned +
//                '}';
//    }
}
