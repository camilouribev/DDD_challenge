package com.challenge.carworkshop.domain.repairappointment.commands;

import co.com.sofka.domain.generic.Command;
import com.challenge.carworkshop.domain.repairappointment.values.RepairAppointmentId;
import com.challenge.carworkshop.domain.repairappointment.values.Workshop;

public class ChangeWorkshop extends Command {
    private final RepairAppointmentId appointmentId;
    private final Workshop workshop;

    public ChangeWorkshop(RepairAppointmentId appointmentId, Workshop workshop) {
        this.appointmentId = appointmentId;
        this.workshop = workshop;
    }

    public RepairAppointmentId getAppointmentId() {
        return appointmentId;
    }

    public Workshop getWorkshop() {
        return workshop;
    }
}
