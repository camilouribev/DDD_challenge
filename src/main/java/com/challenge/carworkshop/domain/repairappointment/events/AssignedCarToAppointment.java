package com.challenge.carworkshop.domain.repairappointment.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.carworkshop.domain.car.values.CarId;

public class AssignedCarToAppointment extends DomainEvent {
    private final CarId carId;

    public AssignedCarToAppointment( CarId carId) {
        super("carworkshop.domain.repairappointment.assignedcartoappointment");
        this.carId = carId;
    }

    public CarId getCarId() {
        return carId;
    }
}
