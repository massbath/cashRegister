package com.lacombe.cashregister;

import com.lacombe.cashregister.domain.ItemReferenceRepository;
import com.lacombe.cashregister.domain.Price;
import com.lacombe.cashregister.domain.Result;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.lacombe.cashregister.domain.Reference.ReferenceBuilder.aReference;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(value = JUnitParamsRunner.class)
public class ItemReferenceRepositoryTest {

    private ItemReferenceRepository itemReferenceRepository = new ItemReferenceRepository(aReference().withItemCode("APPLE").withUnitPrice(1.2).build(), aReference().withItemCode("BANANA").withUnitPrice(1.9).build());


    @Parameters({"APPLE, 1.20", "BANANA,1.90"})
    @Test
    public void findThePriceGiveAnItemCode(String itemCode, double unitPrice) {
        assertThat(itemReferenceRepository.findPrice(itemCode)).isEqualTo(Result.found(Price.valueOf(unitPrice)));
    }

    @Test
    public void searchAnUnknowItem() {
        assertThat(itemReferenceRepository.findPrice("PEACH")).isEqualTo(Result.notFound("PEACH"));

    }
}
