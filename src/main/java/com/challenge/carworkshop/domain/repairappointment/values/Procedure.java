package com.challenge.carworkshop.domain.repairappointment.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;


public class Procedure implements ValueObject<Procedure.Props> {
    private final String type;
    private final Double price;

    public Procedure(String type, Double price) {
        this.type = type;
        this.price = price;

        if(this.type.isBlank() || this.type.length() < 3){
            throw new IllegalArgumentException("Procedure types must have at least three characters");
        }
        if(this.price < 0){
            throw new IllegalArgumentException("Procedure prices can't be negative");
        }
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String type() {
                return type;
            }

            @Override
            public Double price() {
                return price;
            }
        };
    }

    public  interface  Props{
        String type();
        Double price();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Procedure procedure = (Procedure) o;
        return Objects.equals(type, procedure.type) && Objects.equals(price, procedure.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, price);
    }
}
