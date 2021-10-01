package com.challenge.carworkshop.domain.common.values;


import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class InsuredAmount implements ValueObject<Integer> {
    private final Integer insuredAmount;

    public InsuredAmount(Integer insuredAmount) {

        this.insuredAmount = Objects.requireNonNull(insuredAmount) ;
        if(this.insuredAmount< 0){
            throw new IllegalArgumentException("Insured amount can't be negative");
        }

    }

    @Override
    public Integer value() {
        return insuredAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InsuredAmount that = (InsuredAmount) o;
        return Objects.equals(insuredAmount, that.insuredAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(insuredAmount);
    }
}
