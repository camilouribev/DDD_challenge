package com.challenge.carworkshop.domain.repairappointment.commands;

import co.com.sofka.domain.generic.Command;
import com.challenge.carworkshop.domain.car.values.CarId;
import com.challenge.carworkshop.domain.repairappointment.values.RepairAppointmentId;

public class AssignCarToAppointment extends Command {

    private final RepairAppointmentId appointmentId;
    private final CarId carId;

    public AssignCarToAppointment(RepairAppointmentId appointmentId, CarId carId) {
        this.appointmentId = appointmentId;
        this.carId = carId;
    }

    public RepairAppointmentId getAppointmentId() {
        return appointmentId;
    }

    public CarId getCarId() {
        return carId;
    }
}
