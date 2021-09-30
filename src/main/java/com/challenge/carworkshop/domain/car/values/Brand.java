package com.challenge.carworkshop.domain.car.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Brand implements ValueObject<String> {

    private final String brand;

    public Brand(String brand) {
        this.brand = Objects.requireNonNull(brand);
        if (this.brand.isBlank() || this.brand.length() < 3) {
            throw new IllegalArgumentException("Brand must contain at least 3 characters");
        }

        if (this.brand.isBlank() || this.brand.length() > 20) {
            throw new IllegalArgumentException("Brand must contain 20 characters at most");
        }
    }

    @Override
    public String value() {
        return brand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brand brand1 = (Brand) o;
        return Objects.equals(brand, brand1.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand);
    }
}
