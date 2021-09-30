package com.challenge.carworkshop.domain.car.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.carworkshop.domain.common.values.Name;

public class ChangedCarOwnerName extends DomainEvent {
    private final Name carOwnerName;

    public ChangedCarOwnerName( Name carOwnerName) {
        super("carworkshop.domain.car.changedcarownername");
        this.carOwnerName = carOwnerName;
    }

    public Name getCarOwnerName() {
        return carOwnerName;
    }
}
