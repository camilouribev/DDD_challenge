package com.challenge.carworkshop.domain.car.commands;

import co.com.sofka.domain.generic.Command;
import com.challenge.carworkshop.domain.car.values.CarId;
import com.challenge.carworkshop.domain.car.values.CarOwnerId;
import com.challenge.carworkshop.domain.common.values.Name;

public class AssignCarOwner extends Command {
    private final CarId carId;
    private final CarOwnerId ownerId;
    private final Name ownerName;

    public AssignCarOwner(CarId carId, CarOwnerId ownerId, Name ownerName) {
        this.carId = carId;
        this.ownerId = ownerId;
        this.ownerName = ownerName;
    }

    public CarId getCarId() {
        return carId;
    }

    public CarOwnerId getOwnerId() {
        return ownerId;
    }

    public Name getOwnerName() {
        return ownerName;
    }
}
