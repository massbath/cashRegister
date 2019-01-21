package com.lacombe.cashregister;

import java.util.Objects;

public final class Price {
    final double value;

    Price(double value) {
        this.value = value;
    }

    Price byQuantity(double quantity) {
        return new Price(value*quantity);
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
}
