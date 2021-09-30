package com.challenge.carworkshop.domain.repairappointment.commands;

import co.com.sofka.domain.generic.Command;
import com.challenge.carworkshop.domain.repairappointment.values.AppointmentDate;
import com.challenge.carworkshop.domain.repairappointment.values.RepairAppointmentId;

public class ChangeAppointmentDate extends Command {
    private final RepairAppointmentId appointmentId;
    private final AppointmentDate appointmentDate;

    public ChangeAppointmentDate(RepairAppointmentId appointmentId, AppointmentDate appointmentDate) {
        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
    }

    public RepairAppointmentId getAppointmentId() {
        return appointmentId;
    }

    public AppointmentDate getAppointmentDate() {
        return appointmentDate;
    }
}
