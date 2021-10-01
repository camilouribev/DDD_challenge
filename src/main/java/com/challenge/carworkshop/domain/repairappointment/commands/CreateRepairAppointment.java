package com.challenge.carworkshop.domain.repairappointment.commands;

import co.com.sofka.domain.generic.Command;
import com.challenge.carworkshop.domain.car.values.CarId;
import com.challenge.carworkshop.domain.common.values.CarEngineCapacity;
import com.challenge.carworkshop.domain.common.values.InsuredAmount;
import com.challenge.carworkshop.domain.common.values.Name;
import com.challenge.carworkshop.domain.repairappointment.RepairAppointment;
import com.challenge.carworkshop.domain.repairappointment.entities.Invoice;
import com.challenge.carworkshop.domain.repairappointment.entities.Mechanic;
import com.challenge.carworkshop.domain.repairappointment.entities.Service;
import com.challenge.carworkshop.domain.repairappointment.values.*;

import java.util.Set;

public class CreateRepairAppointment extends Command {
    private final RepairAppointmentId entityId;

    private final AppointmentDate date;
    private final Workshop workshop;
    private final AppointmentStatus appointmentStatus;

    public CreateRepairAppointment( RepairAppointmentId entityId, AppointmentDate date, Workshop workshop , AppointmentStatus appointmentStatus) {
        this.entityId = entityId;
        this.date = date;
        this.workshop = workshop;
        this.appointmentStatus = appointmentStatus;

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
