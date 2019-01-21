package com.lacombe.cashregister;

import com.lacombe.cashregister.CashRegister;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CashRegisterTest {

    @Test
    public void totalShouldReturnThePriceByQuantity() {
        CashRegister cashRegister = new CashRegister();
        Price price = new Price(1.2);
        double quantity=1;
        Price total = cashRegister.total(price, quantity);
        Price totalExpected = new Price(1.2);
        assertThat(total).isEqualTo(totalExpected);
    }
}
