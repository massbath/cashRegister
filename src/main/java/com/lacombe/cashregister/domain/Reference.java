package com.lacombe.cashregister.domain;

public class Reference {

    private final String itemCode;
    private final Price price;


    private Reference(String itemCode, Price price) {
        this.itemCode = itemCode;
        this.price = price;
    }


    public Price getPrice() {
        return price;
    }

    public boolean hasSameItemCode(String itemCode) {
        return this.itemCode.equals(itemCode);
    }


    @Override
    public String toString() {
        return "Reference{" +
                "itemCode='" + itemCode + '\'' +
                ", price=" + price +
                '}';
    }


    public static class ReferenceBuilder {
        private String itemCode;
        private Price price;

        public static ReferenceBuilder aReference() {
            return new ReferenceBuilder();
        }

        public ReferenceBuilder withItemCode(String itemCode) {
            this.itemCode = itemCode;
            return this;
        }

        public ReferenceBuilder withUnitPrice(double price) {
            this.price = Price.valueOf(price);
            return this;
        }

        public Reference build() {
            return new Reference(itemCode, price);
        }
    }
}
