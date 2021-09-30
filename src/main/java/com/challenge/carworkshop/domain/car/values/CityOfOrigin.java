package com.challenge.carworkshop.domain.car.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class CityOfOrigin implements ValueObject<String> {
    private final String city;

    public CityOfOrigin(String city) {
        this.city = Objects.requireNonNull(city);
        if (this.city.isBlank() || this.city.length() < 3) {
            throw new IllegalArgumentException("City of Origin must contain at least 3 characters");
        }

        if (this.city.isBlank() || this.city.length() > 20) {
            throw new IllegalArgumentException("City of Origin must contain 20 characters at most");
        }
    }

    @Override
    public String value() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityOfOrigin that = (CityOfOrigin) o;
        return Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city);
    }
}
