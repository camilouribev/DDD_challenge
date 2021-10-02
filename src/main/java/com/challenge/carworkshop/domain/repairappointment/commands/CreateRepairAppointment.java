package com.challenge.carworkshop.domain.repairappointment.commands;

import co.com.sofka.domain.generic.Command;
import com.challenge.carworkshop.domain.common.values.CarEngineCapacity;
import com.challenge.carworkshop.domain.repairappointment.values.*;

public class CreateRepairAppointment extends Command {
    private final RepairAppointmentId entityId;

    private final AppointmentDate date;
    private final Workshop workshop;
    private final AppointmentStatus appointmentStatus;
    private final CarEngineCapacity engine;

    public CreateRepairAppointment(RepairAppointmentId entityId, AppointmentDate date, Workshop workshop, AppointmentStatus appointmentStatus, CarEngineCapacity engine) {
        this.entityId = entityId;
        this.date = date;
        this.workshop = workshop;
        this.appointmentStatus = appointmentStatus;

        this.engine = engine;
    }

    public CarEngineCapacity getEngine() {
        return engine;
    }

    public RepairAppointmentId getEntityId() {
        return entityId;
    }

    public AppointmentDate getDate() {
        return date;
    }

    public Workshop getWorkshop() {
        return workshop;
    }

    public AppointmentStatus getAppointmentStatus() {
        return appointmentStatus;
    }
}
