package com.lacombe.cashregister.domain;

import com.lacombe.cashregister.Quantity;

public class CashRegister {

    public Price total(Price price, Quantity quantity) {
        return price.multiplyBy(quantity);
    }
}
