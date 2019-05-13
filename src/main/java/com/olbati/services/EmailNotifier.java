package com.olbati.services;

import com.olbati.beans.OrderBean;

public interface EmailNotifier {
    void notifyMissingDrink(OrderBean drink);
}
