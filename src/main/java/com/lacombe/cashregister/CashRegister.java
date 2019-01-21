package com.lacombe.cashregister;

class CashRegister {
    Price total(Price price, double quantity) {
        return price.byQuantity(quantity);
    }
}
