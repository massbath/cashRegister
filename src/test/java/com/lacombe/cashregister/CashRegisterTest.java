package com.lacombe.cashregister;

import com.lacombe.cashregister.CashRegister;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CashRegisterTest {

    @Test
    public void totalShoulReturnThePriceByQuantity() {
        CashRegister cashRegister = new CashRegister();
        double price = 1.2;
        double quantity=1;
        double total = cashRegister.total(price, quantity);
        assertThat(total).isEqualTo(1.2);
    }
}
