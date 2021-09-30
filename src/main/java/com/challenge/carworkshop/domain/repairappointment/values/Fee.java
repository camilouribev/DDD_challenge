package com.challenge.carworkshop.domain.repairappointment.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Fee implements ValueObject<Double> {
    public final Double fee;

    public Fee(Double fee) {
        this.fee = Objects.requireNonNull(fee);
        if(this.fee < 0 ){
            throw new IllegalArgumentException("Service fee can't be negative");

        }
    }

    public Double value() {
        return fee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fee that = (Fee) o;
        return Objects.equals(fee, that.fee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fee);
    }
}
