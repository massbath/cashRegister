package com.lacombe.cashregister;

import com.lacombe.cashregister.domain.*;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.lacombe.cashregister.domain.Reference.ReferenceBuilder.aReference;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class CashRegisterTest {

    private ItemReferenceRepository repository;
    private CashRegister cashRegister;

    @Before
    public void setUp() throws Exception {
        cashRegister = new CashRegister();
        repository = new ItemReferenceRepository(aReference().withItemCode("APPLE").withUnitPrice(1.2).build(), aReference().withItemCode("BANANA").withUnitPrice(1.9).build());
    }


    @Parameters({"APPLE, 1,1.20", "APPLE, 2,1.20", "BANANA,10,1.90"})
    @Test
    public void totalIsProductOfQuantityByItemPrice(String itemCode, double quantity, double unitPrice) {
        Result total = cashRegister.total(repository.findPrice(itemCode), Quantity.valueOf(quantity));
        assertThat(total).isEqualTo(Result.found(Price.valueOf(quantity * unitPrice)));
    }

    @Test
    public void totalNotFoundWhenItemPriceNotFound() {
        Result total = cashRegister.total(repository.findPrice("PEACH"), Quantity.valueOf(1.0));
        assertThat(total).isEqualTo(Result.notFound("PEACH"));
    }
}
