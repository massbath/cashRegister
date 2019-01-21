package com.lacombe.cashregister.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemReferenceRepository {

    private List<Reference> references = new ArrayList();


    public ItemReferenceRepository(Reference... references) {
        this.references.addAll(Arrays.asList(references));
    }

    public Result findPrice(String itemCode) {
        for (Reference reference : references) {
            if (reference.hasSameItemCode(itemCode))
                return Result.found(reference.getUnitPrice());
        }
        return Result.notFound(itemCode);
    }
}
