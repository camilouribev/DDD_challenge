package com.challenge.carworkshop.domain.repairappointment.commands;

import co.com.sofka.domain.generic.Command;
import com.challenge.carworkshop.domain.common.values.CarEngineCapacity;
import com.challenge.carworkshop.domain.repairappointment.values.RepairAppointmentId;

public class ChangeCarEngineCapacity extends Command {
    private final RepairAppointmentId appointmentId;
    private final CarEngineCapacity engineCapacity;

    public ChangeCarEngineCapacity(RepairAppointmentId appointmentId, CarEngineCapacity engineCapacity) {
        this.appointmentId = appointmentId;
        this.engineCapacity = engineCapacity;
    }

    public RepairAppointmentId getAppointmentId() {
        return appointmentId;
    }

    public CarEngineCapacity getEngineCapacity() {
        return engineCapacity;
    }
}
