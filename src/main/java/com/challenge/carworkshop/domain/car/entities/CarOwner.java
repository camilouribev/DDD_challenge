package com.challenge.carworkshop.domain.car.entities;

import co.com.sofka.domain.generic.Entity;
import com.challenge.carworkshop.domain.car.values.CarOwnerId;
import com.challenge.carworkshop.domain.common.values.Name;

import java.util.Objects;

public class CarOwner extends Entity<CarOwnerId> {
    private Name name;


    public CarOwner(CarOwnerId entityId, Name name) {
        super(entityId);
        this.name = name;
    }

    public Name getName() {
        return name;
    }

    public void changeCarOwnerName(Name name) {
        this.name = Objects.requireNonNull(name) ;
    }
}
