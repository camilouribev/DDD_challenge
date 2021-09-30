package com.challenge.carworkshop.domain.repairappointment.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Workshop implements ValueObject<String> {
    public final String location;

    public Workshop(String location) {
        this.location = Objects.requireNonNull(location);

        if(this.location.length() < 3 ){
            throw new IllegalArgumentException("Workshop location must have at least 3 characters");

        }
    }

    public String value() {
        return location;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Workshop workshop = (Workshop) o;
        return Objects.equals(location, workshop.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location);
    }
}

