package com.challenge.carworkshop.domain.common.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class CarEngineCapacity implements ValueObject<Integer> {
    private final Integer engineVolume;

    public CarEngineCapacity(Integer engineVolume) {
        this.engineVolume = Objects.requireNonNull(engineVolume);

        if(engineVolume < 500 || engineVolume > 8000){
            throw new IllegalArgumentException("Allowed car engine capacities are between 500 and 8000 cc");
        }
    }

    @Override
    public Integer value() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarEngineCapacity that = (CarEngineCapacity) o;
        return Double.compare(that.engineVolume, engineVolume) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(engineVolume);
    }
}
