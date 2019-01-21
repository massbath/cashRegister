package com.lacombe.cashregister.domain;

import com.lacombe.cashregister.Quantity;

import java.util.Objects;

public  class Price {
   private final double value;

    private Price(double value) {
        this.value = value;
    }
    public static Price valueOf(double value){
        return new Price(value);
    }


    public Price multiplyBy(Quantity quantity) {
        return new Price(quantity.multipliedBy(value));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return Double.compare(price.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Price{" +
                "value=" + value +
                '}';
    }
}
