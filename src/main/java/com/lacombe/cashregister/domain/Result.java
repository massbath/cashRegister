package com.lacombe.cashregister.domain;


import java.util.Objects;

public abstract class Result {

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
    }


    private static class Found extends Result {
        private final Price foundPrice;

        private Found(Price unitPrice) {
            this.foundPrice = unitPrice;
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
    }


}
