package com.challenge.carworkshop.domain.common.values;


import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class InsuredAmount implements ValueObject<Double> {
    private final Double insuredAmount;

    public InsuredAmount(Double insuredAmount) {

        this.insuredAmount = Objects.requireNonNull(insuredAmount) ;
        if(this.insuredAmount< 0){
            throw new IllegalArgumentException("Insured amount can't be negative");
        }

    }

    @Override
    public Double value() {
        return insuredAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InsuredAmount that = (InsuredAmount) o;
        return Double.compare(that.insuredAmount, insuredAmount) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(insuredAmount);
    }
}
