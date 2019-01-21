package com.lacombe.cashregister.domain;


import java.util.Objects;
import java.util.function.UnaryOperator;

public abstract class Result {

    abstract Result map(UnaryOperator<Price> f);

    private Result() {
    }

    public static NotFound notFound(String itemCode) {
        return new NotFound(itemCode);
    }

    public static Result found(Price unitPrice) {
        return new Found(unitPrice);
    }


    public static class NotFound extends Result {
        final String notFoundItemCode;


        private NotFound(String notFoundItemCode) {
            this.notFoundItemCode = notFoundItemCode;
        }

        @Override
        public String toString() {
            return "NotFound{" +
                    "notFoundItemCode='" + notFoundItemCode + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            NotFound notFound = (NotFound) o;
            return Objects.equals(notFoundItemCode, notFound.notFoundItemCode);
        }

        @Override
        public int hashCode() {
            return Objects.hash(notFoundItemCode);
        }

        @Override
        Result map(UnaryOperator<Price> f) {
            return this;
        }
    }


    private static class Found extends Result {
        private final Price foundPrice;

        private Found(Price unitPrice) {
            this.foundPrice = unitPrice;
        }

        public Found multiplyBy(Quantity quantity) {
            return new Found(foundPrice.multiplyBy(quantity));
        }

        @Override
        public String toString() {
            return "Found{" +
                    "foundPrice=" + foundPrice +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Found found = (Found) o;
            return Objects.equals(foundPrice, found.foundPrice);
        }

        @Override
        public int hashCode() {
            return Objects.hash(foundPrice);
        }

        @Override
        Result map(UnaryOperator<Price> f) {
            return Result.found(f.apply(foundPrice));
        }
    }


}
