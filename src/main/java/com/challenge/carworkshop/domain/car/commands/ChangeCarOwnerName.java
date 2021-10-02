package com.challenge.carworkshop.domain.car.commands;

import co.com.sofka.domain.generic.Command;
import com.challenge.carworkshop.domain.car.values.CarId;
import com.challenge.carworkshop.domain.car.values.CarOwnerId;
import com.challenge.carworkshop.domain.common.values.Name;
import com.challenge.carworkshop.domain.repairappointment.values.MechanicId;
import com.challenge.carworkshop.domain.repairappointment.values.RepairAppointmentId;

public class ChangeCarOwnerName extends Command {
    private final CarId carId;
    private final CarOwnerId carOwnerId;
    private final Name name;

    public ChangeCarOwnerName(CarId carId, CarOwnerId carOwnerId, Name name) {
        this.carId = carId;
        this.carOwnerId = carOwnerId;
        this.name = name;
    }

    public CarId getCarId() {
        return carId;
    }

    public CarOwnerId getCarOwnerId() {
        return carOwnerId;
    }

    public Name getName() {
        return name;
    }
}
