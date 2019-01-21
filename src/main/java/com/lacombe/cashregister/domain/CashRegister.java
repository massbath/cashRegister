package com.lacombe.cashregister.domain;

public class CashRegister {

    public Price total(Price price, double quantity) {
        return new Price(price.value *quantity);
    }
}
