package com.olbati.enums;

public enum Drinks {
    TEA("T", 0.4,"Drink maker makes 1 tea with %d sugar and %s stick"),
    COFFEE("C", 0.6,"Drink maker makes 1 coffee with %d sugar and %s stick"),
    CHOCOLATE("H", 0.5,"Drink maker makes 1 chocolate with %d sugar and %s stick"),
    EXTRA_HOT_TEA("Th", 0.4,"Drink maker makes 1 extra hot tea with %d sugar and %s stick"),
    EXTRA_HOT_COFFEE("Ch", 0.6,"Drink maker makes 1 extra hot coffee with %d sugar and %s stick"),
    EXTRA_HOT_CHOCOLATE("Hh", 0.5,"Drink maker makes 1 extra hot chocolate with %d sugar and %s stick"),
    ORANGE("O",0.6, "Drink maker makes one orange juice"),
    NULL(null, 0,"");

    private String status;
    private double price;
    private String message;

    public String getStatus() {
        return status;
    }

    public double getPrice() {
        return price;
    }

    public String getMessage() {
        return message;
    }

    Drinks(String status, double price, String message) {
        this.status = status;
        this.price = price;
        this.message = message;
    }


    public static Drinks getNameByCode(String code) {
        for (Drinks e : Drinks.values()) {
            if (code.equals(e.status)) return e;
        }
        return NULL;
    }
}
