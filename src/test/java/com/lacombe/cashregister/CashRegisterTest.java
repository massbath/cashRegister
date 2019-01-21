package com.lacombe.cashregister;

import com.lacombe.cashregister.domain.CashRegister;
import com.lacombe.cashregister.domain.Price;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CashRegisterTest {

    @Test
    public void totalShouldReturnThePriceByQuantity() {
        CashRegister cashRegister = new CashRegister();
        Price price =  Price.valueOf(1.2);
        double quantity=1;
        Price total = cashRegister.total(price, quantity);
        assertThat(total).isEqualTo(Price.valueOf(1.2));
    }
}
