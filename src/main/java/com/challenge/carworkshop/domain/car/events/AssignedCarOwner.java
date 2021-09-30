package com.challenge.carworkshop.domain.car.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.carworkshop.domain.car.values.CarOwnerId;
import com.challenge.carworkshop.domain.common.values.Name;

public class AssignedCarOwner extends DomainEvent {
    private final CarOwnerId ownerId;
    private final Name ownerName;

    public AssignedCarOwner(CarOwnerId ownerId, Name ownerName) {
        super("carworkshop.domain.car.assignedcarowner");
        this.ownerId = ownerId;
        this.ownerName = ownerName;
    }

    public CarOwnerId getOwnerId() {
        return ownerId;
    }

    public Name getOwnerName() {
        return ownerName;
    }
}
