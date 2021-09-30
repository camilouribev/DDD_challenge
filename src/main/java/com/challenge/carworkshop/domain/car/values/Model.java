package com.challenge.carworkshop.domain.car.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Model implements ValueObject<String> {
    private final String carModel;

    public Model(String carModel) {
        this.carModel = Objects.requireNonNull(carModel);
        if (this.carModel.isBlank() || this.carModel.length() < 3) {
            throw new IllegalArgumentException("Car model must contain at least 3 characters");
        }

        if (this.carModel.isBlank() || this.carModel.length() > 20) {
            throw new IllegalArgumentException("Car model must contain 20 characters at most");
        }
    }

    @Override
    public String value() {
        return carModel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Model model = (Model) o;
        return Objects.equals(carModel, model.carModel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carModel);
    }
}
