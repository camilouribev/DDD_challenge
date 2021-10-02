package com.challenge.carworkshop.domain.car.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.carworkshop.domain.car.values.CarId;
import com.challenge.carworkshop.domain.car.values.CarOwnerId;
import com.challenge.carworkshop.domain.common.values.Name;

public class ChangedCarOwnerName extends DomainEvent {
    private final CarId carId;
    private final CarOwnerId carOwnerId;
    private final Name carOwnerName;

    public ChangedCarOwnerName(CarId carId, CarOwnerId carOwnerId, Name carOwnerName) {
        super("carworkshop.domain.car.changedcarownername");
        this.carId = carId;
        this.carOwnerId = carOwnerId;
        this.carOwnerName = carOwnerName;
    }

    public CarId getCarId() {
        return carId;
    }

    public CarOwnerId getCarOwnerId() {
        return carOwnerId;
    }

    public Name getCarOwnerName() {
        return carOwnerName;
    }
}
